/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

/**
 *
 * @author Kate Shcherbinina
 */
public class Debuf {
    
    int turns;

    public Debuf(int turns) {
        this.turns = turns;
    }
    
    public double getAttackWeaken(){
        return 0.5;
    }
    
    public double getDefenceWeaken(){
        return 0.25;
    }
    
    public void nextTurn(){
        turns--;
    }

    public int getTurns() {
        return turns;
    }
}
