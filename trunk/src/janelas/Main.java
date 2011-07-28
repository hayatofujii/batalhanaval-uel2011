package janelas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
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
        //ConfigGrid confGrid = new ConfigGrid();
        //confGrid.setOpaque(true);
        
        // instancia uma janela ConfigConexao
        ConfigConexao confConexao = new ConfigConexao();
        confConexao.setOpaque(true);

        // seta a janela para mostrar somente o Config
        janela.setContentPane(confConexao);

        // mostrar frame
        //janela.pack();
        janela.setVisible(true);
    }
}
