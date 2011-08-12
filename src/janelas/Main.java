package janelas;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Main {
    private static JFrame janela;
    
    private static final int MAX_LARGURA = 800;
    private static final int MAX_ALTURA = 600;

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
    
    public static JFrame getJFrame() {
        if(janela == null)
            janela = new JFrame("Batalha Naval");
        return janela;
    }
    
    private static void mostrar() {
        // frame
        getJFrame();
        janela.setPreferredSize(new Dimension(MAX_LARGURA, MAX_ALTURA));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        // instancia uma janela ConfigGrid
        ConfigConexao confConexao = new ConfigConexao();
        confConexao.setOpaque(true);
        
        // seta a janela para mostrar somente o Config
        janela.add(confConexao);
        
        // mostrar frame
        janela.pack();
        janela.setVisible(true);
    }
}
