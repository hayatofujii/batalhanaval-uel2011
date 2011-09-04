package janelas;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Font;
import componentesUI.Chat;
import componentesUI.Grid;
import nucleo.Jogador;

public class EmJogo extends JPanel {

    private Chat chat;
    private static Grid grid, mini;
    private JLabel labelGrid, labelMini;
    private static JLabel pontos;

    public static Grid getGrid() {
        return grid;
    }

    public static Grid getMini() {
        return mini;
    }

    public static void setLabelPontos() {
        pontos.setText("Pontos: " + Jogador.getJogador().getPontos());
    }

    public EmJogo() {
        labelGrid = new JLabel("Grid do oponente");
        labelGrid.setFont(new Font("Arial", Font.PLAIN, 18));
        labelGrid.setPreferredSize(new Dimension(139, 19));
        Dimension tamLabelGrid = labelGrid.getPreferredSize();
        labelGrid.setBounds(50, 18, tamLabelGrid.width, tamLabelGrid.height);
        add(labelGrid);

        labelMini = new JLabel("Seu grid");
        labelMini.setFont(new Font("Arial", Font.PLAIN, 18));
        labelMini.setPreferredSize(new Dimension(67, 19));
        Dimension tamLabelMini = labelMini.getPreferredSize();
        labelMini.setBounds(475, 18, tamLabelMini.width, tamLabelMini.height);
        add(labelMini);

        pontos = new JLabel("Pontos: " + Jogador.getJogador().getPontos());
        pontos.setFont(new Font("Arial", Font.PLAIN, 18));
        pontos.setPreferredSize(new Dimension(106, 19));
        Dimension tamPontos = pontos.getPreferredSize();
        pontos.setBounds(475, 280, tamPontos.width, tamPontos.height);
        add(pontos);

        grid = new Grid(2);
        mini = new Grid(0);
        mini.montaMini();

        chat = Chat.getChat();

        setLayout(null);
        setPreferredSize(new Dimension(800, 600));

        grid.setPreferredSize(new Dimension(350, 350));
        Dimension tamGrid = grid.getPreferredSize();
        grid.setBounds(50, 50, tamGrid.width, tamGrid.height);
        add(grid);

        mini.setPreferredSize(new Dimension(200, 200));
        Dimension tamMini = mini.getPreferredSize();
        mini.setBounds(125 + tamGrid.width, 50, tamMini.width, tamMini.height);
        add(mini);

        Dimension tamChat = chat.getPreferredSize();
        chat.setBounds(50, tamGrid.height + 58, tamChat.width, tamChat.height);
        add(chat);
    }
}