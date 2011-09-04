package janelas;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import nucleo.Conexao;

public class Main {

    private static JFrame janela;
    private static ConfigConexao confConex;
    private static ConfigGrid confGrid;
    private static EmJogo emJogo;
    private static final int MAX_LARGURA = 800;
    private static final int MAX_ALTURA = 600;

    public static JFrame getJanela() {
        return janela;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                new Runnable() {

                    @Override
                    public void run() {
                        mostrar();
                    }
                });
    }

    public static void mostraConfigConexao() {
        confConex = new ConfigConexao();
        confConex.setOpaque(true);
        janela.add(confConex);

        confConex.revalidate();
    }

    public static void mostraConfigGrid() {
        janela.remove(confConex);

        confGrid = new ConfigGrid();
        confGrid.setOpaque(true);
        janela.add(confGrid);

        confGrid.revalidate();

        Thread ouvinte = new Thread(Conexao.getConexao().new Ouvinte());
        ouvinte.start();
    }

    public static void mostraEmJogo() {
        janela.remove(confGrid);

        emJogo = new EmJogo();
        emJogo.setOpaque(true);
        janela.add(emJogo);

        emJogo.revalidate();
    }

    public static void reiniciaJogo() {
        janela.remove(emJogo);
        
        emJogo = null;
        confGrid = new ConfigGrid();
        confGrid.setOpaque(true);
        janela.add(confGrid);

        confGrid.revalidate();
    }

    public static void voltaAoInicio() throws IOException {
        if (emJogo != null) {
            janela.remove(emJogo);
            emJogo = null;
        } else {
            janela.remove(confGrid);
            confGrid = null;
        }

        confConex = new ConfigConexao();
        confConex.setOpaque(true);
        janela.add(confConex);

        confConex.revalidate();
    }

    private static void mostrar() {
        // frame
        janela = new JFrame("Batalha Naval");
        janela.addWindowListener(new EventoFechaJanela());
        janela.setPreferredSize(new Dimension(MAX_LARGURA, MAX_ALTURA));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);

        // instancia um painel ConfigConexao
        mostraConfigConexao();

        // mostra frame
        janela.pack();
        janela.setVisible(true);
    }
    
    private static class EventoFechaJanela extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            if (Conexao.getConexao().writerInstanciado()) {
                Conexao.getConexao().enviaAvisoDesistencia();
                try {
                    Conexao.getConexao().fechaFluxos();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}