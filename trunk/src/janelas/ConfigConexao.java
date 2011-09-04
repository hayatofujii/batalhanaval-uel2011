package janelas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import componentesUI.PainelConexao;
import java.awt.Font;

public class ConfigConexao extends JPanel {

    private PainelConexao form;
    private JLabel batalha, redes, andre, hayato, paulo;

    public ConfigConexao() {
        setLayout(null);

        form = new PainelConexao();
        form.setPreferredSize(new Dimension(200, 150));
        Dimension tamConexao = form.getPreferredSize();
        form.setBounds(300, 208, tamConexao.width, tamConexao.height);
        add(form);

        batalha = new JLabel("BATALHA NAVAL");
        batalha.setFont(new Font("Arial", Font.BOLD, 26));
        batalha.setPreferredSize(new Dimension(224, 20));
        Dimension tamBatalha = batalha.getPreferredSize();
        batalha.setBounds(288, 36, tamBatalha.width, tamBatalha.height);
        add(batalha);

        redes = new JLabel("REDES DE COMPUTADORES");
        redes.setPreferredSize(new Dimension(157, 17));
        Dimension tamRedes = redes.getPreferredSize();
        redes.setBounds(322, 83, tamRedes.width, tamRedes.height);
        add(redes);

        andre = new JLabel("Andre Augusto Del Grossi");
        andre.setPreferredSize(new Dimension(145, 17));
        Dimension tamAndre = andre.getPreferredSize();
        andre.setBounds(328, 123, tamAndre.width, tamAndre.height);
        add(andre);

        hayato = new JLabel("Hayato Fujii");
        hayato.setPreferredSize(new Dimension(64, 17));
        Dimension tamHayato = hayato.getPreferredSize();
        hayato.setBounds(368, 143, tamHayato.width, tamHayato.height);
        add(hayato);

        paulo = new JLabel("Paulo Henrique de Oliveira");
        paulo.setPreferredSize(new Dimension(149, 17));
        Dimension tamPaulo = paulo.getPreferredSize();
        paulo.setBounds(326, 163, tamPaulo.width, tamPaulo.height);
        add(paulo);
    }
}