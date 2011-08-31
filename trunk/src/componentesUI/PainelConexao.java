package componentesUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import janelas.Main;

import nucleo.Conexao;
import nucleo.Jogador;

public class PainelConexao extends JPanel {
    private JTabbedPane abas;
    
    private JPanel formServidor;
    private JPanel formCliente;
    private JLabel labelNome;
    private JTextField campoNome;
    private JLabel labelIP;
    private JTextField campoIP;
    private JLabel labelPorta;
    private JTextField campoPorta;
    private JLabel labelStatus;
    private JButton botConectar;
    
    private JLabel labelNomeSv;
    private JTextField campoNomeSv;
    private JLabel labelIPSv;
    private JTextField campoIPSv;
    private JLabel labelPortaSv;
    private JTextField campoPortaSv;
    private JLabel labelStatusSv;
    private JButton botConectarSv;

    private void configTesteCliente() {
        campoPorta.setText("1717");
        campoPortaSv.setText("1717");

        campoIP.setText("localhost");

        campoNome.setText("xptoA");
        campoNomeSv.setText("xptoB");
    }

    public PainelConexao() {
        abas = new JTabbedPane();
        setLayout(new BorderLayout());

        montarFormCliente();
        montarFormServidor();

        add(abas);

        configTesteCliente();
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

        labelStatus = new JLabel();
        labelStatus.setPreferredSize(new Dimension(40, 17));
        Dimension tamStatus = labelStatus.getPreferredSize();
        labelStatus.setBounds(8, 102, tamStatus.width, tamStatus.height);
        formCliente.add(labelStatus);

        botConectar = new JButton("Conectar");
        botConectar.setPreferredSize(new Dimension(60, 17));
        Dimension tamConectar = botConectar.getPreferredSize();
        botConectar.setMargin(new Insets(0, 0, 0, 0));
        botConectar.setBounds(70, tamLabelIP.height + tamLabelPorta.height + tamLabelNome.height + 32, tamConectar.width, tamConectar.height);
        botConectar.addActionListener(new EventoBotConectar());
        formCliente.add(botConectar);

        abas.addTab("Cliente", formCliente);
    }

    private void montarFormServidor() {
        formServidor = new JPanel();
        formServidor.setLayout(null);

        labelIPSv = new JLabel("IP:");
        labelIPSv.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelIPSv = labelIPSv.getPreferredSize();
        labelIPSv.setBounds(8, 8, tamLabelIPSv.width, tamLabelIPSv.height);
        formServidor.add(labelIPSv);

        campoIPSv = new JTextField();
        campoIPSv.setPreferredSize(new Dimension(98, 17));
        Dimension tamCampoIPSv = campoIPSv.getPreferredSize();
        campoIPSv.setBounds(52, 8, tamCampoIPSv.width, tamCampoIPSv.height);
        campoIPSv.setEditable(false);
        formServidor.add(campoIPSv);

        labelIPSv.setLabelFor(campoIPSv);

        labelPortaSv = new JLabel("Porta:");
        labelPortaSv.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelPortaSv = labelPortaSv.getPreferredSize();
        labelPortaSv.setBounds(8, tamLabelIPSv.height + 16, tamLabelPortaSv.width, tamLabelPortaSv.height);
        formServidor.add(labelPortaSv);

        campoPortaSv = new JTextField();
        campoPortaSv.setPreferredSize(new Dimension(40, 17));
        Dimension tamCampoPortaSv = campoPortaSv.getPreferredSize();
        campoPortaSv.setBounds(52, tamLabelIPSv.height + 16, tamCampoPortaSv.width, tamCampoPortaSv.height);
        formServidor.add(campoPortaSv);

        labelPortaSv.setLabelFor(campoPortaSv);

        labelNomeSv = new JLabel("Nome:");
        labelNomeSv.setPreferredSize(new Dimension(40, 17));
        Dimension tamLabelNomeSv = labelNomeSv.getPreferredSize();
        labelNomeSv.setBounds(8, tamLabelIPSv.height + tamLabelPortaSv.height + 24, tamLabelNomeSv.width, tamLabelNomeSv.height);
        formServidor.add(labelNomeSv);

        campoNomeSv = new JTextField();
        campoNomeSv.setPreferredSize(new Dimension(98, 17));
        Dimension tamCampoNomeSv = campoNomeSv.getPreferredSize();
        campoNomeSv.setBounds(52, tamLabelIPSv.height + tamLabelPortaSv.height + 24, tamCampoNomeSv.width, tamCampoNomeSv.height);
        formServidor.add(campoNomeSv);

        labelNomeSv.setLabelFor(campoNomeSv);

        labelStatusSv = new JLabel();
        labelStatusSv.setPreferredSize(new Dimension(184, 17));
        Dimension tamStatusSv = labelStatusSv.getPreferredSize();
        labelStatusSv.setBounds(8, 102, tamStatusSv.width, tamStatusSv.height);
        formServidor.add(labelStatusSv);

        botConectarSv = new JButton("Iniciar");
        botConectarSv.setPreferredSize(new Dimension(60, 17));
        Dimension tamConectarSv = botConectarSv.getPreferredSize();
        botConectarSv.setMargin(new Insets(0, 0, 0, 0));
        botConectarSv.setBounds(70, tamLabelIPSv.height + tamLabelPortaSv.height + tamLabelNomeSv.height + 32, tamConectarSv.width, tamConectarSv.height);
        botConectarSv.addActionListener(new EventoBotConectarSv());
        formServidor.add(botConectarSv);

        abas.addTab("Servidor", formServidor);

        atualizaIP();
    }

    private void atualizaIP() {
        atualizaStatusSv("Detectando IP da máquina...");
        campoIPSv.setText(Conexao.getConexao().detectarIP());
        atualizaStatusSv("");
    }

    public void atualizaStatusSv(String _msg) {
        labelStatusSv.setText(_msg);
    }

    private class EventoBotConectar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            Conexao.getConexao().conectarCliente(campoIP.getText(), Integer.parseInt(campoPorta.getText()));
            Jogador.getJogador().setNome(campoNome.getText());
            Jogador.getJogador().setTurno(false);
            Main.mostraConfigGrid();
        }
    }

    private class EventoBotConectarSv implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            Jogador.getJogador().setNome(campoNomeSv.getText());
            atualizaStatusSv("Aguardando cliente...");

            Conexao.getConexao().inicializarServidor(Integer.parseInt(campoPortaSv.getText()));
            Jogador.getJogador().setTurno(true);

            // "desativa" a interface de conexão
            botConectarSv.setEnabled(false);
            abas.setEnabledAt(0, false);
            campoPortaSv.setEnabled(false);
            campoNomeSv.setEnabled(false);
        }
    }
}
