import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    public MainForm()
    {
        // Заголовок игры
        setTitle("TIC-TAC-TOE");
        // Границы окна
        setBounds(300, 300, 455, 525);

        setResizable(false);
        // При закрытии - окно и программа закрываются
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Создаём шаблон нашего игрового поля
        MainGameField gameField = MainGameField.getInstance();
        // Создаём панель для кнопок табличного стиля
        JPanel buttonPanel = new JPanel(new GridLayout());
        // Добавляем игровое поле в центр нашего окна
        add(gameField, BorderLayout.CENTER);
        // Панель для кнопок добавляем в середину окна
        add(buttonPanel, BorderLayout.CENTER);
        JButton btnStart = new JButton("Начать новую игру");
        JButton btnEnd = new JButton("Закончить игру");
        buttonPanel.add(btnStart);
        buttonPanel.add(btnEnd);
        // Добавляем обработчик событий для закрытия окна
        btnEnd.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        // Добавляем обработчик событий для создания новой игры
        btnStart.addActionListener(new ActionListener()
        {
            @Override

            public void actionPerformed(ActionEvent e)
            {
                System.out.println(btnStart.getText());
                // Загружаем новое окно (с настройками игры)
                GameSettingsForm gameSettingsForm = new GameSettingsForm();
            }
        });
        // Показываем окно
        setVisible(true);
    }
}