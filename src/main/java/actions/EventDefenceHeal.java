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
class EventDefenceHeal implements FightEvent {
    
    @Override
    public String executeEvent(Player player1, Player player2) {
        player2.setHealth((int) ((player2.getMaxHealth() - player2.getHealth()) * 0.5));
        return player2.getName() + " healed";
    }
    
}
