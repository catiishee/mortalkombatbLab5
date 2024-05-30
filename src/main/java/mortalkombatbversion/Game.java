/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortalkombatbversion;

import enemies.Enemy;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import mavenproject5.Mediator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Класс Game управляет игровой логикой, включая создание игроков и врагов, ведение боя, 
 * обновление таблицы результатов и работу с файлом результатов в формате Excel.
 * 
 * @author Kate Shcherbinina
 * @since 1.0
 */
public class Game {

    String filePath = "src/main/results.xlsx";
    public CharacterAction action;
    public Fight fight;
    private ArrayList<Result> results = new ArrayList<>();
    private Mediator mediator;

    /**
     * Конструктор класса Game. Инициализирует медиатор, действия персонажа и бой.
     * 
     * @param mediator медиатор для управления обновлениями интерфейса
     */
    public Game(Mediator mediator) {
        this.mediator = mediator;
        this.action = new CharacterAction(mediator);
        this.fight = new Fight(mediator);
    }

    /**
     * Создает нового врага для игрока на основе количества локаций.
     * 
     * @param numberOfLocations количество локаций
     * @return новый объект врага
     */
    public Enemy newEnemy( int numberOfLocations) {
        action.setNumberOfLocations(numberOfLocations);
        Enemy enemy = action.chooseEnemy(0);
        mediator.updateEnemy(enemy);
        return enemy;
    }
    
    /**
     * Создает нового игрока (человека) с начальными параметрами здоровья и урона.
     * 
     * @return новый объект игрока
     */
    public Player newHuman() {
        Player human = new Player(0, 80, 160);
        mediator.updatePlayer(human);
        return human;
    }
    
    /**
     * Завершает игру и добавляет результат игрока в таблицу рекордов.
     * 
     * @param human объект игрока
     * @param text текстовое поле для ввода имени игрока
     * @param table таблица для отображения результатов
     * @throws IOException если возникает ошибка при записи в файл
     */
    public void endGameTop(Player human, JTextField text, JTable table) throws IOException {
        results.add(new Result(text.getText(), human.getPoints()));
        results.sort(Comparator.comparing(Result::getPoints).reversed());
        writeToTable(table);
        writeToExcel();
    }
    
    /**
     * Записывает текущие результаты в файл Excel.
     * 
     * @throws IOException если возникает ошибка при записи в файл
     */
    public void writeToExcel() throws IOException {
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Результаты ТОП 10");
        XSSFRow r = sheet.createRow(0);
        r.createCell(0).setCellValue("№");
        r.createCell(1).setCellValue("Имя");
        r.createCell(2).setCellValue("Количество баллов");
        for (int i = 0; i < results.size(); i++) {
            if (i < 10) {
                XSSFRow r2 = sheet.createRow(i + 1);
                r2.createCell(0).setCellValue(i + 1);
                r2.createCell(1).setCellValue(results.get(i).getName());
                r2.createCell(2).setCellValue(results.get(i).getPoints());
            }
        }
        File f = new File(filePath);
        book.write(new FileOutputStream(f));
        book.close();
    }
    
    /**
     * Возвращает текущий список результатов.
     * 
     * @return список результатов
     */
    public ArrayList<Result> getResults() {
        return this.results;
    }
    
    /**
     * Читает результаты из файла Excel и добавляет их в список результатов.
     * 
     * @throws IOException если возникает ошибка при чтении из файла
     */
    public void readFromExcel() throws IOException {
        try {
            XSSFWorkbook book = new XSSFWorkbook(Files.newInputStream(Paths.get(filePath)));
            XSSFSheet sh = book.getSheetAt(0);
            for (int i = 1; i <= sh.getLastRowNum(); i++) {
                results.add(new Result(sh.getRow(i).getCell(1).getStringCellValue(), (int) sh.getRow(i).getCell(2).getNumericCellValue()));
            }
        } catch (NoSuchFileException ex) {
        }
    }
    
    /**
     * Обновляет таблицу отображения результатов.
     * 
     * @param table таблица для отображения результатов
     */
    public void writeToTable(JTable table) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < results.size(); i++) {
            if (i < 10) {
                model.setValueAt(results.get(i).getName(), i, 0);
                model.setValueAt(results.get(i).getPoints(), i, 1);
            }
        }
    }
}
