package janelas;
import nucleo.Jogador;

import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.Dimension;

public class Main {
    private Jogador jogador;
    private static JFrame janela;
    private static ConfigConexao confConexao;
    private static ConfigGrid confGrid;
    
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
    
    public static ConfigConexao getConfigConexao() {
        if(confConexao == null)
            confConexao = new ConfigConexao();
        return confConexao;
    }
    
    public static ConfigGrid getConfigGrid() {
        if(confGrid == null)
            confGrid = new ConfigGrid();
        return confGrid;
    }
    
    public static void atualizaPainelConfigGrid() {
        janela.remove(confConexao);
        confGrid = getConfigGrid();
        confGrid.setOpaque(true);
        janela.add(confGrid);
        confGrid.revalidate();
    }
    
    private static void mostrar() {
        // frame
        janela = getJFrame();
        janela.setPreferredSize(new Dimension(MAX_LARGURA, MAX_ALTURA));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        
        // instancia um painel ConfigConexao
        confConexao = getConfigConexao();
        confConexao.setOpaque(true);
        
        // adiciona o painel à janela
        janela.add(confConexao);
        
        // mostrar frame
        janela.pack();
        janela.setVisible(true);
    }
}
