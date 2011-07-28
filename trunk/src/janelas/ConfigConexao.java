package janelas;

import componentesUI.FormConexao;
import javax.swing.JPanel;

public class ConfigConexao extends JPanel {
    FormConexao form;
    
    public ConfigConexao() {
        setLayout(null);
        
        form = new FormConexao();
        
        form.setBounds(200, 150, 400, 300);
    }
}
