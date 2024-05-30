/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import mortalkombatbversion.Fighter;

/**
 *
 * @author Kate Shcherbinina
 */
class EventHealDefence implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        player1.setHealth((int) ((player1.getMaxHealth() - player1.getHealth()) * 0.5));
        return player1.getName() + " healed";
    }
    
}
