/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import mortalkombatbversion.Debuf;
import mortalkombatbversion.Fighter;

/**
 *
 * @author Kate Shcherbinina
 */
class EventWeakenDefence implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        if (Math.random() < 0.75) {
            player2.setDebuf(new Debuf(player1.getLevel()));
            return player1.getName() + " weakened " + player2.getName();
        }
        return "";
    }
    
}
