/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package configuraGrid;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * Classe Chat
 * @author Hayato Fujii
 */
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
        botDesconectar.setToolTipText("Desconectar e desistir do jogo.");

        GroupLayout layoutChat = new GroupLayout(this);
        setLayout(layoutChat);
                
        layoutChat.setHorizontalGroup(
            layoutChat.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layoutChat.createSequentialGroup()
                .addContainerGap()
                .addGroup(layoutChat.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scrollChat, GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.TRAILING, layoutChat.createSequentialGroup()
                        .addComponent(labelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(areaEntrada, GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botEnviar, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(botDesconectar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        
        layoutChat.setVerticalGroup(
            layoutChat.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layoutChat.createSequentialGroup()
                .addGap(465, 465, 465)
                .addComponent(scrollChat, GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layoutChat.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(areaEntrada, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botDesconectar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(botEnviar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }
}
