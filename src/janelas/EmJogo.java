package janelas;

import componentesUI.Chat;
import componentesUI.Grid;

import javax.swing.JPanel;

public class EmJogo extends JPanel {
    Chat chat;
    Grid grid, mini;

    public EmJogo() {
        grid = new Grid();
        mini = new Grid();
        chat = new Chat("Paulo Henrique");
        
        setLayout(null);
        
        grid.setBounds(50, 34, 350, 350);
        add(grid);
                
        mini.setBounds(475, 34, 200, 200);
        add(mini);
        
        chat.setBounds(50, 403, 695, 138);
        add(chat);
    }
}
