/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies.enemiesFabrics;

import enemies.Baraka;
import enemies.Enemy;

/**
 *
 * @author Kate Shcherbinina
 */
public class BarakaFabric implements EnemyFabricInterface {

    @Override
    public Enemy create(int i) {
        return new Baraka(1, 100, 12, 1);
    }
}
