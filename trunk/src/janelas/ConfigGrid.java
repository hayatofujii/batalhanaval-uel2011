package janelas;

import componentesUI.Grid;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ConfigGrid extends JPanel {
    Grid grid;
    
    public ConfigGrid() {
        grid = new Grid();
        
        setLayout(null);
        setPreferredSize(new Dimension(800, 600));
        
        grid.setPreferredSize(new Dimension(350, 350));
        Dimension tamGrid = grid.getPreferredSize();
        grid.setBounds(50, 50, tamGrid.width, tamGrid.height);
        add(grid);
    }
}