package janelas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class Main {
    private static JFrame janela;
    
    private static ConfigConexao confConex;
    private static ConfigGrid confGrid;
    private static EmJogo emJogo;
    
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

    public static void mostraConfigGrid() {
        //janela.remove(confConex);
        
        confGrid = new ConfigGrid();
        confGrid.setOpaque(true);
        janela.add(confGrid);
        
        confGrid.revalidate();        
    }
    
    public static void mostraEmJogo() {
        janela.remove(confGrid);
        
        emJogo = new EmJogo();
        emJogo.setOpaque(true);
        janela.add(emJogo);
        
        emJogo.revalidate();
    }
    
    private static void mostrar() {
        // frame
        janela = new JFrame("Batalha Naval");
        janela.setPreferredSize(new Dimension(MAX_LARGURA, MAX_ALTURA));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        // instancia um painel ConfigConexao
        //mostraConfigConexao();
        
        mostraConfigGrid();
        
        // mostrar frame
        janela.pack();
        janela.setVisible(true);
    }
}