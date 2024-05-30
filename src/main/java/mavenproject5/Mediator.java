/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mavenproject5;

import enemies.Enemy;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import mortalkombatbversion.Items;
import mortalkombatbversion.Player;

/**
 * Класс Mediator отвечает за обновление интерфейса пользователя и отображение различных диалогов в игре.
 * Он взаимодействует с элементами интерфейса, такими как диалоги, метки, прогресс-бары и радиокнопки.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class Mediator {    
    private JDialog jDialog1;
    private JDialog jDialog2;
    private JDialog jDialog4;
    private JDialog jDialog5;
    private JDialog jDialog6;
    private JDialog jDialog7;
    private JFrame jFrame1;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel9;
    private JLabel jLabel10;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel16;
    private JLabel jLabel17;
    private JLabel jLabel18;
    private JLabel jLabel24;
    private JLabel jLabel26;
    private JLabel jLabel27;
    private JLabel jLabel28;
    private JLabel jLabel29;
    private JProgressBar jProgressBar1;
    private JProgressBar jProgressBar2;
    private JRadioButton jRadioButton1;
    private JRadioButton jRadioButton2;
    private JRadioButton jRadioButton3;
    private JLabel jLabel19;
    
    /**
     * Конструктор класса Mediator.
     * Инициализирует все компоненты интерфейса, которые будут обновляться через медиатор.
     *
     * @param jDialog1 диалог 1
     * @param jDialog2 диалог 2
     * @param jDialog4 диалог 4
     * @param jDialog5 диалог 5
     * @param jDialog6 диалог 6
     * @param jDialog7 диалог 7
     * @param jFrame1 фрейм 1
     * @param jLabel2 метка 2
     * @param jLabel4 метка 4
     * @param jLabel5 метка 5
     * @param jLabel6 метка 6
     * @param jLabel9 метка 9
     * @param jLabel10 метка 10
     * @param jLabel12 метка 12
     * @param jLabel13 метка 13
     * @param jLabel16 метка 16
     * @param jLabel17 метка 17
     * @param jLabel18 метка 18
     * @param jLabel24 метка 24
     * @param jLabel26 метка 26
     * @param jLabel27 метка 27
     * @param jLabel28 метка 28
     * @param jLabel29 метка 29
     * @param jProgressBar1 прогресс-бар 1
     * @param jProgressBar2 прогресс-бар 2
     * @param jRadioButton1 радиокнопка 1
     * @param jRadioButton2 радиокнопка 2
     * @param jRadioButton3 радиокнопка 3
     * @param jLabel19 метка 19
     */
    public Mediator(JDialog jDialog1, JDialog jDialog2, JDialog jDialog4, JDialog jDialog5, JDialog jDialog6, JDialog jDialog7, 
            JFrame jFrame1, JLabel jLabel2, JLabel jLabel4, JLabel jLabel5, JLabel jLabel6, JLabel jLabel9, JLabel jLabel10, 
            JLabel jLabel12, JLabel jLabel13, JLabel jLabel16, JLabel jLabel17, JLabel jLabel18, JLabel jLabel24, JLabel jLabel26, 
            JLabel jLabel27, JLabel jLabel28, JLabel jLabel29, JProgressBar jProgressBar1, JProgressBar jProgressBar2, JRadioButton jRadioButton1,
            JRadioButton jRadioButton2, JRadioButton jRadioButton3, JLabel jLabel19) {
        this.jDialog1 = jDialog1;
        this.jDialog2 = jDialog2;
        this.jDialog4 = jDialog4;
        this.jDialog5 = jDialog5;
        this.jDialog6 = jDialog6;
        this.jDialog7 = jDialog7;
        this.jFrame1 = jFrame1;
        this.jLabel2 = jLabel2;
        this.jLabel4 = jLabel4;
        this.jLabel5 = jLabel5;
        this.jLabel6 = jLabel6;
        this.jLabel9 = jLabel9;
        this.jLabel10 = jLabel10;
        this.jLabel12 = jLabel12;
        this.jLabel13 = jLabel13;
        this.jLabel16 = jLabel16;
        this.jLabel17 = jLabel17;
        this.jLabel18 = jLabel18;
        this.jLabel24 = jLabel24;
        this.jLabel26 = jLabel26;
        this.jLabel27 = jLabel27;
        this.jLabel28 = jLabel28;
        this.jLabel29 = jLabel29;
        this.jProgressBar1 = jProgressBar1;
        this.jProgressBar2 = jProgressBar2;
        this.jRadioButton1 = jRadioButton1;
        this.jRadioButton2 = jRadioButton2;
        this.jRadioButton3 = jRadioButton3;
        this.jLabel19 = jLabel19; 
    
    }
    
    /**
     * Обновляет информацию об игроке в интерфейсе.
     *
     * @param player объект игрока
     */
    public void updatePlayer(Player player) {
        jProgressBar1.setValue(player.getHealth());
        jProgressBar1.setMaximum(player.getMaxHealth());
        jLabel28.setText(player.getName());
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(player.getImage()));
        jLabel2.setIcon(imageIcon);
        jLabel9.setText(Integer.toString(player.getDamage()));
        jLabel12.setText(Integer.toString(player.getHealth()) + "/" + Integer.toString(player.getMaxHealth()));
        jLabel6.setText(player.getLevel() + " level");
        jLabel17.setText(Integer.toString(player.getPoints()));
        jLabel16.setText(Integer.toString(player.getExperience()) + "/" + player.getNextExperience());
    }
    
    /**
     * Обновляет информацию о противнике в интерфейсе.
     *
     * @param enemy объект противника
     */
    public void updateEnemy(Enemy enemy) {
        jProgressBar2.setValue(enemy.getHealth());
        jProgressBar2.setMaximum(enemy.getMaxHealth());
        jLabel5.setText(enemy.getName());
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(enemy.getImage()));
        jLabel4.setIcon(imageIcon);
        jLabel10.setText(Integer.toString(enemy.getDamage()));
        jLabel13.setText(Integer.toString(enemy.getHealth()) + "/" + Integer.toString(enemy.getMaxHealth()));
        jLabel19.setText(enemy.getLevel() + " level");
        
    }
    
    /**
     * Обновляет информацию о ходе боя в интерфейсе.
     *
     * @param output строка с описанием текущего события
     * @param turnText строка с информацией о текущем ходе
     */
    public void updateFightEvent(String output, String turnText) {
        jLabel27.setText(output);
        jLabel29.setText(turnText);
    }
    
    /**
     * Обновляет текст для сообщения о возрождении.
     *
     * @param text текст сообщения о возрождении
     */
    public void updateRespawnText(String text) {
        jLabel26.setText(text);
    }
    
    /**
     * Отображает диалог с сообщением о завершении раунда.
     *
     * @param text текст сообщения
     */
    public void showEndRound(String text) {
        jLabel18.setText(text);
        jDialog1.setVisible(true);
        jDialog1.setBounds(new Rectangle(300, 150, 700, 600));
        jDialog1.setAlwaysOnTop(true);
    }
    
    /**
     * Отображает диалог с сообщением о повышении уровня.
     */
    public void showLevelUp(){
        jDialog7.setVisible(true);
        jDialog7.setAlwaysOnTop(true);
    }
    
    /**
     * Отображает диалог с сообщением о завершении финального раунда.
     *
     * @param top флаг, указывающий на попадание в топ
     * @param win флаг, указывающий на победу
     */
    public void showEndFinalRound(boolean top, boolean win){
        String text = "Победа не на вашей стороне";

        if (win) {
            text = "Победа на вашей стороне";
        }
        if (top) {
            jDialog2.setVisible(true);
            jDialog2.setBounds(new Rectangle(150, 150, 600, 500));
            jDialog2.setAlwaysOnTop(true);
        } else {
            jDialog4.setVisible(true);
            jDialog4.setBounds(new Rectangle(150, 150, 470, 360));
            jDialog4.setAlwaysOnTop(true);
        }
        jLabel24.setText(text);
        

        jFrame1.dispose();
    }
    
    /**
     * Закрывает инвентарь.
     */
    public void closeInventory(){
        jDialog5.dispose();
    }
    
    /**
     * Отображает диалог с сообщением о невозможности использования предмета.
     */
    public void showCanNotUseItem(){
        jDialog6.setVisible(true);
        jDialog6.setBounds(new Rectangle(300, 200, 400, 300));
    }
    
    /**
     * Обновляет информацию об инвентаре в интерфейсе.
     *
     * @param items массив предметов
     */
    public void updateInventory(Items[] items){
        jRadioButton1.setText(items[0].getName() + ", " + items[0].getCount() + " шт");
        jRadioButton2.setText(items[1].getName() + ", " + items[1].getCount() + " шт");
        jRadioButton3.setText(items[2].getName() + ", " + items[2].getCount() + " шт");
    
    }
    
}
