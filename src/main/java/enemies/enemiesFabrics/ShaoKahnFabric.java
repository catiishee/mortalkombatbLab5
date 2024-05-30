/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies.enemiesFabrics;

import enemies.Enemy;
import enemies.ShaoKahn;

/**
 *
 * @author Kate Shcherbinina
 */
public class ShaoKahnFabric implements EnemyFabricInterface {

    @Override
    public Enemy create(int i) {

        return new ShaoKahn(3, 100, 30, 1);
    }
}
