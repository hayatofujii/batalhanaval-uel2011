package janelas;

import componentesUI.Conexao;
import java.awt.Dimension;

import javax.swing.JPanel;

public class ConfigConexao extends JPanel {
    Conexao form;
    
    public ConfigConexao() {
        setLayout(null);
        
        form = new Conexao();
        Dimension tam = form.getPreferredSize();
        form.setBounds(200, 150, tam.width, tam.height);      
        add(form);
    }
}