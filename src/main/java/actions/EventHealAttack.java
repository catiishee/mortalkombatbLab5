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
class EventHealAttack implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        player1.removeHealth(player2.getDamage() * 2);
        return player2.getName() + " attacked";
    }
    
}
