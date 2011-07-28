package janelas;

import componentesUI.FormConexao;
import javax.swing.JPanel;

public class EmJogo extends JPanel {
    FormConexao form;
    
    public EmJogo() {
        setLayout(null);
        
        form = new FormConexao();
        form.setBounds(200, 150, 400, 300);      
        add(form);
    }
}
