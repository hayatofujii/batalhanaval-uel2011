package janelas;

import javax.swing.JPanel;
import java.awt.Dimension;
import componentesUI.PainelConexao;

public class ConfigConexao extends JPanel {

    PainelConexao form;

    public ConfigConexao() {
        setLayout(null);

        form = new PainelConexao();
        form.setPreferredSize(new Dimension(200, 150));
        Dimension tamConexao = form.getPreferredSize();
        form.setBounds(300, 225, tamConexao.width, tamConexao.height);
        add(form);
    }
}