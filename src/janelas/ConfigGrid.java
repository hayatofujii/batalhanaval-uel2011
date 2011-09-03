package janelas;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import componentesUI.Grid;

public class ConfigGrid extends JPanel {

    private Grid grid;
    private static JRadioButton vertical;
    private static JRadioButton horizontal;
    private ButtonGroup grupoBotoes;
    private JLabel posicione;

    public static JRadioButton getVertical() {
        if (vertical == null) {
            vertical = new JRadioButton("Vertical", true);
        }
        return vertical;
    }

    public static JRadioButton getHorizontal() {
        if (horizontal == null) {
            horizontal = new JRadioButton("Horizontal", false);
        }
        return horizontal;
    }

    public ConfigGrid() {
        posicione = new JLabel("Posicione seus barcos.");
        posicione.setFont(new Font("Arial", Font.PLAIN, 18));
        posicione.setPreferredSize(new Dimension(185, 17));
        Dimension tamPosicione = posicione.getPreferredSize();
        posicione.setBounds(50, 18, tamPosicione.width, tamPosicione.height);
        add(posicione);
        
        grid = new Grid(1);

        setLayout(null);
        setPreferredSize(new Dimension(800, 600));

        grid.setPreferredSize(new Dimension(350, 350));
        Dimension tamGrid = grid.getPreferredSize();
        grid.setBounds(50, 50, tamGrid.width, tamGrid.height);
        add(grid);

        vertical = getVertical();
        horizontal = getHorizontal();
        grupoBotoes = new ButtonGroup();

        vertical.addActionListener(new EventoBotaoRadioVertical());
        horizontal.addActionListener(new EventoBotaoRadioHorizontal());

        grupoBotoes.add(vertical);
        grupoBotoes.add(horizontal);

        vertical.setPreferredSize(new Dimension(69, 17));
        Dimension tamBotaoVertical = vertical.getPreferredSize();
        vertical.setBounds(50, tamGrid.height + 58, tamBotaoVertical.width, tamBotaoVertical.height);
        add(vertical);

        horizontal.setPreferredSize(new Dimension(82, 17));
        Dimension tamBotaoHorizontal = horizontal.getPreferredSize();
        horizontal.setBounds(tamBotaoVertical.width + 58, tamGrid.height + 58, tamBotaoHorizontal.width, tamBotaoHorizontal.height);
        add(horizontal);
    }

    private class EventoBotaoRadioVertical implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            Grid.setBooleanVertical(true);
        }
    }

    private class EventoBotaoRadioHorizontal implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ev) {
            Grid.setBooleanVertical(false);
        }
    }
}