/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import actions.EventBuilder;
import actions.FightEvent;
import enemies.Enemy;
import enemies.ShaoKahn;
import java.util.ArrayList;
import mavenproject5.Mediator;

/**
 * Класс Fight отвечает за проведение боевых действий между игроком и противниками.
 * Он управляет ходами, вычисляет результаты атак и обороны, а также завершает раунды.
 *
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class Fight {
    
    // Индекс текущего хода
    public int i = 1;
    
    // Переменная оглушения
    int stun = 0;
    
    // Флаг, указывающий на завершение раунда
    boolean endRound = false;
    
    // Объект Mediator для связи между компонентами интерфейса пользователя
    Mediator mediator;
    
    /**
     * Конструктор класса Fight.
     * Инициализирует объект и задает медиатор.
     *
     * @param mediator объект класса Mediator
     */
    public Fight(Mediator mediator) {
        this.mediator = mediator;
    }
    
    /**
     * Проверяет, завершен ли раунд.
     *
     * @return true, если раунд завершен, иначе false
     */
    public boolean isEndRound() {
        return endRound;
    }
    
    /**
     * Устанавливает флаг завершения раунда.
     *
     * @param endRound значение флага завершения раунда
     */
    public void setEndRound(boolean endRound) {
        this.endRound = endRound;
    }
    
    /**
     * Выполняет ход игрока, вычисляет результат взаимодействия с противником.
     *
     * @param p1 игрок
     * @param p2 противник
     * @return строка с результатом взаимодействия
     */
    public String movePlayer(Fighter p1, Fighter p2) {

        EventBuilder eventBuilder = new EventBuilder();
        FightEvent fightEvent = eventBuilder.build(p1, p2, stun == 1);
        String output = fightEvent.executeEvent(p1, p2);
        p1.nextTurn();
        p2.nextTurn();
        return output;
    }
    
    /**
     * Обрабатывает атаку игрока, вычисляет результат боя и обновляет интерфейс.
     *
     * @param human игрок
     * @param enemy противник
     * @param a     тип атаки
     * @param action объект CharacterAction
     * @param items массив предметов
     * @param results список результатов
     */
    public void hitPlayer(Player human, Enemy enemy, int a, CharacterAction action, Items[] items, ArrayList<Result> results) {

        human.setAttack(a);
        enemy.setNextAttack();

        String output;
        String turnText;
        if (i % 2 == 1) {
            output = movePlayer(human, enemy);
            turnText = enemy.getName() + "'s turn";
        } else {
            output = movePlayer(enemy, human);
            turnText = "Your turn";
        }

        i++;
        
        if (human.getHealth() <= 0 && items[2].getCount() > 0) {
            human.setNewHealth((int) (human.getMaxHealth() * 0.05));
            items[2].setCount(items[2].getCount() - 1);
            mediator.updateRespawnText("Вы воскресли");
        }

        if (human.getHealth() <= 0 || enemy.getHealth() <= 0) {
            if (action.isFinalRound()) {
                endFinalRound(human, action, results);
            } else {
                endRound(human, enemy, action, items);
            }
        }
        
        mediator.updatePlayer(human);
        mediator.updateEnemy(enemy);
        mediator.updateFightEvent(output,turnText);

    }
    
    /**
     * Завершает текущий раунд, обновляет состояние игрока и врага.
     *
     * @param human игрок
     * @param enemy противник
     * @param action объект CharacterAction
     * @param items массив предметов
     */
    public void endRound(Player human, Enemy enemy, CharacterAction action, Items[] items) {
        endRound = true;

        if (human.getHealth() > 0) {
            action.nextEnemy();
            action.addItems(enemy, items);

            if (enemy instanceof ShaoKahn) {
                action.addPointsBoss(human);
            } else {
                action.addPoints(human);
            }
        } else {
            mediator.showEndRound(enemy.getName() + " win");
        }
        
        i = 1;
        enemy.ResetAttack();
    }
    
    /**
     * Завершает финальный раунд, обновляет результаты и отображает их.
     *
     * @param human игрок
     * @param action объект CharacterAction
     * @param results список результатов
     */
    public void endFinalRound(Player human, CharacterAction action, ArrayList<Result> results) {
        boolean win = human.getHealth() > 0;

        if (win) {
            action.addPoints(human);
        }

        boolean top = false;
        if (results == null) {
            top = true;
        } else {
            int i = 0;
            for (Result result : results) {
                if (human.getPoints() < result.getPoints()) {
                    i++;
                }
            }
            if (i < 10) {
                top = true;
            }
        }

        mediator.showEndFinalRound(top, win);
    }
    
    /**
     * Начинает новый раунд, выбирает нового врага и обновляет интерфейс.
     *
     * @param human игрок
     * @param action объект CharacterAction
     * @return объект врага
     */
    public Enemy newRound(Player human, CharacterAction action) {
        Enemy enemy = action.chooseEnemy(human.getLevel());
        human.setNewHealth(human.getMaxHealth());
        enemy.setNewHealth(enemy.getMaxHealth());
        mediator.updateEnemy(enemy);
        mediator.updatePlayer(human);
        mediator.updateFightEvent("","Your turn" );
        return enemy;
    }

}
