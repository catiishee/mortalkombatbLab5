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
class EventDefenceDefence implements FightEvent {
    
    private boolean stun;

    EventDefenceDefence(boolean stun) {
        this.stun = stun;
    }

    @Override
    public String executeEvent(Player player1, Player player2) {
        if (Math.random() <= 0.5) {
            stun = true;
        }
        return "Both defended themselves";
    }
    
}
