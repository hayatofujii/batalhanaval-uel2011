package componentesUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Chat extends JPanel {
    private JTextArea areaChat;
    private JScrollPane scrollChat;
    private JButton botNome;
    private JTextField areaEntrada;
    private JButton botEnviar;
    
    public Chat(String _nome) {
        setLayout(null);
        
        areaChat = new JTextArea(5, 20);
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setAutoscrolls(false);
        areaChat.setBorder(null);
        areaChat.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        scrollChat = new JScrollPane(areaChat);
        scrollChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollChat.setBounds(0, 0, 700, 110);
        add(scrollChat);

        botNome = new JButton(_nome);
        botNome.setBounds(0, 115, 87, 23);
        add(botNome);
        
        areaEntrada = new JTextField();
        areaEntrada.addKeyListener(new eventoAreaEntrada());
        areaEntrada.setBounds(93, 115, 499, 23);
        add(areaEntrada);

        botEnviar = new JButton("Enviar");

        botEnviar.addActionListener(new eventoBotEnviar());
        botEnviar.setBounds(599, 115, 95, 22);
        add(botEnviar);
    }
    
    // adiciona a frase à janela de chat
    // * IPC da rede (GerenciaRede.java -> fazer parte do pacote núcleo)
    // * Bug: enviando mensagem vazia
    private void enviarMensagem (String _msg) {
        areaChat.append(_msg +" \n");
        
        areaEntrada.setText("");
        areaEntrada.requestFocus();
    }
    
    private class eventoBotEnviar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            enviarMensagem(botNome.getText() + ": " + areaEntrada.getText());
        }
    }
    
    private class eventoAreaEntrada implements KeyListener {
        @Override
        public void keyTyped(KeyEvent ev) {}
        
        @Override
        public void keyPressed(KeyEvent ev) {}
        
        @Override
        public void keyReleased(KeyEvent ev) {
            if(ev.getKeyCode() == KeyEvent.VK_ENTER) {
                enviarMensagem(botNome.getText() + ": " + areaEntrada.getText());
            }
        }
    }
}

