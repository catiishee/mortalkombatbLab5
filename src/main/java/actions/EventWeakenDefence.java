/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import mortalkombatbversion.Debuf;
import mortalkombatbversion.Player;

/**
 *
 * @author user
 */
class EventWeakenDefence implements FightEvent {
    
    @Override
    public String executeEvent(Player player1, Player player2) {
        if (Math.random() < 0.75) {
            player2.setDebuf(new Debuf(player1.getLevel()));
            return player1.getName() + " weakened " + player2.getName();
        }
        return "";
    }
    
}
