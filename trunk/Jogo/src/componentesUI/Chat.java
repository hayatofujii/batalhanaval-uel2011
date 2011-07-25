package componentesUI;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class Chat extends JPanel {

    private JTextArea areaChat;
    private JScrollPane scrollChat;
    private JLabel labelNome;
    private JTextField areaEntrada;
    private JButton botEnviar;
    private JButton botDesconectar;

    public Chat() {        
        areaChat = new JTextArea();
        areaChat.setRows(5);
        areaChat.setColumns(20);
        areaChat.setEditable(false);
        areaChat.setLineWrap(true);
        areaChat.setAutoscrolls(false);
        areaChat.setBorder(null);
        areaChat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        scrollChat = new JScrollPane();
        scrollChat.setViewportView(areaChat);

        labelNome = new javax.swing.JLabel();
        labelNome.setText("Nome");

        areaEntrada = new javax.swing.JTextField();

        botEnviar = new JButton();
        botEnviar.setText("Enviar");

        botDesconectar = new JButton();
        botDesconectar.setText("Desconectar");
        
        GroupLayout layoutChat = new GroupLayout()

        layoutChat.setHorizontalGroup(
            layoutChat.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutChat.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutChat.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layoutChat.createSequentialGroup()
                        .addComponent(scrollChat, GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layoutChat.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addComponent(areaEntrada, GroupLayout.PREFERRED_SIZE, 557, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botEnviar,GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botDesconectar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
    }
}
