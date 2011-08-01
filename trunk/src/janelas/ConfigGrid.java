package janelas;

import componentesUI.Chat;
import componentesUI.Grid;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ConfigGrid extends JPanel {
    Chat chat;
    Grid grid;

    public ConfigGrid() {
        grid = new Grid();
        chat = new Chat("Paulo Henrique");
        
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        
        grid.setPreferredSize(new Dimension(350, 350));
        Dimension tamGrid = grid.getPreferredSize();
        grid.setBounds(50, 50, tamGrid.width, tamGrid.height);
        add(grid);
        
        Dimension tamChat = chat.getPreferredSize();
        chat.setBounds(50, tamGrid.height + 58, tamChat.width, tamChat.height);
        add(chat);
    }
}