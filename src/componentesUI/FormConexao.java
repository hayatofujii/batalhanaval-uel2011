package componentesUI;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class FormConexao extends JPanel {
    private JTabbedPane abas;
    private JPanel servidor;
    private JPanel cliente;
    
    public FormConexao() {
        abas = new JTabbedPane();
        servidor = new JPanel();
        cliente = new JPanel();
        
        setLayout(new BorderLayout());
        
        abas.addTab("Servidor", servidor);
        abas.addTab("Cliente", cliente);
        
        add(abas);
    }
}
