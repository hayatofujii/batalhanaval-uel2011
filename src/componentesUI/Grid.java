package componentesUI;

import janelas.Main;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import nucleo.Conexao;
import nucleo.Jogador;

public class Grid extends JPanel {
    // ícones
    private ImageIcon sea_tile = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile.jpg"));
    private ImageIcon sea_tile_temp = new ImageIcon(getClass().getResource("../imagensGrid/sea-tile-temp.jpg"));
    // barco 1 - vertical
    private ImageIcon b11_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b11-c-b-v.jpg"));
    private ImageIcon b12_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b12-c-b-v.jpg"));
    private ImageIcon b13_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b13-c-b-v.jpg"));
    private ImageIcon b14_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b14-c-b-v.jpg"));
    private ImageIcon b15_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b15-c-b-v.jpg"));
    // barco 1 - horizontal
    private ImageIcon b11_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b11-c-b-h.jpg"));
    private ImageIcon b12_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b12-c-b-h.jpg"));
    private ImageIcon b13_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b13-c-b-h.jpg"));
    private ImageIcon b14_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b14-c-b-h.jpg"));
    private ImageIcon b15_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b15-c-b-h.jpg"));
    // barco 2 - vertical
    private ImageIcon b21_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b21-c-b-v.jpg"));
    private ImageIcon b22_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b22-c-b-v.jpg"));
    private ImageIcon b23_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b23-c-b-v.jpg"));
    private ImageIcon b24_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b24-c-b-v.jpg"));
    // barco 2 - horizontal
    private ImageIcon b21_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b21-c-b-h.jpg"));
    private ImageIcon b22_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b22-c-b-h.jpg"));
    private ImageIcon b23_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b23-c-b-h.jpg"));
    private ImageIcon b24_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b24-c-b-h.jpg"));
    // barco 3 - vertical
    private ImageIcon b31_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b31-c-b-v.jpg"));
    private ImageIcon b32_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b32-c-b-v.jpg"));
    private ImageIcon b33_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b33-c-b-v.jpg"));
    // barco 3 - horizontal
    private ImageIcon b31_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b31-c-b-h.jpg"));
    private ImageIcon b32_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b32-c-b-h.jpg"));
    private ImageIcon b33_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b33-c-b-h.jpg"));
    // barco 4 - vertical
    private ImageIcon b41_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b41-c-b-v.jpg"));
    private ImageIcon b42_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b42-c-b-v.jpg"));
    private ImageIcon b43_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b43-c-b-v.jpg"));
    // barco 4 - horizontal
    private ImageIcon b41_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b41-c-b-h.jpg"));
    private ImageIcon b42_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b42-c-b-h.jpg"));
    private ImageIcon b43_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b43-c-b-h.jpg"));
    // barco 5 - vertical
    private ImageIcon b51_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b51-c-b-v.jpg"));
    private ImageIcon b52_c_b_v = new ImageIcon(getClass().getResource("../imagensGrid/b52-c-b-v.jpg"));
    // barco 5 - horizontal
    private ImageIcon b51_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b51-c-b-h.jpg"));
    private ImageIcon b52_c_b_h = new ImageIcon(getClass().getResource("../imagensGrid/b52-c-b-h.jpg"));
    // botões
    private JButton[][] botoes;
    // ouvinte dos eventos de mouse
    private MouseListener mouseListener;
    // sentido do barco a ser inserido
    private static boolean vertical;

    // setter para a variável booleana vertical
    public static void setBooleanVertical(boolean valor) {
        vertical = valor;
    }

    public Grid(int tipoListener) {
        // grid
        super(new GridLayout(10, 10));

        // botões
        botoes = new JButton[10][10];
        
        if (tipoListener == 1) {
            // por padrão, o sentido dos barcos é vertical
            vertical = true;

            mouseListener = new EventoBotaoGrid_AdicionaBarco1();
        }
        
        if (tipoListener == 2) {
            mouseListener = new EventoBotaoGrid_EmJogo();
        }
        
        // insere os botões
        insereBotoes();
    }

    public void setBotao(int x, int y, String nomeIcone) {
        ImageIcon icone = new ImageIcon(getClass().getResource("../imagensGrid/" + nomeIcone + ".jpg"));
        botoes[x][y].setIcon(icone);
    }
    
