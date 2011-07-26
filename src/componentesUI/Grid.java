package componentesUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.BorderFactory;

public class Grid extends JPanel {
    JButton[][] botoes;

    public Grid() {
        // grid
        super(new GridLayout(10, 10));

        // botões
        botoes = new JButton[10][10];

        // ícone
        ImageIcon icon = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile.jpg"));

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botoes[i][j] = new JButton();
                botoes[i][j].setMargin(new Insets(0, 0, 0, 0));
                botoes[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                botoes[i][j].setIcon(icon);

                // colocar o botão no painel
                add(botoes[i][j]);
            }
        }
    }
}