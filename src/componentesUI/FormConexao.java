package componentesUI;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormConexao extends JPanel {
    private JTabbedPane abas;
    private JPanel servidor;
    private JPanel cliente;
    
    public FormConexao() {
        setLayout(null);
        
        abas = new JTabbedPane();
        servidor = new JPanel();
        cliente = new JPanel();
        
        abas.addTab("Servidor", servidor);
        abas.addTab("Cliente", cliente);
        add(abas);
        add(servidor);
        add(cliente);
                
        servidor.setBounds(0, 100, 400, 200);
        cliente.setBounds(0, 100, 400, 200);
    }
}
