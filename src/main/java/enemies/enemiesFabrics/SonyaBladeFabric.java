/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies.enemiesFabrics;

import enemies.Enemy;
import enemies.SonyaBlade;

/**
 *
 * @author Kate Shcherbinina
 */
public class SonyaBladeFabric implements EnemyFabricInterface {

    @Override
    public Enemy create(int i) { 
        return new SonyaBlade(1, 80, 16, 1);
    }

}
