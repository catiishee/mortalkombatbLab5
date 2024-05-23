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
class EventAttackAttack implements FightEvent {
    
    @Override
    public String executeEvent(Player player1, Player player2) {
        player2.removeHealth(player1.getDamage());
        return player1.getName() + " attacked";
    }
    
}