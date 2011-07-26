package componentesUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.GroupLayout;

public class Chat extends JPanel {
    private JTextArea areaChat;
    private JScrollPane scrollChat;
    private JLabel labelNome;
    private JTextField areaEntrada;
    private JButton botEnviar;

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
   
        GroupLayout layoutChat = new GroupLayout(this);

        layoutChat.setHorizontalGroup(
            layoutChat.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutChat.createSequentialGroup()
                .addComponent(labelNome, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaEntrada, GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botEnviar, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
            )
            .addComponent(scrollChat, GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
        );
        
        layoutChat.setVerticalGroup(
            layoutChat.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutChat.createSequentialGroup()
                .addComponent(scrollChat, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layoutChat.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botEnviar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        );
        
        setLayout(layoutChat);
    }
}
