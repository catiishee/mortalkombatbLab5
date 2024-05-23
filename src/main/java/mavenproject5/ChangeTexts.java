/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mavenproject5;

import mortalkombatbversion.Human;
import mortalkombatbversion.Items;
import mortalkombatbversion.Player;

/**
 *
 * @author
 */
public class ChangeTexts {

    public void NewRoundTexts(Player human, Player enemy, GuiUpdate guiUpdate, Items[] items, int i) {
        guiUpdate.setLabel17Text(Integer.toString(((Human) human).getPoints()));
        guiUpdate.setLabel16Text(Integer.toString(((Human) human).getExperience()) + "/" + ((Human) human).getNextExperience());
        guiUpdate.setLabel6Text(Integer.toString(human.getLevel()) + " level");
        guiUpdate.setLabel19Text(Integer.toString(enemy.getLevel()) + " level");
        guiUpdate.setLabel12Text(Integer.toString(human.getMaxHealth()) + "/" + Integer.toString(human.getMaxHealth()));
        guiUpdate.setLabel13Text(Integer.toString(enemy.getMaxHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        guiUpdate.setLabel9Text(Integer.toString(human.getDamage()));
        if (i % 2 == 1) {
            guiUpdate.setLabel29Text("Your turn");
        } else {
            guiUpdate.setLabel29Text(enemy.getName() + "'s turn");
        }
        BagText(items, guiUpdate);
        guiUpdate.setFightEventOutput("");
        guiUpdate.setEnemyMaxHealth(enemy.getMaxHealth());
        guiUpdate.setHumanMaxHealth(human.getMaxHealth());
        guiUpdate.setEnemyHealth(enemy.getMaxHealth());
        guiUpdate.setHumanHealth(human.getMaxHealth());
    }

    public void RoundTexts(Player human, Player enemy, GuiUpdate guiUpdate, int i) {
        if (enemy.getHealth() >= 0) {
            guiUpdate.setLabel13Text(Integer.toString(enemy.getHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        } else {
            guiUpdate.setLabel13Text("0/" + Integer.toString(enemy.getMaxHealth()));
        }
        if (human.getHealth() >= 0) {
            guiUpdate.setLabel12Text(Integer.toString(human.getHealth()) + "/" + Integer.toString(human.getMaxHealth()));
        } else {
            guiUpdate.setLabel12Text("0/" + Integer.toString(human.getMaxHealth()));
        }
        if (i % 2 == 1) {
            guiUpdate.setLabel29Text("Your turn");
        } else {
            guiUpdate.setLabel29Text(enemy.getName() + "'s turn");
        }
    }

    public void BagText(Items[] items, GuiUpdate guiUpdate) {
        guiUpdate.setRb1(items[0].getName() + ", " + items[0].getCount() + " шт");
        guiUpdate.setRb2(items[1].getName() + ", " + items[1].getCount() + " шт");
        guiUpdate.setRb3(items[2].getName() + ", " + items[2].getCount() + " шт");
    }
}
