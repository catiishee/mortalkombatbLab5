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
class EventDefenceWeaken implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        if (Math.random() < 0.75) {
            player1.setDebuf(new Debuf(player2.getLevel()));
            return player2.getName() + " weakened " + player1.getName();
        }
        return "";
    }
    
}
