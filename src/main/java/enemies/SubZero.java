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
public class SubZero extends Enemy {

    public SubZero(int level, int health, int damage, int attack) {
        super(level, health, damage, attack, "Sub-Zero", "src/main/resources/Солдат.jpg");
        List<EnemyBehavior> enemyBehavior = new ArrayList<>();
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 0}, 20));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 0}, 20));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 1 , 1}, 50));
        enemyBehavior.add(new EnemyBehavior(new int[]{2}, 10));
        setEnemyBehaviors(enemyBehavior);
    }
}
