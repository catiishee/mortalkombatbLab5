/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import enemies.Enemy;
import enemies.enemiesFabrics.EnemyFabric;
import java.util.Random;
import mavenproject5.Mediator;

/**
 * Класс CharacterAction отвечает за управление действиями персонажа,
 * противников и логикой игрового процесса.
 * Он обеспечивает взаимодействие между игроком и врагами,
 * а также обновляет состояние игры.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class CharacterAction {
    
    // Массив значений опыта, необходимых для достижения следующего уровня
    private final int experience_for_next_level[] = {40, 90, 180, 260, 410, 1000};
    
    // Массив врагов в игре
    private Enemy enemyes[] = new Enemy[6];
    
    // Фабрика врагов для создания врагов
    EnemyFabric fabric = new EnemyFabric();
    
    // Текущий враг в игре
    private Enemy enemy = null;
    
    // Количество локаций, которые должен пройти игрок
    private int numberOfLocations;
    
    // Количество врагов в текущей локации
    private int numberOfEnemyesInLocation = -1;
    
    // Текущий враг в локации
    private int currentEnemy = 0;
    
    // Текущая локация
    private int currentLocation;
    
    // Объект Mediator для связи между компонентами интерфейса пользователя
    private Mediator mediator;
    
     /**
     * Конструктор класса CharacterAction.
     * Инициализирует объект и задает начальный список врагов.
     *
     * @param mediator объект класса Mediator
     */
    public CharacterAction(Mediator mediator) {
        setEnemyes();
        this.mediator = mediator;
    }
    
    /**
     * Устанавливает количество локаций, которые должен пройти игрок.
     *
     * @param numberOfLocations количество локаций
     */
