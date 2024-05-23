/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import enemies.Baraka;
import enemies.ShaoKahn;
import enemies.SubZero;
import enemies.LiuKang;
import enemies.SonyaBlade;
import enemies.enemiesFabrics.EnemyFabric;
import java.awt.Rectangle;
import mavenproject5.GuiUpdate;

/**
 *
 * @author
 */
public class CharacterAction {

    private final int experience_for_next_level[] = {40, 90, 180, 260, 410, 1000};
    private final int kind_fight[][] = {{1, 0}, {1, 1, 0}, {0, 1, 0}, {1, 1, 1, 1}, {2}, {3}};
    private Player enemyes[] = new Player[6];
    EnemyFabric fabric = new EnemyFabric();
    private Player enemyy = null;
    private int numberOfLocations;
    private int numberOfEnemyesInLocation = -1;
    private int currentEnemy = 0;
    private int currentLocation;

    public void setEnemyes(int numberOfLocations) {
        this.numberOfLocations = numberOfLocations;
        this.currentLocation = 1;
        enemyes[0] = fabric.create(0, 0);
        enemyes[1] = fabric.create(1, 0);
        enemyes[2] = fabric.create(2, 0);
        enemyes[3] = fabric.create(3, 0);
        enemyes[4] = fabric.create(4, 0);
        enemyes[5] = fabric.create(4, 0);
    }

    public Player[] getEnemyes() {
        return this.enemyes;
    }

