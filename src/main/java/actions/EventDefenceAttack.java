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
class EventDefenceAttack implements FightEvent {
    
    @Override
    public String executeEvent(Player player1, Player player2) {
        return player1.getName() + " didn't attack";
    }
    
}
