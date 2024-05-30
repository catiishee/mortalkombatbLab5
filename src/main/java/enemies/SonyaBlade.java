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
public class SonyaBlade extends Enemy {

    public SonyaBlade(int level, int health, int damage, int attack) {
        super(level, health, damage, attack, "Sonya Blade", "/images/маг.jpg");
        List<EnemyBehavior> enemyBehavior = new ArrayList<>();
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 0}, 25));
        enemyBehavior.add(new EnemyBehavior(new int[]{1, 1, 0}, 25));
        enemyBehavior.add(new EnemyBehavior(new int[]{0, 1, 0}, 50));
        setEnemyBehaviors(enemyBehavior);
    }

}
