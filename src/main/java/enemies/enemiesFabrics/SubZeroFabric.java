/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies.enemiesFabrics;

import enemies.Enemy;
import enemies.SubZero;

/**
 *
 * @author Kate Shcherbinina
 */
public class SubZeroFabric implements EnemyFabricInterface {

    @Override
    public Enemy create(int i) {
        return new SubZero(1, 60, 16, 1);
    }

}
