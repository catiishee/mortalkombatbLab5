/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actions;

import mortalkombatbversion.Fighter;

/**
 * Класс EventBuilder отвечает за создание объектов, реализующих интерфейс FightEvent,
 * в зависимости от комбинации атак и защит игроков.
 * 
 * @autor Kate Shcherbinina
 * @since 1.0
 */
public class EventBuilder {
    
    /**
     * Метод build создает объект, реализующий интерфейс FightEvent,
     * в зависимости от комбинации атак и защит игроков.
     *
     * @param player1 первый игрок (или атакующий)
     * @param player2 второй игрок (или защищающийся)
     * @param stun флаг, указывающий на оглушение первого игрока
     * @return объект, реализующий интерфейс FightEvent
     * @throws IllegalArgumentException если комбинация действий игроков недопустима
     */
    public FightEvent build(Fighter player1, Fighter player2, boolean stun) {
        if (stun) {
            player1.setAttack(-1);

        }
        String actionKey = Integer.toString(player1.getAttack()) + Integer.toString(player2.getAttack());

        switch (actionKey) {
            case "10":
                return new EventAttackDefence();
            case "11":
                return new EventAttackAttack();
            case "00":
                return new EventDefenceDefence(stun);
            case "01":
                return new EventDefenceAttack();
            case "-10":
                return new EventStunDefence(stun);
            case "-11":
                return new EventStunAttack(stun);
            case "20":
                return new EventWeakenDefence();
            case "02":
            case "-12":
                return new EventDefenceWeaken();
            case "12":
                return new EventAttackWeaken();
            case "21":
                return new EventWeakenAttack();
            case "30":
            case "32":
                return new EventHealDefence();
            case "03":
            case "23":
            case "-13":
                return new EventDefenceHeal();
            case "13":
                return new EventAttackHeal();
            case "31":
                return new EventHealAttack();
            default:
                throw new IllegalArgumentException("Invalid actions combination");
        }

    }

}
