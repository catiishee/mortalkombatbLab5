/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies;

/**
 * Класс EnemyBehavior представляет собой поведение врага в бою,
 * включающее в себя массив атак и вероятность выбора этого поведения.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class EnemyBehavior {
    private int[] attacks;
    private int probability;
    
    /**
     * Конструктор класса EnemyBehavior.
     * 
     * @param attacks массив атак, которые враг может выполнить
     * @param probability вероятность выбора данного поведения
     */
    public EnemyBehavior(int[] attacks, int probability) {
        this.attacks = attacks;
        this.probability = probability;
    }
    
    /**
     * Возвращает массив атак, которые враг может выполнить.
     * 
     * @return массив атак
     */
    public int[] getAttacks() {
        return attacks;
    }
    
    /**
     * Устанавливает массив атак, которые враг может выполнить.
     * 
     * @param attacks массив атак
     */
    public void setAttacks(int[] attacks) {
        this.attacks = attacks;
    }
    
    /**
     * Возвращает вероятность выбора данного поведения.
     * 
     * @return вероятность выбора поведения
     */
    public int getProbability() {
        return probability;
    }
    
    /**
     * Устанавливает вероятность выбора данного поведения.
     * 
     * @param probability вероятность выбора поведения
     */
    public void setProbability(int probability) {
        this.probability = probability;
    }
    
}
