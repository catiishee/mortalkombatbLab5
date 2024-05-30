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
class EventAttackWeaken implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        player2.removeHealth((int) (player1.getDamage() * 1.15));
        return player1.getName() + " attacked " + player2.getName();
    }
    
}
