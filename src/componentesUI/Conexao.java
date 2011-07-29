package componentesUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Conexao extends JPanel {
    private JTabbedPane abas;
    private JPanel formServidor;
    private JPanel formCliente;

    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelIP;
    private JTextField campoIP;
    private JLabel labelPorta;
    private JTextField campoPorta;
    private JLabel status;
    
    public Conexao() {
        abas = new JTabbedPane();
        setLayout(new BorderLayout());
        
        labelIP = new JLabel("IP:");
        labelPorta = new JLabel("Porta:");
        
        labelNome = new JLabel("Nome:");
        campoNome = new JTextField();
        
        montarFormCliente();
        montarFormServidor();
        
        status = new JLabel("Status");
        status.setBounds(0, 30, 100, 23);
        
        add(abas);
    }
    
    private void montarFormServidor()
    {
        formServidor = new JPanel();
        formServidor.setLayout(null);
        
        // mudar isso para mostrar IPs, precisa de um subsistema de rede
        // reposicionar
        JLabel mostraIP = new JLabel("255.255.255.255 em 255.555.255.255");
        mostraIP.setBounds(0, 0, 210, 23);
        formServidor.add(mostraIP);
        
        formServidor.add(labelNome);
        formServidor.add(campoNome);
        
        abas.addTab("Servidor", formServidor);
    }

    private void montarFormCliente() {
        formCliente = new JPanel();
        formCliente.setLayout(null);
        
        abas.addTab("Cliente", formCliente);
    }
}
