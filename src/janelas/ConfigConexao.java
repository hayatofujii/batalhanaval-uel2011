package janelas;

import componentesUI.Conexao;

import javax.swing.JPanel;

public class ConfigConexao extends JPanel {
    Conexao form;
    
    public ConfigConexao() {
        setLayout(null);
        
        form = new Conexao();
        form.setBounds(200, 150, 400, 300);      
        add(form);
    }
}
