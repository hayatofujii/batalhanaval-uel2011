package configuraGrid;

import javax.swing.JPanel;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.BorderFactory;
import java.awt.Color;

public class Grid extends JPanel {
    
    JButton[][] botoes;

    public Grid() {
        // grid
        super(new GridLayout(10, 10));

        // botões
        botoes = new JButton[10][10];

        // ícone
        ImageIcon icon = new ImageIcon(getClass().getResource("sea-tile.jpg"));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].setMargin(new Insets(0, 0, 0, 0));
                botoes[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                botoes[i][j].setIcon(icon);

                // colocar o botão ao painel
                add(botoes[i][j]);
            }
        }

    }

}