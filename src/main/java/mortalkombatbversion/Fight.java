/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import mavenproject5.GuiUpdate;
import actions.EventBuilder;
import actions.FightEvent;
import mavenproject5.ChangeTexts;
import enemies.ShaoKahn;
import enemies.enemiesFabrics.EnemyFabric;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author
 */
public class Fight {

    ChangeTexts change = new ChangeTexts();
    int kind_attack[] = {0};
    int experiences[] = {40, 90, 180, 260, 410};
    EnemyFabric fabric = new EnemyFabric();
    public int i = 1;
    int k = -1;
    int stun = 0;
    double v = 0.0;
    boolean endRound = false;

    public boolean isEndRound() {
        return endRound;
    }

    public void setEndRound(boolean endRound) {
        this.endRound = endRound;
    }

    public String Move(Player p1, Player p2) {

        EventBuilder eventBuilder = new EventBuilder();
        FightEvent fightEvent = eventBuilder.build(p1, p2, stun == 1);
        String output = fightEvent.executeEvent(p1, p2);
        p1.nextTurn();
        p2.nextTurn();
        return output;
    }

    public GuiUpdate Hit(Player human, Player enemy, int a, CharacterAction action, Items[] items, ArrayList<Result> results) {
        GuiUpdate guiUpdate = new GuiUpdate();

        human.setAttack(a);

        if (k < kind_attack.length - 1) {
            k++;
        } else {
            kind_attack = action.ChooseBehavior(enemy);
            k = 0;
        }

        enemy.setAttack(kind_attack[k]);

        String output;
        if (i % 2 == 1) {
            output = Move(human, enemy);
        } else {
            output = Move(enemy, human);
        }
        guiUpdate.setFightEventOutput(output);

        i++;

        ChangeTexts change = new ChangeTexts();
        change.RoundTexts(human, enemy, guiUpdate, i);

        guiUpdate.setPr1Value(human.getHealth());
        guiUpdate.setPr2Value(enemy.getHealth());

        if (human.getHealth() <= 0 && items[2].getCount() > 0) {
            human.setNewHealth((int) (human.getMaxHealth() * 0.05));
            items[2].setCount(items[2].getCount() - 1);
            guiUpdate.setPr1Value(human.getHealth());
            guiUpdate.setLabel12Text(human.getHealth() + "/" + human.getMaxHealth());
            guiUpdate.setLabel26Text("Вы воскресли");
        }

        if (human.getHealth() <= 0 || enemy.getHealth() <= 0) {
            if (action.isFinalRound()) {
                GuiUpdate finalRoundGuiUpdate = EndFinalRound((Human) human, action, results);
                guiUpdate.merge(finalRoundGuiUpdate); // Assuming merge method merges fields from another GuiUpdate
            } else {
                GuiUpdate roundGuiUpdate = EndRound(human, enemy, action, items);
                guiUpdate.merge(roundGuiUpdate); // Assuming merge method merges fields from another GuiUpdate
            }
        }

        return guiUpdate;
    }

    public GuiUpdate EndRound(Player human, Player enemy, CharacterAction action, Items[] items) {
        GuiUpdate guiUpdate = new GuiUpdate();
        endRound = true;

        if (human.getHealth() > 0) {
            guiUpdate.setLabel18Text("You win");
            action.nextEnemy();

            if (enemy instanceof ShaoKahn) {
                action.AddItems(38, 23, 8, items);
                action.AddPointsBoss(((Human) human), guiUpdate);
            } else {
                action.AddItems(25, 15, 5, items);
                action.AddPoints(((Human) human), guiUpdate);
            }
        } else {
            guiUpdate.setLabel18Text(enemy.getName() + " win");
            guiUpdate.setShowDialog(true);
            guiUpdate.setDialogBounds(new Rectangle(300, 150, 700, 600));
        }

        i = 1;
        k = -1;
        kind_attack = ResetAttack();

        return guiUpdate;
    }

    public GuiUpdate EndFinalRound(Human human, CharacterAction action, ArrayList<Result> results) {
        GuiUpdate guiUpdate = new GuiUpdate();
        String text = "Победа не на вашей стороне";

        if (human.getHealth() > 0) {
            action.AddPoints(human, guiUpdate);
            text = "Победа на вашей стороне";
        }

        boolean top = false;
        if (results == null) {
            top = true;
        } else {
            int i = 0;
            for (Result result : results) {
                if (human.getPoints() < result.getPoints()) {
                    i++;
                }
            }
            if (i < 10) {
                top = true;
            }
        }

        if (top) {
            guiUpdate.setShowDialog1(true);
            guiUpdate.setDialog1Bounds(new Rectangle(150, 150, 600, 500));
            guiUpdate.setLabel24Text(text);
        } else {
            guiUpdate.setShowDialog2(true);
            guiUpdate.setDialog2Bounds(new Rectangle(150, 150, 470, 360));
            guiUpdate.setLabel24Text(text);
        }

        guiUpdate.setDisposeFrame(true);
        return guiUpdate;
    }

    public int[] ResetAttack() {
        int a[] = {0};
        return a;
    }

    public Player NewRound(Player human, CharacterAction action, GuiUpdate guiUpdate) {
        Player enemy1 = action.ChooseEnemy(human.getLevel(), guiUpdate);
        guiUpdate.setHumanMaxHealth(human.getMaxHealth());
        guiUpdate.setEnemyMaxHealth(enemy1.getMaxHealth());

        human.setNewHealth(human.getMaxHealth());
        enemy1.setNewHealth(enemy1.getMaxHealth());
        guiUpdate.setPr1Value(human.getHealth());
        guiUpdate.setPr2Value(enemy1.getHealth());
        return enemy1;
    }

}
