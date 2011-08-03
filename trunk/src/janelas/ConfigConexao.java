package janelas;

import componentesUI.Conexao;
import java.awt.Dimension;
import javax.swing.JPanel;

public class ConfigConexao extends JPanel {
    Conexao form;
    
    public ConfigConexao() {
        setLayout(null);
        
        form = new Conexao();
        form.setPreferredSize(new Dimension(200, 150));
        Dimension tamConexao = form.getPreferredSize();
        form.setBounds(300, 225, tamConexao.width, tamConexao.height);
        add(form);
    }
}
