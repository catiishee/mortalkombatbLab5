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
public class LiuKang extends Enemy {

    public LiuKang(int level, int health, int damage, int attack) {
        super(level, health, damage, attack, "Liu Kang", "src/main/resources/Солдат/jpg");
        List<EnemyBehavior> enemyBehavior = new ArrayList<>();
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 0}, 13));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 0}, 13));
        enemyBehavior.add(new EnemyBehavior(new int[]{0, 1, 0}, 10));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 1, 1}, 64));
        setEnemyBehaviors(enemyBehavior);
    }
}
