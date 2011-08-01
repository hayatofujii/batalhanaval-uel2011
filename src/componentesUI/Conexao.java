package componentesUI;


import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Dimension;

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
        setLayout(null);
        setPreferredSize(new Dimension(400, 300));
        
        labelIP = new JLabel("IP:");
        campoIP = new JTextField();
        
        labelPorta = new JLabel("Porta:");
        campoPorta = new JTextField();
        
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
        
        formServidor.add(labelIP);
        campoIP.setText("255.255.255.255");
        campoIP.setEditable(false);
        campoIP.setEnabled(false);
        formServidor.add(campoIP);
        labelIP.setLabelFor(campoIP);
        
        formServidor.add(labelPorta);
        formServidor.add(campoPorta);
        labelPorta.setLabelFor(campoPorta);
        
        formServidor.add(labelNome);
        formServidor.add(campoNome);
        labelNome.setLabelFor(campoNome);
        
        abas.addTab("Servidor", formServidor);
    }

    private void montarFormCliente() {
        formCliente = new JPanel();
        formCliente.setLayout(null);
        
        formCliente.add(labelIP);
        campoIP.setText("");
        campoIP.setEditable(true);
        campoIP.setEnabled(true);
        formCliente.add(campoIP);
        labelIP.setLabelFor(campoIP);
        
        formCliente.add(labelPorta);
        formCliente.add(campoPorta);
        labelPorta.setLabelFor(campoPorta);
        
        formCliente.add(labelNome);
        formCliente.add(campoNome);
        labelNome.setLabelFor(campoNome);
        
        abas.addTab("Cliente", formCliente);
    }
}
