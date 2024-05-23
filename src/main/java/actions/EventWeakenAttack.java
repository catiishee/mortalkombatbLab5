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
class EventWeakenAttack implements FightEvent {
    
    @Override
    public String executeEvent(Player player1, Player player2) {
        player1.removeHealth((int) (player2.getDamage() * 1.15));
        return player2.getName() + " attacked " + player1.getName();
    }
    
}
