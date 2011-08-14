package componentesUI;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;

public class Grid extends JPanel {
    // ícones
    private ImageIcon sea_tile = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile.jpg"));
    private ImageIcon sea_tile_temp = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile-temp.jpg"));
    
    // botões
    private JButton[][] botoes;
    
    // ouvintes dos eventos de mouse
    private MouseListener mouseListener;
    
    // sentido do barco a ser inserido
    private static boolean vertical;
    
    // setter para a variável booleana vertical
    public static void setBooleanVertical(boolean valor) {
        vertical = valor;
    }
    
    public Grid() {
        // grid
        super(new GridLayout(10, 10));

        // botões
        botoes = new JButton[10][10];
        
        // por padrão, o sentido dos barcos é true
        vertical = true;
        
        insereBotoes();
    }
    
    private void insereBotoes() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                // cria e configura o botão
                botoes[i][j] = new JButton();
                botoes[i][j].setMargin(new Insets(0, 0, 0, 0));
                botoes[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                botoes[i][j].setIcon(sea_tile);
                
                // adiciona o ouvinte de eventos referentes ao barco 1
                mouseListener = new EventoBotaoGrid_Barco1();
                botoes[i][j].addMouseListener(mouseListener);

                // coloca o botão no painel
                add(botoes[i][j]);
            }
        }
    }
    
    private void insereBarcos() {
        
    }
    
    private class EventoBotaoGrid_Barco1 extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    if(e.getSource() == botoes[i][j]) {
                        if(vertical == true) {
                            if(i <= 5) {
                                for(int k = 0; k < 5; k++) {
                                    botoes[i + k][j].setIcon(sea_tile_temp);
                                    botoes[i + k][j].repaint();
                                }
                            }
                        }
                        else {
                            if(j <= 5) {
                                for(int k = 0; k < 5; k++) {
                                    botoes[i][j + k].setIcon(sea_tile_temp);
                                    botoes[i][j + k].repaint();
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
        
        @Override
        public void mouseExited(MouseEvent e) {
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    if(e.getSource() == botoes[i][j]) {
                        if(vertical == true) {
                            if(i <= 5) {
                                for(int k = 0; k < 5; k++) {
                                    botoes[i + k][j].setIcon(sea_tile);
                                    botoes[i + k][j].repaint();
                                }
                            }
                        } else {
                            if(j <= 5) {
                                for(int k = 0; k < 5; k++) {
                                    botoes[i][j + k].setIcon(sea_tile);
                                    botoes[i][j + k].repaint();
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
}