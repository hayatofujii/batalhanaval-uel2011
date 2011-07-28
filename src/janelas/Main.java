package janelas;

import javax.swing.JFrame;

public class Main {
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
        janela.setLayout(null);

        // instancia uma janela ConfigGrid
        //ConfigGrid confGrid = new ConfigGrid();
        //confGrid.setOpaque(true);
        
        // instancia uma janela ConfigConexao
        ConfigConexao confConexao = new ConfigConexao();
        confConexao.form.setOpaque(true);

        // seta a janela para mostrar somente o ConfigConexao
        janela.setContentPane(confConexao.form);

        // mostrar frame
        janela.setVisible(true);
    }
}
