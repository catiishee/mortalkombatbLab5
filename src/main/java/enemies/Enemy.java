/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mortalkombatbversion.Fighter;

/**
 * Абстрактный класс Enemy представляет врага в игре.
 * Включает методы для установки поведения врага, выбора следующей атаки,
 * сброса атак и определения вероятности получения наград.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public abstract class Enemy extends Fighter {

    int kind_attack[] = {0};
    int k = -1;
    List<EnemyBehavior> enemyBehaviors = new ArrayList<>();
    int[] rewardsProbability =  new int[]{25, 15, 5};
    
    /**
     * Конструктор класса Enemy.
     * 
     * @param level уровень врага
     * @param health здоровье врага
     * @param damage урон врага
     * @param attack атака врага
     * @param name имя врага
     * @param image изображение врага
     */
    public Enemy(int level, int health, int damage, int attack, String name, String image) {
        super(level, health, damage, attack, name, image);
    }
    
    /**
     * Устанавливает список поведений врага.
     * 
     * @param enemyBehaviors список объектов EnemyBehavior
     */
    public void setEnemyBehaviors(List<EnemyBehavior> enemyBehaviors) {
        this.enemyBehaviors = enemyBehaviors;
    }
    
    /**
     * Устанавливает следующую атаку врага на основе текущего поведения.
     */
    public void setNextAttack() {
        if (k < kind_attack.length - 1) {
            k++;
        } else {
            kind_attack = chooseBehavior();
            k = 0;
        }

        setAttack(kind_attack[k]);
    }
    
    /**
     * Выбирает поведение врага на основе вероятностей.
     * 
     * @return массив атак, соответствующий выбранному поведению
     */
    int[] chooseBehavior() {
        int totalProbability = 0;
        for (EnemyBehavior behavior : enemyBehaviors) {
            totalProbability += behavior.getProbability();
        }

        int randomValue = new Random().nextInt(totalProbability);
        int cumulativeProbability = 0;

        for (EnemyBehavior behavior : enemyBehaviors) {
            cumulativeProbability += behavior.getProbability();
            if (randomValue < cumulativeProbability) {
                return behavior.getAttacks();
            }
        }

        return enemyBehaviors.get(0).getAttacks();
    }
    
    /**
     * Сбрасывает атаки врага к начальному состоянию.
     */
    public void ResetAttack() {
        kind_attack = new int[]{0};
        k = -1;
    }
    
    /**
     * Возвращает массив вероятностей получения наград.
     * 
     * @return массив вероятностей получения наград
     */
    public int[] getRewardsProbability() {
        return rewardsProbability;
    }
    
    /**
     * Устанавливает массив вероятностей получения наград.
     * 
     * @param rewardsProbability массив вероятностей получения наград
     */
    public void setRewardsProbability(int[] rewardsProbability) {
        this.rewardsProbability = rewardsProbability;
    }
    
    
}
