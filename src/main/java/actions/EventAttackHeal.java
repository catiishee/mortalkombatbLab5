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
class EventAttackHeal implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        player2.removeHealth(player1.getDamage() * 2);
        return player1.getName() + " attacked";
    }
    
}
