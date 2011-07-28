package janelas;

import componentesUI.Chat;
import componentesUI.Grid;

import javax.swing.JPanel;

public class ConfigGrid extends JPanel {
    Chat chat;
    Grid grid;
    Grid grid2;

    public ConfigGrid() {
        grid = new Grid();
        grid2 = new Grid();
        chat = new Chat("Paulo Henrique");
        
        setLayout(null);
        
        add(grid);
        add(grid2);
        add(chat);
        
        grid.setBounds(50, 34, 350, 350);
        grid2.setBounds(475, 34, 200, 200);
        chat.setBounds(50, 403, 695, 138);
    }
}