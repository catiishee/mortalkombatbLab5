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
class EventStunAttack implements FightEvent {
    
    private boolean stun;

    EventStunAttack(boolean stun) {
        this.stun = stun;
    }

    @Override
    public String executeEvent(Player player1, Player player2) {
        player1.removeHealth(player2.getDamage());
        stun = false;
        return player1.getName() + " was stunned. " + player2.getName() + " attacked";
    }
    
}