    private void insereBotoes() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // cria e configura o botão
                botoes[i][j] = new JButton();
                botoes[i][j].setMargin(new Insets(0, 0, 0, 0));
                botoes[i][j].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
                botoes[i][j].setIcon(sea_tile);

                // adiciona o ouvinte de eventos referentes ao barco 1
                botoes[i][j].addMouseListener(mouseListener);

                // coloca o botão no painel
                add(botoes[i][j]);
            }
        }
    }

    public void atualizaMouseListener(MouseListener _mouseListener) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botoes[i][j].removeMouseListener(mouseListener);
            }
        }
        mouseListener = _mouseListener;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                botoes[i][j].addMouseListener(mouseListener);
            }
        }
    }

    private class EventoBotaoGrid_EmJogo extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        Conexao.getConexao().enviarCoordenadas(i, j);
                    }
                }
            }
        }
    }

    private class EventoBotaoGrid_AdicionaBarco1 extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 5) {
                                for (int k = 0; k < 5; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 5; k++) {
                                    botoes[i + k][j].setIcon(sea_tile_temp);
                                }
                            }
                        } else {
                            if (j <= 5) {
                                for (int k = 0; k < 5; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 5; k++) {
                                    botoes[i][j + k].setIcon(sea_tile_temp);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 5) {
                                for (int k = 0; k < 5; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 5; k++) {
                                    botoes[i + k][j].setIcon(sea_tile);
                                }
                            }
                        } else {
                            if (j <= 5) {
                                for (int k = 0; k < 5; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 5; k++) {
                                    botoes[i][j + k].setIcon(sea_tile);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 5) {
                                for (int k = 0; k < 5; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b11_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b11_c_b_v");
                                botoes[i + 1][j].setIcon(b12_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 1, j, "b12_c_b_v");
                                botoes[i + 2][j].setIcon(b13_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 2, j, "b13_c_b_v");
                                botoes[i + 3][j].setIcon(b14_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 3, j, "b14_c_b_v");
                                botoes[i + 4][j].setIcon(b15_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 4, j, "b15_c_b_v");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco2());
                            }
                        } else {
                            if (j <= 5) {
                                for (int k = 0; k < 5; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b11_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b11_c_b_h");
                                botoes[i][j + 1].setIcon(b12_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 1, "b12_c_b_h");
                                botoes[i][j + 2].setIcon(b13_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 2, "b13_c_b_h");
                                botoes[i][j + 3].setIcon(b14_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 3, "b14_c_b_h");
                                botoes[i][j + 4].setIcon(b15_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 4, "b15_c_b_h");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco2());
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    private class EventoBotaoGrid_AdicionaBarco2 extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 6) {
                                for (int k = 0; k < 4; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 4; k++) {
                                    botoes[i + k][j].setIcon(sea_tile_temp);
                                }
                            }
                        } else {
                            if (j <= 6) {
                                for (int k = 0; k < 4; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 4; k++) {
                                    botoes[i][j + k].setIcon(sea_tile_temp);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 6) {
                                for (int k = 0; k < 4; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 4; k++) {
                                    botoes[i + k][j].setIcon(sea_tile);
                                }
                            }
                        } else {
                            if (j <= 6) {
                                for (int k = 0; k < 4; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 4; k++) {
                                    botoes[i][j + k].setIcon(sea_tile);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 6) {
                                for (int k = 0; k < 4; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b21_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b21_c_b_v");
                                botoes[i + 1][j].setIcon(b22_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 1, j, "b22_c_b_v");
                                botoes[i + 2][j].setIcon(b23_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 2, j, "b23_c_b_v");
                                botoes[i + 3][j].setIcon(b24_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 3, j, "b24_c_b_v");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco3());
                            }
                        } else {
                            if (j <= 6) {
                                for (int k = 0; k < 4; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b21_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b21_c_b_h");
                                botoes[i][j + 1].setIcon(b22_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 1, "b22_c_b_h");
                                botoes[i][j + 2].setIcon(b23_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 2, "b23_c_b_h");
                                botoes[i][j + 3].setIcon(b24_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 3, "b24_c_b_h");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco3());
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    private class EventoBotaoGrid_AdicionaBarco3 extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i + k][j].setIcon(sea_tile_temp);
                                }
                            }
                        } else {
                            if (j <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i][j + k].setIcon(sea_tile_temp);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i + k][j].setIcon(sea_tile);
                                }
                            }
                        } else {
                            if (j <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i][j + k].setIcon(sea_tile);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b31_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b31_c_b_v");
                                botoes[i + 1][j].setIcon(b32_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 1, j, "b32_c_b_v");
                                botoes[i + 2][j].setIcon(b33_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 2, j, "b33_c_b_v");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco4());
                            }
                        } else {
                            if (j <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b31_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b31_c_b_h");
                                botoes[i][j + 1].setIcon(b32_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 1, "b32_c_b_h");
                                botoes[i][j + 2].setIcon(b33_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 2, "b33_c_b_h");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco4());
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    private class EventoBotaoGrid_AdicionaBarco4 extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i + k][j].setIcon(sea_tile_temp);
                                }
                            }
                        } else {
                            if (j <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i][j + k].setIcon(sea_tile_temp);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i + k][j].setIcon(sea_tile);
                                }
                            }
                        } else {
                            if (j <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 3; k++) {
                                    botoes[i][j + k].setIcon(sea_tile);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b41_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b41_c_b_v");
                                botoes[i + 1][j].setIcon(b42_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 1, j, "b42_c_b_v");
                                botoes[i + 2][j].setIcon(b43_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 2, j, "b43_c_b_v");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco5());
                            }
                        } else {
                            if (j <= 7) {
                                for (int k = 0; k < 3; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }

                                botoes[i][j].setIcon(b41_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b41_c_b_h");
                                botoes[i][j + 1].setIcon(b42_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 1, "b42_c_b_h");
                                botoes[i][j + 2].setIcon(b43_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 2, "b43_c_b_h");
                                atualizaMouseListener(new EventoBotaoGrid_AdicionaBarco5());
                            }
                        }
                        return;
                    }
                }
            }
        }
    }

    private class EventoBotaoGrid_AdicionaBarco5 extends MouseAdapter {

        @Override
        public void mouseEntered(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 8) {
                                for (int k = 0; k < 2; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile) {
                                        return;
                                    }
                                }

                                for (int k = 0; k < 2; k++) {
                                    botoes[i + k][j].setIcon(sea_tile_temp);
                                }
                            }
                        } else {
                            if (j <= 8) {
                                for (int k = 0; k < 2; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile) {
                                        return;
                                    }
                                }

                                for (int k = 0; k < 2; k++) {
                                    botoes[i][j + k].setIcon(sea_tile_temp);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 8) {
                                for (int k = 0; k < 2; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 2; k++) {
                                    botoes[i + k][j].setIcon(sea_tile);
                                }
                            }
                        } else {
                            if (j <= 8) {
                                for (int k = 0; k < 2; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                for (int k = 0; k < 2; k++) {
                                    botoes[i][j + k].setIcon(sea_tile);
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (e.getSource() == botoes[i][j]) {
                        if (vertical == true) {
                            if (i <= 8) {
                                for (int k = 0; k < 2; k++) {
                                    if (botoes[i + k][j].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                
                                botoes[i][j].setIcon(b51_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b51_c_b_v");
                                botoes[i + 1][j].setIcon(b52_c_b_v);
                                Jogador.getJogador().atualizaGridLogico(i + 1, j, "b52_c_b_v");

                                Main.mostraEmJogo();
                            }
                        } else {
                            if (j <= 8) {
                                for (int k = 0; k < 2; k++) {
                                    if (botoes[i][j + k].getIcon() != sea_tile_temp) {
                                        return;
                                    }
                                }
                                
                                botoes[i][j].setIcon(b51_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j, "b51_c_b_h");
                                botoes[i][j + 1].setIcon(b52_c_b_h);
                                Jogador.getJogador().atualizaGridLogico(i, j + 1, "b52_c_b_h");
                                
                                Thread ouvinte = new Thread(Conexao.getConexao().new Ouvinte());
                                ouvinte.start();
                                
                                Main.mostraEmJogo();
                            }
                        }
                        return;
                    }
                }
            }
        }
    }
}