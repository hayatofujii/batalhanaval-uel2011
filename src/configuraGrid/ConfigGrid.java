package configuraGrid;

import componentesUI.Chat;
import componentesUI.Grid;

import javax.swing.JPanel;
import javax.swing.JFrame;

public class ConfigGrid {
    JPanel painel;
    
    Chat chat;
    Grid grid;
    Grid grid2;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(
            new Runnable() {

                @Override
                public void run() {
                    mostrar();
                }
            }
        );
    }

    private static void mostrar() {
        // frame
        JFrame janela = new JFrame("Batalha Naval");
        janela.setSize(800, 600);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);

        // instancia uma janela ConfigGrid
        ConfigGrid conf = new ConfigGrid();
        conf.painel.setOpaque(true);

        // seta a janela para mostrar somente o ConfigGrid
        janela.setContentPane(conf.painel);

        // mostrar frame
        janela.setVisible(true);
    }

    public ConfigGrid() {
        painel = new JPanel();

        grid = new Grid();
        grid2 = new Grid();
        chat = new Chat("Nome1");
        
        painel.setLayout(null);
        
        painel.add(grid);
        painel.add(grid2);
        painel.add(chat);
        
        grid.setBounds(50, 50, 350, 350);
        grid2.setBounds(475, 34, 200, 200);
        chat.setBounds(50, 403, 695, 138);
    }
}