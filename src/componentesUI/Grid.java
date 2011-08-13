package componentesUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

public class Grid extends JPanel {
    // ícones
    ImageIcon sea_tile = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile.jpg"));
    ImageIcon sea_tile_temp = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile-temp.jpg"));
    
    private class PosBotao extends JButton {
        private int x;
        private int y;
        
        public PosBotao(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
        
        public int getX() {
            return x;
        }
        
        public int getY() {
            return y;
        }
    }
    
    private JButton[][] botoes;

    public Grid() {
        // grid
        super(new GridLayout(10, 10));

        // botões
        botoes = new JButton[10][10];
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].setMargin(new Insets(0, 0, 0, 0));
                botoes[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                botoes[i][j].setIcon(sea_tile);
                //botoes[i][j].addMouseListener(new EventoBotaoGrid());

                // colocar o botão no painel
                add(botoes[i][j]);
            }
        }
    }
    
    private class EventoBotaoGrid extends MouseAdapter {
        public void mouseMoved(MouseEvent e) {
            int x = getX();
            int y = getY();
            
            botoes[x][y].setIcon(sea_tile_temp);
        }
    }
}