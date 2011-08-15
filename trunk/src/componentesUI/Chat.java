package componentesUI;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Cursor;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import nucleo.ConexaoCliente;

public class Chat extends JPanel {
    private static Chat chat;
    private JTextArea areaChat;
    private JScrollPane scrollChat;
    private JButton botNome;
    private JTextField areaEntrada;
    private JButton botEnviar;
    
    public static Chat getChat() {
        if(chat == null) {
            chat = new Chat();
        }
        return chat;
    }
        
    private Chat() {
        setLayout(null);
        setPreferredSize(new Dimension(700, 300));
        
        // areaChat
        areaChat = new JTextArea();
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setAutoscrolls(false);
        areaChat.setBorder(null);
        areaChat.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        
        scrollChat = new JScrollPane(areaChat);
        scrollChat.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollChat.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        // tamanho e posicionamento areaChat
        scrollChat.setPreferredSize(new Dimension(700, 100));
        Dimension tamAreaChat = scrollChat.getPreferredSize();
        scrollChat.setBounds(0, 0, tamAreaChat.width, tamAreaChat.height);
        add(scrollChat);
        
        // botNome
        botNome = new JButton("");
        botNome.setMargin(new Insets(0, 0, 0, 0));
        
        // tamanho e posicionamento botNome
        botNome.setPreferredSize(new Dimension(100, 22));
        botNome.setToolTipText("Editar nome");
        Dimension tamBotNome = botNome.getPreferredSize();
        botNome.setBounds(0, 8 + tamAreaChat.height, tamBotNome.width, tamBotNome.height);
        add(botNome);
        
        // areaEntrada
        areaEntrada = new JTextField();
        areaEntrada.addKeyListener(new eventoAreaEntrada());
        
        // tamanho e posicionamento areaEntrada
        areaEntrada.setPreferredSize(new Dimension(513, 23));
        Dimension tamAreaEntrada = areaEntrada.getPreferredSize();
        areaEntrada.setBounds(tamBotNome.width + 8, 8 + tamAreaChat.height, tamAreaEntrada.width, tamAreaEntrada.height);
        add(areaEntrada);
        
        // botEnviar
        botEnviar = new JButton("Enviar");
        botEnviar.addActionListener(new eventoBotEnviar());
        
        // tamanho e posicionamento botEnviar
        botEnviar.setPreferredSize(new Dimension(70, 22));
        Dimension tamBotEnviar = botEnviar.getPreferredSize();
        botEnviar.setBounds(16 + tamBotNome.width + tamAreaEntrada.width, 8 + tamAreaChat.height, tamBotEnviar.width, tamBotEnviar.height);
        add(botEnviar);
    }
    
    // adiciona a frase à janela de chat
    // * IPC da rede (GerenciaRede.java -> fazer parte do pacote núcleo)
    // * Bug: enviando mensagem vazia
    private void enviarMensagem(String _msg) {
        colocaMensagemAreaChat(_msg);
        ConexaoCliente.getConexao().enviarMensagem(_msg);
        
        areaEntrada.setText("");
        areaEntrada.requestFocus();
    }
    
    public void colocaMensagemAreaChat(String _msg) {
        areaChat.append(_msg + "\n");
    }
    
    public void setBotNome(String _nome) {
        botNome.setText(_nome);
    }
    
    private class eventoBotEnviar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ev) {
            if(!areaEntrada.getText().equals(""))
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
            if(ev.getKeyCode() == KeyEvent.VK_ENTER)
                if(!areaEntrada.getText().equals(""))
                    enviarMensagem(botNome.getText() + ": " + areaEntrada.getText());
        }
    }
}