/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies.enemiesFabrics;

import enemies.Enemy;
import enemies.LiuKang;

/**
 *
 * @author Kate Shcherbinina
 */
public class LiuKangFabric implements EnemyFabricInterface {

    @Override
    public Enemy create(int i) {
        return new LiuKang(1, 70, 20, 1);
    }
}
