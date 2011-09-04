package janelas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
    private static JButton sair;
    private static Thread ouvinte;

    public static JFrame getJanela() {
        return janela;
    }

    public static JButton getSair() {
        return sair;
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

        ouvinte = new Thread(Conexao.getConexao().new Ouvinte());
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
        janela.setPreferredSize(new Dimension(MAX_LARGURA, MAX_ALTURA));
        janela.setResizable(false);

        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new AcaoSair());

        // instancia um painel ConfigConexao
        mostraConfigConexao();

        // mostra frame
        janela.pack();
        janela.setVisible(true);
    }

    public static class AcaoSair extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            int resposta = JOptionPane.showConfirmDialog(Main.getJanela(), "Tem certeza de que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (resposta == 0) {
                if (Conexao.getConexao().writerInstanciado()) {
                    Conexao.getConexao().enviaAvisoDesistencia();
                    Conexao.getConexao().paraExecucao();
                    ouvinte.interrupt();
                    try {
                        Conexao.getConexao().fechaFluxos();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
                System.exit(0);
            }
        }
    }
}
