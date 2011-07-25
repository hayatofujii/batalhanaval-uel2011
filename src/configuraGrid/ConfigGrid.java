package configuraGrid;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;

public class ConfigGrid extends JPanel {

    private Grid grid;
    private Chat chat;
    
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

        // instancia uma janela
        JComponent conf = new ConfigGrid();
        conf.setOpaque(true);

        // seta a janela para mostrar somente o grid
        janela.setContentPane(conf);

        // mostrar frame
        janela.pack();
        janela.setVisible(true);
    }

    public ConfigGrid() {
        // layout da FRAME
        super(new FlowLayout());
        setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // invocar grid
        grid = new Grid();
        add(grid);
        
        //chat = new Chat();
//      add(chat);
    }
}