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
public class ShaoKahn extends Enemy {

    public ShaoKahn(int level, int health, int damage, int attack) {
        super(level, health, damage, attack, "Shao Kahn", "src/main/resources/Босс.jpg");
        List<EnemyBehavior> enemyBehavior = new ArrayList<>();
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 0}, 10));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 0}, 40));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 1, 1}, 40));
        enemyBehavior.add(new EnemyBehavior(new int[]{3}, 10));
        setEnemyBehaviors(enemyBehavior);
        setRewardsProbability(new int[]{38, 23, 8});
    }
}
