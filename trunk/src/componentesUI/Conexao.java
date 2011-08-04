package componentesUI;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.JButton;
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
    private JButton conectar;
    
    private JLabel labelNome2;
    private JTextField campoNome2;
    private JLabel labelIP2;
    private JTextField campoIP2;
    private JLabel labelPorta2;
    private JTextField campoPorta2;
    private JLabel status2;
    private JButton conectar2;
    
    public Conexao() {
        abas = new JTabbedPane();
        setLayout(new BorderLayout());
        
        montarFormCliente();
        montarFormServidor();
        
        add(abas);
    }
    
    private void montarFormCliente() {
        formCliente = new JPanel();
        formCliente.setLayout(null);
        
        labelIP = new JLabel("IP:");
        labelIP.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelIP = labelIP.getPreferredSize();
        labelIP.setBounds(8, 8, tamLabelIP.width, tamLabelIP.height);
        formCliente.add(labelIP);
        
        campoIP = new JTextField();
        campoIP.setPreferredSize(new Dimension(98, 17));
        Dimension tamCampoIP = campoIP.getPreferredSize();
        campoIP.setBounds(52, 8, tamCampoIP.width, tamCampoIP.height);
        campoIP.setText("");
        formCliente.add(campoIP);
        
        labelIP.setLabelFor(campoIP);
        
        labelPorta = new JLabel("Porta:");
        labelPorta.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelPorta = labelPorta.getPreferredSize();
        labelPorta.setBounds(8, tamLabelIP.height + 16, tamLabelPorta.width, tamLabelPorta.height);
        formCliente.add(labelPorta);
        
        campoPorta = new JTextField();
        campoPorta.setPreferredSize(new Dimension(40, 17));
        Dimension tamCampoPorta = campoPorta.getPreferredSize();
        campoPorta.setBounds(52, tamLabelIP.height + 16, tamCampoPorta.width, tamCampoPorta.height);
        formCliente.add(campoPorta);
        
        labelPorta.setLabelFor(campoPorta);
        
        labelNome = new JLabel("Nome:");
        labelNome.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelNome = labelNome.getPreferredSize();
        labelNome.setBounds(8, tamLabelIP.height + tamLabelPorta.height + 24, tamLabelNome.width, tamLabelNome.height);
        formCliente.add(labelNome);
        
        campoNome = new JTextField();
        campoNome.setPreferredSize(new Dimension(98, 17));
        Dimension tamCampoNome = campoNome.getPreferredSize();
        campoNome.setBounds(52, tamLabelIP.height + tamLabelPorta.height + 24, tamCampoNome.width, tamCampoNome.height);
        formCliente.add(campoNome);
        
        labelNome.setLabelFor(campoNome);
        
        status = new JLabel("Status:");
        status.setPreferredSize(new Dimension(40, 17));
        Dimension tamStatus = status.getPreferredSize();
        status.setBounds(8, tamLabelIP.height + tamLabelPorta.height + tamLabelNome.height + 32, tamStatus.width, tamStatus.height);
        formCliente.add(status);
        
        conectar = new JButton("Conectar");
        conectar.setPreferredSize(new Dimension(60, 17));
        Dimension tamConectar = conectar.getPreferredSize();
        conectar.setMargin(new Insets(0, 0, 0, 0));
        conectar.setBounds(132, 102, tamConectar.width, tamConectar.height);
        formCliente.add(conectar);
        
        abas.addTab("Cliente", formCliente);
    }
    
    private void montarFormServidor()
    {
        formServidor = new JPanel();
        formServidor.setLayout(null);
        
        labelIP2 = new JLabel("IP:");
        labelIP2.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelIP2 = labelIP2.getPreferredSize();
        labelIP2.setBounds(8, 8, tamLabelIP2.width, tamLabelIP2.height);
        formServidor.add(labelIP2);
        
        campoIP2 = new JTextField();
        campoIP2.setPreferredSize(new Dimension(98, 17));
        Dimension tamCampoIP2 = campoIP2.getPreferredSize();
        campoIP2.setBounds(52, 8, tamCampoIP2.width, tamCampoIP2.height);
        campoIP2.setText("255.255.255.255");
        campoIP2.setEditable(false);
        formServidor.add(campoIP2);
        
        labelIP2.setLabelFor(campoIP2);
        
        labelPorta2 = new JLabel("Porta:");
        labelPorta2.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelPorta2 = labelPorta2.getPreferredSize();
        labelPorta2.setBounds(8, tamLabelIP2.height + 16, tamLabelPorta2.width, tamLabelPorta2.height);
        formServidor.add(labelPorta2);
        
        campoPorta2 = new JTextField();
        campoPorta2.setPreferredSize(new Dimension(40, 17));
        Dimension tamCampoPorta2 = campoPorta2.getPreferredSize();
        campoPorta2.setBounds(52, tamLabelIP2.height + 16, tamCampoPorta2.width, tamCampoPorta2.height);
        formServidor.add(campoPorta2);
        
        labelPorta2.setLabelFor(campoPorta2);
        
        labelNome2 = new JLabel("Nome:");
        labelNome2.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelNome2 = labelNome2.getPreferredSize();
        labelNome2.setBounds(8, tamLabelIP2.height + tamLabelPorta2.height + 24, tamLabelNome2.width, tamLabelNome2.height);
        formServidor.add(labelNome2);
        
        campoNome2 = new JTextField();
        campoNome2.setPreferredSize(new Dimension(98, 17));
        Dimension tamCampoNome2 = campoNome2.getPreferredSize();
        campoNome2.setBounds(52, tamLabelIP2.height + tamLabelPorta2.height + 24, tamCampoNome2.width, tamCampoNome2.height);
        formServidor.add(campoNome2);
        
        labelNome2.setLabelFor(campoNome2);
        
        status2 = new JLabel("Status:");
        status2.setPreferredSize(new Dimension(40, 17));
        Dimension tamStatus2 = status2.getPreferredSize();
        status2.setBounds(8, tamLabelIP2.height + tamLabelPorta2.height + tamLabelNome2.height + 32, tamStatus2.width, tamStatus2.height);
        formServidor.add(status2);
        
        conectar2 = new JButton("Conectar");
        conectar2.setPreferredSize(new Dimension(60, 17));
        Dimension tamConectar2 = conectar2.getPreferredSize();
        conectar2.setMargin(new Insets(0, 0, 0, 0));
        conectar2.setBounds(132, 102, tamConectar2.width, tamConectar2.height);
        formServidor.add(conectar2);
        
        abas.addTab("Servidor", formServidor);
    }
}