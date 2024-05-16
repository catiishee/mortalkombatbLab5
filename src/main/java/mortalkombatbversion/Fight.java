/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import mavenproject5.ChangeTexts;
import enemies.ShaoKahn;
import enemies.enemiesFabrics.EnemyFabric;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

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

    public void Move(Player p1, Player p2, JLabel l, JLabel l2) {

        if (stun == 1) {
            p1.setAttack(-1);

        }

        // 2 - ослабление 
        // 3 - лечение 
        switch (Integer.toString(p1.getAttack()) + Integer.toString(p2.getAttack())) {
            case "10": // атака - защита
                v = Math.random();
                if (p1 instanceof ShaoKahn & v < 0.15) {
                    p2.removeHealth((int) (p1.getDamage() * 0.5));
                    l2.setText("Your block is broken");

                } else {
                    p1.removeHealth((int) (p2.getDamage() * 0.5));
                    l2.setText(p2.getName() + " counterattacked");
                }
                break;

            case "11": // аттака - аттака 
                p2.removeHealth(p1.getDamage());
                l2.setText(p1.getName() + " attacked");
                break;

            case "00": // защита - защита 1 раз
                v = Math.random();
                if (v <= 0.5) {
                    stun = 1;
                }
                l2.setText("Both defended themselves");
                break;

            case "01": // защита - аттака
                l2.setText(p1.getName() + " didn't attacked");
                break;

            case "-10": // оглушён - защита
                l.setText(p1.getName() + " was stunned");
                stun = 0;
                l2.setText(p2.getName() + " didn't attacked");
                break;

            case "-11": // оглушён - аттака
                p1.removeHealth(p2.getDamage());
                l.setText(p1.getName() + " was stunned");
                stun = 0;
                l2.setText(p2.getName() + " attacked");
                break;

            case "20":
                if (Math.random() < 0.75) {
                    p2.setDebuf(new Debuf(p1.getLevel()));
                    l2.setText(p1.getName() + " weaken " + p2.getName());
                }
                break;

            case "02":
            case "-12":
                if (Math.random() < 0.75) {
                    p1.setDebuf(new Debuf(p2.getLevel()));
                    l2.setText(p2.getName() + " weaken " + p1.getName());
                }
                break;

            case "12":
                p2.removeHealth((int) (p1.getDamage() * 1.15));
                l2.setText(p1.getName() + " attacked " + p2.getName());
                break;

            case "21":
                p1.removeHealth((int) (p2.getDamage() * 1.15));
                l2.setText(p2.getName() + " attacked " + p1.getName());
                break;

            case "30":
            case "32":
                p1.setHealth((int) ((p1.getMaxHealth() - p1.getHealth()) * 0.5));
                l2.setText(p1.getName() + " healed");
                break;

            case "03":
            case "23":
            case "-13":
                p2.setHealth((int) ((p2.getMaxHealth() - p2.getHealth()) * 0.5));
                l2.setText(p2.getName() + " healed");
                break;

            case "13":
                p2.removeHealth(p1.getDamage() * 2);
                l2.setText(p1.getName() + " attacked");
                break;

            case "31":
                p1.removeHealth(p2.getDamage() * 2);
                l2.setText(p2.getName() + " attacked");
                break;
        }

        p1.nextTurn();
        p2.nextTurn();
    }

    public void Hit(Player human, Player enemy, int a, JLabel label, // основная логика боя
            JLabel label2, JDialog dialog, JLabel label3, CharacterAction action,
            JProgressBar pr1, JProgressBar pr2, JDialog dialog1,
            JDialog dialog2, JFrame frame, ArrayList<Result> results,
            JLabel label4, JLabel label5, JLabel label6, JLabel label7,
            JLabel label8, Items[] items, JRadioButton rb, JDialog jDialog7) {

        label7.setText(""); //Этот код очищает текстовое поле, которое, вероятно, используется для вывода информации о текущем действии в бою.
        human.setAttack(a);

        //  Этот блок кода отвечает за выбор типа атаки противника. 
        //Если мы еще не исчерпали все возможные типы атаки для текущего противника 
        //(k меньше, чем длина массива kind_attack), то просто увеличиваем счетчик k. 
        //Если все возможные типы атаки уже использованы, мы вызываем метод ChooseBehavior,
        //чтобы сгенерировать новый набор типов атаки для противника.
        if (k < kind_attack.length - 1) {
            k++;
        } else {
            kind_attack = action.ChooseBehavior(enemy, action);
            k = 0;
        }

        enemy.setAttack(kind_attack[k]);

        if (i % 2 == 1) {
            Move(human, enemy, label7, label8);
        } else {
            Move(enemy, human, label7, label8);
        }

        i++;

        change.RoundTexts(human, enemy, label, label2, i, label6);
        action.HP(human, pr1);
        action.HP(enemy, pr2);

        if (human.getHealth() <= 0 & items[2].getCount() > 0) {
            human.setNewHealth((int) (human.getMaxHealth() * 0.05));
            items[2].setCount(-1);
            action.HP(human, pr1);
            label2.setText(human.getHealth() + "/" + human.getMaxHealth());
            rb.setText(items[2].getName() + ", " + items[2].getCount() + " шт");
            label7.setText("Вы воскресли");
        }

        if (human.getHealth() <= 0 | enemy.getHealth() <= 0) {
            if (action.isFinalRound()) {
                EndFinalRound(((Human) human), action, results, dialog1, dialog2,
                        frame, label4, label5, jDialog7);
            } else {
                EndRound(human, enemy, dialog, label3, action, items, jDialog7);
            }
        }
    }

    // Этот метод обеспечивает корректное завершение раунда боя и обновляет данные о победе или поражении игрока.
    public void EndRound(Player human, Player enemy, JDialog dialog, JLabel label,
            CharacterAction action, Items[] items, JDialog jDialog7) {

        endRound = true;

//        dialog.setVisible(true);
//        dialog.setBounds(300, 150, 700, 600);
        if (human.getHealth() > 0) {
            label.setText("You win");
            action.nextEnemy();

            if (enemy instanceof ShaoKahn) {
                action.AddItems(38, 23, 8, items);
                action.AddPointsBoss(((Human) human), action.getEnemyes(), jDialog7, dialog);
            } else {
                action.AddItems(25, 15, 5, items);
                action.AddPoints(((Human) human), action.getEnemyes(), jDialog7, dialog);
            }
        } else {
            label.setText(enemy.getName() + " win");
            dialog.setVisible(true);
            dialog.setBounds(300, 150, 700, 600);
        }

        i = 1; // Сбрасывает счетчик раунда на начальное значение.
        k = -1; //  Сбрасывает счетчик типов атаки на начальное значение.
        kind_attack = ResetAttack(); //  Сбрасывает массив типов атаки противника на начальное значение.

    }

    // Этот метод EndFinalRound вызывается, когда игрок завершает последний раунд, побеждая босса.
    public void EndFinalRound(Human human, CharacterAction action,
            ArrayList<Result> results, JDialog dialog1, JDialog dialog2, JFrame frame,
            JLabel label1, JLabel label2, JDialog jDialog7) {

        String text = "Победа не на вашей стороне";

        if (human.getHealth() > 0) {
            action.AddPoints(human, action.getEnemyes(), jDialog7, dialog1);
            text = "Победа на вашей стороне";
        }
        boolean top = false; // Переменная будет использоваться для проверки, попал ли игрок в топ-10.
        if (results == null) {
            top = true;
        } else {
            int i = 0;
            for (int j = 0; j < results.size(); j++) {
                if (human.getPoints() < results.get(j).getPoints()) {
                    i++;
                }
            }
            if (i < 10) {
                top = true;
            }
        }
        if (top) {
            dialog1.setVisible(true);
            dialog1.setBounds(150, 150, 600, 500);
            label1.setText(text);
        } else {
            dialog2.setVisible(true);
            dialog2.setBounds(150, 150, 470, 360);
            label2.setText(text);
        }
        frame.dispose();
    }

    public int[] ResetAttack() {
        int a[] = {0};
        return a;
    }

    // Этот метод NewRound используется для подготовки к началу нового раунда игры.
    public Player NewRound(Player human, JLabel label, JProgressBar pr1,
            JProgressBar pr2, JLabel label2, JLabel text, JLabel label3, CharacterAction action) {

        Player enemy1 = action.ChooseEnemy(label, label2, text, label3, human.getLevel());

        pr1.setMaximum(human.getMaxHealth());
        pr2.setMaximum(enemy1.getMaxHealth());
        human.setNewHealth(human.getMaxHealth());
        enemy1.setNewHealth(enemy1.getMaxHealth());
        action.HP(human, pr1);
        action.HP(enemy1, pr2);
        return enemy1;
    }

}
