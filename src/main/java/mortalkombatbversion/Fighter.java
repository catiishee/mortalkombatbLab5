/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import javax.swing.ImageIcon;

/**
 *
 * @author Kate Shcherbinina
 */
public class Fighter {

    private int level;
    private int health;
    private int maxhealth;
    private int damage;
    private int attack;
    private Debuf debuf;
    private String name;
    private String image;

    public Fighter(int level, int health, int damage, int attack, String name, String image) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.attack = attack;
        this.maxhealth = health;
        this.name = name;
        this.image =  image;
    }

    public void setLevel() {
        this.level++;
    }

    public void setHealth(int h) {
        this.health += h;
    }
    
    public void removeHealth(int damage){
        int damage1 = damage;
        if(debuf != null){
            damage1 *= 1 + debuf.getDefenceWeaken();
        }
        if(health - damage1 < 0){
            health = 0;
        } else{
            health -= damage1;
        }
    }

    public void setNewHealth(int h) {
        this.health = h;
    }

    public void setDamage(int d) {
        this.damage += d;
    }

    public void setAttack(int a) {
        this.attack = a;
    }

    public void setMaxHealth(int h) {
        this.maxhealth += h;
    }

    public void setDebuf(Debuf debuf) {
        this.debuf = debuf;
    }

    public int getLevel() {
        return this.level;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        if(debuf != null){
            return (int) (this.damage * (1 - debuf.getAttackWeaken()));
        }
        return this.damage;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getMaxHealth() {
        return this.maxhealth;
    }

    public int getMaxhealth() {
        return maxhealth;
    }

    public void setMaxhealth(int maxhealth) {
        this.maxhealth = maxhealth;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void nextTurn(){
        if(debuf == null){
            return;
        }
        debuf.nextTurn();
        if(debuf.getTurns() <= 0){
            debuf = null;
        }
    }
    
    
}
