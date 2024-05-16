/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

/**
 *
 * @author
 */
public class Player {

    private int level;
    private int health;
    private int maxhealth;
    private int damage;
    private int attack;
    private Debuf debuf;

    public Player(int level, int health, int damage, int attack) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.attack = attack;
        this.maxhealth = health;
    }

    public void setLevel() {
        this.level++;
    }

    public void setHealth(int h) {
        this.health += h;
    }
    
    public void removeHealth(int damage){
        if(debuf != null){
            health -= damage * (1 + debuf.getDefenceWeaken());
        } else{
            health -= damage;
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

    public String getName() {
        return "";
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
