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
class EventDefenceDefence implements FightEvent {
    
    private boolean stun;

    EventDefenceDefence(boolean stun) {
        this.stun = stun;
    }

    @Override
    public String executeEvent(Fighter player1, Fighter player2) {
        if (Math.random() <= 0.5) {
            stun = true;
        }
        return "Both defended themselves";
    }
    
}
