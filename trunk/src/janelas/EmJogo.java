package janelas;

import javax.swing.JPanel;
import java.awt.Dimension;
import componentesUI.Chat;
import componentesUI.Grid;

public class EmJogo extends JPanel {
    private Chat chat;
    private static Grid grid, mini;
    
    public static Grid getGrid() {
        return grid;
    }
    
    public static Grid getMini() {
        return mini;
    }
    
    public EmJogo() {
        grid = new Grid(2);
        mini = new Grid(2);
        chat = Chat.getChat();
        
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        
        grid.setPreferredSize(new Dimension(350, 350));
        Dimension tamGrid = grid.getPreferredSize();
        grid.setBounds(50, 50, tamGrid.width, tamGrid.height);
        add(grid);
        
        mini.setPreferredSize(new Dimension(200, 200));
        Dimension tamMini = mini.getPreferredSize();
        mini.setBounds(125 + tamGrid.width, 50, tamMini.width, tamMini.height);
        add(mini);
        
        Dimension tamChat = chat.getPreferredSize();
        chat.setBounds(50, tamGrid.height + 58, tamChat.width, tamChat.height);
        add(chat);
    }
}