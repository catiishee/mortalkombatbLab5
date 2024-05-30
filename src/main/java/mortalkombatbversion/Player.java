/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

/**
 * Класс Player представляет игрока в игре.
 * Игрок имеет уровень, здоровье, урон, очки, опыт и следующую цель по опыту.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class Player extends Fighter {

    private int points;
    private int experience;
    private int nextexperience;
    
    /**
     * Конструктор для создания объекта игрока.
     *
     * @param level начальный уровень игрока
     * @param health начальное здоровье игрока
     * @param damage начальный урон игрока
     */
    public Player(int level, int health, int damage) {
        super(level, health, damage, -1, "Kitana", "src/main/resources/Kitana.jpg");
        this.points = 0;
        this.experience = 0;
        this.nextexperience = 40;
    }

    public int getPoints() {
        return this.points;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getNextExperience() {
        return this.nextexperience;
    }

    public void setPoints(int p) {
        this.points += p;
    }

    public void setExperience(int e) {
        this.experience += e;
    }

    public void setNextExperience(int e) {
        this.nextexperience = e;
    }

    @Override
    public String getName() {
        return "You";
    }

}
