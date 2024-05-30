/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kate Shcherbinina
 */
public class Baraka extends Enemy {

    public Baraka(int level, int health, int damage, int attack) {
        super(level, health, damage, attack, "Baraka", "src/main/resources/Боец.jpg");
        List<EnemyBehavior> enemyBehavior = new ArrayList<>();
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 0}, 15));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 0}, 15));
        enemyBehavior.add(new EnemyBehavior(new int[]{0, 1, 0}, 60));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 1, 1}, 10));
        setEnemyBehaviors(enemyBehavior);
    }

}
