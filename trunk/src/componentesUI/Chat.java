package componentesUI;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import java.awt.Cursor;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Chat extends JPanel {
    private JTextArea areaChat;
    private JScrollPane scrollChat;
    private JTextField areaEntrada;
    private JButton botEnviar;
    private JLabel labelNome;
    
    public Chat (String _nome) {
        setLayout(null);
        
        areaChat = new JTextArea();
        areaChat.setRows(5);
        areaChat.setColumns(20);
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setAutoscrolls(false);
        areaChat.setBorder(null);
        areaChat.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        scrollChat = new JScrollPane(areaChat);
        scrollChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollChat.setBounds(0, 0, 695, 108);
        add(scrollChat);

        labelNome = new JLabel();
        // reposicionar isso
        labelNome.setBounds(0, 0, 30, 23);
        labelNome.setText(_nome);
        add(labelNome);
        
        areaEntrada = new JTextField();
        areaEntrada.setBounds(0, 115, 598, 23);
        add(areaEntrada);

        botEnviar = new JButton();
        botEnviar.setText("Enviar");

        botEnviar.addActionListener(new eventosBotEnviar());
        botEnviar.setBounds(599, 115, 95, 22);
        add(botEnviar);
    }
        
    // por enquanto ele só faz um self loop: adiciona a frase pra janela de chat
    // * enviar ao apertar Enter
    // * IPC da Rede (GerenciaRede.java -> fazer parte do pacote núcleo)
    public class eventosBotEnviar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            areaChat.append(labelNome.getText() + ": " + areaEntrada.getText() + "\n");

            areaEntrada.setText("");
            areaEntrada.requestFocus();
        }
    }
}

