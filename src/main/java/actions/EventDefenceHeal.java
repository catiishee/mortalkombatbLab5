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
class EventDefenceHeal implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        player2.setHealth((int) ((player2.getMaxHealth() - player2.getHealth()) * 0.5));
        return player2.getName() + " healed";
    }
    
}
