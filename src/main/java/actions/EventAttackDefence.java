/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import enemies.ShaoKahn;
import mortalkombatbversion.Fighter;

/**
 *
 * @author Kate Shcherbinina
 */
class EventAttackDefence implements FightEvent {
    
    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        double v = Math.random();
        if (player1 instanceof ShaoKahn && v < 0.15) {
            player2.removeHealth((int) (player1.getDamage() * 0.5));
            return "Your block is broken";
        } else {
            player1.removeHealth((int) (player2.getDamage() * 0.5));
            return player2.getName() + " counterattacked";
        }
    }
    
}