    public Player ChooseEnemy(int level, GuiUpdate guiUpdate) {
        if (currentEnemy > numberOfEnemyesInLocation) {
            startNewLocation(level);
        }
        if (currentEnemy == numberOfEnemyesInLocation) {
            return ChooseBoss(level, guiUpdate);
        }
        int i = (int) (Math.random() * 4);
        switch (i) {
            case 0:
                enemyy = enemyes[0];
                guiUpdate.setLabel5Text("Baraka (танк)");
                guiUpdate.setIconPath("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\mavenproject5\\src\\main\\java\\resources\\Танк.jpg");
                break;
            case 1:
                enemyy = enemyes[1];
                guiUpdate.setLabel5Text("Sub-Zero (маг)");
                guiUpdate.setIconPath("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\mavenproject5\\src\\main\\java\\resources\\маг.jpg");
                break;
            case 2:
                enemyy = enemyes[2];
                guiUpdate.setLabel5Text("Liu Kang (боец)");
                guiUpdate.setIconPath("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\mavenproject5\\src\\main\\java\\resources\\Боец.jpg");
                break;
            case 3:
                enemyy = enemyes[3];
                guiUpdate.setLabel5Text("Sonya Blade (солдат)");
                guiUpdate.setIconPath("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\mavenproject5\\src\\main\\java\\resources\\Солдат.jpg");
                break;
        }
        guiUpdate.setLabel10Text(Integer.toString(enemyy.getDamage()));
        guiUpdate.setLabel13Text(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }

    private Player ChooseBoss(int level, GuiUpdate guiUpdate) {
        enemyy = enemyes[4];
        guiUpdate.setLabel5Text("Shao Kahn (босс)");
        guiUpdate.setIconPath("C:\\Users\\user\\OneDrive\\Документы\\NetBeansProjects\\mavenproject5\\src\\main\\java\\resources\\Босс.jpg");
        guiUpdate.setLabel10Text(Integer.toString(enemyy.getDamage()));
        guiUpdate.setLabel13Text(Integer.toString(enemyy.getHealth()) + "/" + Integer.toString(enemyy.getMaxHealth()));
        return enemyy;
    }

    public void AddPoints(Human human, GuiUpdate guiUpdate) {
        switch (human.getLevel()) {
            case 0:
                human.setExperience(20);
                human.setPoints(25 + human.getHealth() / 4);
                break;
            case 1:
                human.setExperience(25);
                human.setPoints(30 + human.getHealth() / 4);
                break;
            case 2:
                human.setExperience(30);
                human.setPoints(35 + human.getHealth() / 4);
                break;
            case 3:
                human.setExperience(40);
                human.setPoints(45 + human.getHealth() / 4);
                break;
            case 4:
                human.setExperience(50);
                human.setPoints(55 + human.getHealth() / 4);
                break;
        }

        boolean levelUp = false;

        for (int i = 0; i < 5; i++) {
            if (experience_for_next_level[i] == human.getExperience()) {
                human.setLevel();
                human.setNextExperience(experience_for_next_level[i + 1]);
                guiUpdate.setShowDialog7(true);
                levelUp = true;
                NewHealthHuman(human);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], human);
                }
            }
        }
        if (!levelUp) {
            guiUpdate.setShowDialog(true);
            guiUpdate.setDialogBounds(new Rectangle(300, 150, 700, 600));
        }
    }

    public void AddPointsBoss(Human human, GuiUpdate guiUpdate) {

        human.setExperience(50);
        human.setPoints(65 + human.getHealth() / 2);

        boolean levelUp = false;

        for (int i = 0; i < 5; i++) {
            if (experience_for_next_level[i] == human.getExperience()) {
                human.setLevel();
                human.setNextExperience(experience_for_next_level[i + 1]);
                guiUpdate.setShowDialog7(true);
                levelUp = true;
                NewHealthHuman(human);
                for (int j = 0; j < 4; j++) {
                    NewHealthEnemy(enemyes[j], human);
                }
            }
        }
        if (!levelUp) {
            guiUpdate.setShowDialog(true);
            guiUpdate.setDialogBounds(new Rectangle(300, 150, 700, 600));
        }
    }

    public void AddItems(int k1, int k2, int k3, Items[] items) {
        double i = Math.random();
        if (i < k1 * 0.01) {
            items[0].setCount(1);
        }
        if (i >= k1 * 0.01 && i < (k1 + k2) * 0.01) {
            items[1].setCount(1);
        }
        if (i >= (k1 + k2) * 0.01 && i < (k1 + k2 + k3) * 0.01) {
            items[2].setCount(1);
        }
    }

    public int[] ChooseBehavior(Player enemy) {
        int arr[] = null;
        double i = Math.random();
        if (enemy instanceof Baraka) {
            arr = EnemyBehavior(15, 15, 60, 10, 0, 0, i);
        }
        if (enemy instanceof SubZero) {
            arr = EnemyBehavior(20, 20, 0, 50, 10, 0, i);
        }
        if (enemy instanceof LiuKang) {
            arr = EnemyBehavior(13, 13, 10, 64, 0, 0, i);
        }
        if (enemy instanceof SonyaBlade) {
            arr = EnemyBehavior(25, 25, 50, 0, 0, 0, i);
        }
        if (enemy instanceof ShaoKahn) {
            arr = EnemyBehavior(10, 40, 0, 40, 0, 10, i);
        }
        return arr;
    }

    private int[] EnemyBehavior(int k1, int k2, int k3, int k4, int k5, int k6, double i) {
        if (i < k1 * 0.01) {
            return kind_fight[0];
        }
        if (i >= k1 * 0.01 && i < (k1 + k2) * 0.01) {
            return kind_fight[1];
        }
        if (i >= (k1 + k2) * 0.01 && i < (k1 + k2 + k3) * 0.01) {
            return kind_fight[2];
        }
        if (i >= (k1 + k2 + k3) * 0.01 && i < (k1 + k2 + k3 + k4) * 0.01) {
            return kind_fight[3];
        }
        if (i >= (k1 + k2 + k3 + k4) * 0.01 && i < (k1 + k2 + k3 + k4 + k5) * 0.01) {
            return kind_fight[4];
        }
        return kind_fight[5];
    }

    public void startNewLocation(int playerLevel) {
        currentLocation++;
        numberOfEnemyesInLocation = (int) (playerLevel + 1 + Math.random() * 2);
        currentEnemy = 0;
    }

    public boolean isFinalRound() {
        return currentLocation >= numberOfLocations && currentEnemy >= numberOfEnemyesInLocation;
    }

    public void nextEnemy() {
        currentEnemy++;
    }

    private void NewHealthHuman(Human human) {
        int hp = 0;
        int damage = 0;
        switch (human.getLevel()) {
            case 1:
                hp = 25;
                damage = 3;
                break;
            case 2:
                hp = 30;
                damage = 3;
                break;
            case 3:
                hp = 30;
                damage = 4;
                break;
            case 4:
                hp = 40;
                damage = 6;
                break;
        }
        human.setMaxHealth(hp);
        human.setDamage(damage);
    }

    private void NewHealthEnemy(Player enemy, Human human) {
        int hp = 0;
        int damage = 0;
        switch (human.getLevel()) {
            case 1:
                hp = 32;
                damage = 25;
                break;
            case 2:
                hp = 30;
                damage = 20;
                break;
            case 3:
                hp = 23;
                damage = 24;
                break;
            case 4:
                hp = 25;
                damage = 26;
                break;
        }
        enemy.setMaxHealth((int) enemy.getMaxHealth() * hp / 100);
        enemy.setDamage((int) enemy.getDamage() * damage / 100);
        enemy.setLevel();
    }

    public void UseItem(Player human, Items[] items, String name, GuiUpdate guiUpdate) {
        switch (name) {
            case "jRadioButton1":
                if (items[0].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.25));
                    items[0].setCount(items[0].getCount() - 1);
                } else {
                    guiUpdate.setShowDialog(true);
                    guiUpdate.setDialogBounds(new Rectangle(300, 200, 400, 300));
                }
                break;
            case "jRadioButton2":
                if (items[1].getCount() > 0) {
                    human.setHealth((int) (human.getMaxHealth() * 0.5));
                    items[1].setCount(items[1].getCount() - 1);
                } else {
                    guiUpdate.setShowDialog(true);
                    guiUpdate.setDialogBounds(new Rectangle(300, 200, 400, 300));
                }
                break;
            case "jRadioButton3":
                guiUpdate.setShowDialog(true);
                guiUpdate.setDialogBounds(new Rectangle(300, 200, 400, 300));
                break;
        }

        if (!guiUpdate.isShowDialog()) {
            guiUpdate.setDisposeDialog1(true);
        }
    }
}
