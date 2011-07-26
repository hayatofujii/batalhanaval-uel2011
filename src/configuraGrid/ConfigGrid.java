package configuraGrid;

import componentesUI.Grid;
import componentesUI.Chat;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.GroupLayout;

public class ConfigGrid {
    JPanel painel;
    
    Chat chat;
    Grid grid;

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

        grid = new Grid();
        chat = new Chat();

        GroupLayout layoutConfigGrid = new GroupLayout(painel);
        
        layoutConfigGrid.setHorizontalGroup(
            layoutConfigGrid.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutConfigGrid.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutConfigGrid.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(chat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(grid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                )
                .addContainerGap()
             )
        );
        
        layoutConfigGrid.setVerticalGroup(
            layoutConfigGrid.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutConfigGrid.createSequentialGroup()
                .addContainerGap()
                .addComponent(grid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chat, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap()
            )
        );
        
        painel.setLayout(layoutConfigGrid);
                
    }
}