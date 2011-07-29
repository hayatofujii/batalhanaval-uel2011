package janelas;

import componentesUI.Chat;
import componentesUI.Grid;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConfigGrid extends JPanel {
    Chat chat;
    Grid grid;

    public ConfigGrid() {
        grid = new Grid();
        chat = new Chat("Paulo Henrique");

        setLayout(null);
        
        setBorder(new EmptyBorder(30, 30, 30, 30));

        grid.setBounds(50, 34, 350, 350);
        add(grid);
       
        chat.setBounds(50, 403, 695, 138);
        add(chat);
    }
}