public void setNumberOfLocations(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
        this.currentLocation = 1;
    }
    
    /**
     * Инициализирует массив врагов с использованием фабрики врагов.
     */
    private void setEnemyes() {
        enemyes[0] = fabric.create(0, 0);
        enemyes[1] = fabric.create(1, 0);
        enemyes[2] = fabric.create(2, 0);
        enemyes[3] = fabric.create(3, 0);
        enemyes[4] = fabric.create(4, 0);
        enemyes[5] = fabric.create(4, 0);
    }
    
    /**
     * Возвращает массив врагов.
     *
     * @return массив врагов
     */
    public Fighter[] getEnemyes() {
        return this.enemyes;
    }
    
    /**
     * Выбирает врага на основе текущего уровня и состояния локации.
     * Если все враги побеждены, начинается новая локация.
     * Если текущий враг является последним в локации, выбирается босс.
     *
     * @param level текущий уровень игрока
     * @return объект врага
     */
    public Enemy chooseEnemy(int level) {
        if (currentEnemy > numberOfEnemyesInLocation) {
            startNewLocation(level);
        }
        if (currentEnemy == numberOfEnemyesInLocation) {
            return chooseBoss();
        }
        int i = (int) (Math.random() * 4);
        enemy = enemyes[i];
        return enemy;
    }
    
    /**
     * Возвращает босса для текущей локации.
     *
     * @return объект босса
     */
    private Enemy chooseBoss() {
        enemy = enemyes[4];
        return enemy;
    }
    
    /**
     * Добавляет очки и опыт игроку в зависимости от его уровня
     * после победы над врагом.
     *
     * @param human объект игрока
     */
    public void addPoints(Player human) {
        switch (human.getLevel()) {
            case 0:
                human.setExperience(20);
                human.setPoints(25 + human.getHealth() / 4);
                break;
            case 1:
                human.setExperience(25);
                human.setPoints(30 + human.getHealth() / 4);
                break;
            case 2:
                human.setExperience(30);
                human.setPoints(35 + human.getHealth() / 4);
                break;
            case 3:
                human.setExperience(40);
                human.setPoints(45 + human.getHealth() / 4);
                break;
            case 4:
                human.setExperience(50);
                human.setPoints(55 + human.getHealth() / 4);
                break;
        }

        checkLevelUp(human);
    }
    
    /**
     * Добавляет очки и опыт игроку за победу над боссом.
     *
     * @param human объект игрока
     */
    public void addPointsBoss(Player human) {

        human.setExperience(50);
        human.setPoints(65 + human.getHealth() / 2);

        checkLevelUp(human);
    }
    
    /**
     * Проверяет, достиг ли игрок следующего уровня,
     * и если да, повышает уровень, обновляет характеристики
     * и показывает диалог об уровне.
     *
     * @param human объект игрока
     */
    private void checkLevelUp(Player human) {
        boolean levelUp = false;

        for (int i = 5; i >= human.getLevel(); i--) {
            if (experience_for_next_level[i] <= human.getExperience()) {
                human.setLevel();
                human.setNextExperience(experience_for_next_level[i + 1]);
                mediator.showLevelUp();
                levelUp = true;
                newHealthHuman(human);
                for (int j = 0; j < 4; j++) {
                    newHealthEnemy(enemyes[j], human);
                }
                break;
            }
        }
        if (!levelUp) {
            mediator.showEndRound("You win");
        }

    }
    
    /**
     * Добавляет предметы игроку с вероятностью выпадения,
     * основанной на характеристиках врага.
     *
     * @param enemy объект врага
     * @param items массив предметов
     */
    public void addItems(Enemy enemy, Items[] items) {
        Random random = new Random();
        for (int i = 0; i < enemy.getRewardsProbability().length; i++) {
            int chance = random.nextInt(100);
            if (chance < enemy.getRewardsProbability()[i]) {
                items[i].setCount(1);
                return;
            }
        }
        mediator.updateInventory(items);
    }
    
    /**
     * Инициализирует новую локацию, задавая количество врагов
     * в зависимости от уровня игрока.
     *
     * @param playerLevel текущий уровень игрока
     */
    public void startNewLocation(int playerLevel) {
        currentLocation++;
        numberOfEnemyesInLocation = (int) (playerLevel + 1 + Math.random() * 2);
        currentEnemy = 0;
    }
    
    /**
     * Проверяет, является ли текущий раунд финальным.
     *
     * @return true, если текущий раунд финальный, иначе false
     */
    public boolean isFinalRound() {
        return currentLocation >= numberOfLocations && currentEnemy >= numberOfEnemyesInLocation;
    }
    
    /**
     * Переходит к следующему врагу.
     */
    public void nextEnemy() {
        currentEnemy++;
    }
    
    /**
     * Обновляет здоровье и урон игрока при повышении уровня.
     *
     * @param human объект игрока
     */
    private void newHealthHuman(Player human) {
        int hp = 0;
        int damage = 0;
        switch (human.getLevel()) {
            case 1:
                hp = 25;
                damage = 3;
                break;
            case 2:
                hp = 30;
                damage = 3;
                break;
            case 3:
                hp = 30;
                damage = 4;
                break;
            case 4:
                hp = 40;
                damage = 6;
                break;
        }
        human.setMaxHealth(hp);
        human.setDamage(damage);
    }
    
    /**
     * Обновляет здоровье и урон врагов в зависимости от уровня игрока.
     *
     * @param enemy объект врага
     * @param human объект игрока
     */
    private void newHealthEnemy(Fighter enemy, Player human) {
        int hp = 0;
        int damage = 0;
        switch (human.getLevel()) {
            case 1:
                hp = 32;
                damage = 25;
                break;
            case 2:
                hp = 30;
                damage = 20;
                break;
            case 3:
                hp = 23;
                damage = 24;
                break;
            case 4:
                hp = 25;
                damage = 26;
                break;
        }
        enemy.setMaxHealth((int) enemy.getMaxHealth() * hp / 100);
        enemy.setDamage((int) enemy.getDamage() * damage / 100);
        enemy.setLevel();
    }
    
    /**
     * Использует предмет из инвентаря игрока. Если предмет не может быть использован,
     * показывает сообщение об ошибке.
     *
     * @param human объект игрока
     * @param items массив предметов
     * @param id    идентификатор предмета
     */
    public void useItem(Fighter human, Items[] items, int id) {
        if (id != 2 && items[id].getCount() > 0) {
            switch (id) {
                case 0:
                    human.setHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(items[0].getCount() - 1);

                    break;
                case 1:
                    human.setHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(items[1].getCount() - 1);

                    break;
            }

            mediator.closeInventory();
            mediator.updateInventory(items);

        } else {
            mediator.showCanNotUseItem();
        }
    }
}
