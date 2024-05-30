/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package enemies.enemiesFabrics;

import enemies.Enemy;

/**
 * Класс EnemyFabric отвечает за создание объектов врагов.
 * Он использует фабрики для создания различных типов врагов
 * в зависимости от переданных параметров.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class EnemyFabric {
    
    /**
     * Создает врага заданного типа.
     * 
     * @param i тип врага (0 - Baraka, 1 - SubZero, 2 - LiuKang, 3 - SonyaBlade, 4 - ShaoKahn)
     * @param j уровень врага
     * @return объект врага
     */
    public Enemy create(int i, int j) {
        EnemyFabricInterface fabric = null;

        switch (i) {
            case 0:
                fabric = new BarakaFabric();
                break;
            case 1:
                fabric = new SubZeroFabric();
                break;
            case 2:
                fabric = new LiuKangFabric();
                break;
            case 3:
                fabric = new SonyaBladeFabric();
                break;
            case 4:
                fabric = new ShaoKahnFabric();
                break;
        }
        Enemy enemy = fabric.create(j);
        return enemy;
    }
}
