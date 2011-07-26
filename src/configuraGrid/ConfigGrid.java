package configuraGrid;

import componentesUI.Grid;
import componentesUI.Chat;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;

public class ConfigGrid {
    
    Chat chat;
    Grid grid;
    
    JPanel painel;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {
                        mostrar();
                    }
                });
    }

    private static void mostrar() {
        // frame
        JFrame janela = new JFrame("Batalha Naval");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);

        // instancia uma janela ConfigGrid
        ConfigGrid conf = new ConfigGrid();
        conf.painel.setOpaque(true);

        // seta a janela para mostrar somente o ConfigGrid
        janela.setContentPane(conf.painel);

        // mostrar frame
        janela.pack();
        janela.setVisible(true);
    }

    public ConfigGrid() {
        painel = new JPanel();
        
        // fazer layout do painel principal
        painel.setLayout(new FlowLayout());
        painel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        chat = new Chat();
        painel.add(chat);
        
        grid = new Grid();
        painel.add(grid);
                
    }
}