/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import mortalkombatbversion.Player;

/**
 *
 * @author user
 */
class EventAttackWeaken implements FightEvent {
    
    @Override
    public String executeEvent(Player player1, Player player2) {
        player2.removeHealth((int) (player1.getDamage() * 1.15));
        return player1.getName() + " attacked " + player2.getName();
    }
    
}
