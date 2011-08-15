package janelas;
import nucleo.Jogador;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;


public class Main {
    private static JFrame janela;
    
    private static ConfigGrid confGrid;
    private static ConfigConexao confConex;
    
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
    
    public static void mostraConfigConexao()
    {
        confConex = new ConfigConexao();
        confConex.setOpaque(true);
        janela.add(confConex);
        
        confConex.revalidate();
    }

    public static void mostraConfigGrid()
    {
        janela.remove(confConex);
        confGrid = new ConfigGrid();
        confGrid.setOpaque(true);
        janela.add(confGrid);
        
        confGrid.revalidate();        
    }
    

    
    private static void mostrar() {
        // frame
        janela = new JFrame("Batalha Naval");
        janela.setPreferredSize(new Dimension(MAX_LARGURA, MAX_ALTURA));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        // instancia um painel ConfigConexao
        mostraConfigConexao();
        
        // mostrar frame
        janela.pack();
        janela.setVisible(true);
    }
}
