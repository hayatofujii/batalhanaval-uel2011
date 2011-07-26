package componentesUI;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;

public class Chat extends JPanel {
    private JTextArea areaChat;
    private JScrollPane scrollChat;
    private JTextField areaEntrada;
    private JButton botEnviar;

    public Chat() {
        setLayout(null);
        
        areaChat = new JTextArea();
        areaChat.setRows(5);
        areaChat.setColumns(20);
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setAutoscrolls(false);
        areaChat.setBorder(null);
        areaChat.setCursor(new Cursor(Cursor.TEXT_CURSOR));

        scrollChat = new JScrollPane();
        scrollChat.setViewportView(areaChat);
        scrollChat.setBounds(0, 0, 717, 108);
        add(scrollChat);

        areaEntrada = new JTextField();
        areaEntrada.setBounds(0, 115, 620, 23);
        add(areaEntrada);

        botEnviar = new JButton();
        botEnviar.setText("Enviar");
        botEnviar.setBounds(621, 115, 95, 22);
        add(botEnviar);
    }
}
