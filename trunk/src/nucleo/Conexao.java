package nucleo;

import componentesUI.Chat;
import janelas.EmJogo;
import janelas.Main;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Conexao {

    private static Conexao conexao;
    private Socket soqueteCliente;
    private ServerSocket soqueteServidor;
    private InputStreamReader streamReader;
    private BufferedReader reader;
    private PrintWriter writer;
    private boolean executando;

    public static Conexao getConexao() {
        if (conexao == null) {
            conexao = new Conexao();
        }

        return conexao;
    }

    public void inicializarFluxos() {
        try {
            streamReader = new InputStreamReader(soqueteCliente.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(soqueteCliente.getOutputStream());
            executando = true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void paraExecucao() {
        executando = false;
    }

    public class Ouvinte implements Runnable {

        private String mensagem;

        @Override
        public void run() {
            while (executando) {
                try {
                    while ((mensagem = reader.readLine()) != null) {
                        System.out.println("Recebi: " + mensagem);
                        if (mensagem.charAt(0) == 'c') {
                            String temp = mensagem.substring(2);
                            Chat.getChat().colocaMensagemAreaChat(temp);
                        }
                        if (mensagem.charAt(0) == 'j') {
                            int x = Integer.parseInt(Character.toString(mensagem.charAt(2)));
                            int y = Integer.parseInt(Character.toString(mensagem.charAt(4)));
                            String resultado = Jogador.getJogador().getPontosLogico(x, y);
                            String aux;

                            int pontos = 0;
                            if (!resultado.equals("sea-tile")) {
                                pontos = 10;
                                resultado = resultado.replace('c', 'h');
                            } else {
                                resultado = "sea-tile-hit";
                            }

                            enviaPontuacao(pontos, resultado, x, y);

                            if (resultado.charAt(0) != 's') {
                                aux = resultado.substring(1);
                                resultado = "b" + aux.replace('b', 's');
                            }

                            EmJogo.getMini().setBotao(x, y, resultado);
                            if (pontos == 0) {
                                Jogador.getJogador().setTurno(true);
                                Chat.getChat().colocaMensagemAreaChat("Sistema: Seu turno!");
                            }
                        }
                        if (mensagem.charAt(0) == 'p') {
                            String vetor[] = mensagem.split(":");
                            int pontos = Integer.parseInt(vetor[1]);
                            String icone = vetor[2];
                            int x = Integer.parseInt(vetor[3]);
                            int y = Integer.parseInt(vetor[4]);

                            if (pontos == 0) {
                                Jogador.getJogador().setTurno(false);
                                Jogador.getJogador().zeraContadorConsecutivo();
                                Chat.getChat().colocaMensagemAreaChat("Sistema: Turno do oponente!");
                            } else {
                                Jogador.getJogador().incrementaContador();
                                Jogador.getJogador().incrementaContadorConsecutivo();
                                Jogador.getJogador().setPontos(Jogador.getJogador().getPontos() + (pontos * Jogador.getJogador().getContadorConsecutivo()));
                                EmJogo.setLabelPontos();
                            }

                            if (Jogador.getJogador().getContador() == 17) {
                                enviaAvisoReinicioJogo();
                                int resposta = JOptionPane.showConfirmDialog(Main.getJanela(), "Parabéns! Você é o vencedor!\nDeseja continuar jogando?", "Fim de jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                                if (resposta == 0) {
                                    Jogador.getJogador().limpaGridLogico();
                                    Jogador.getJogador().setPontos(0);
                                    Jogador.getJogador().zeraContador();
                                    Jogador.getJogador().zeraContadorConsecutivo();
                                    Chat.getChat().limpaAreaChat();
                                    Main.reiniciaJogo();
                                }
                                if (resposta == 1) {
                                    enviaAvisoDesistencia();
                                    fechaFluxos();
                                    System.exit(0);
                                }
                                paraExecucao();
                                Thread.currentThread().interrupt();
                            }

                            EmJogo.getGrid().setBotao(x, y, icone);
                        }
                        if (mensagem.charAt(0) == 'r') {
                            int resposta = JOptionPane.showConfirmDialog(Main.getJanela(), "Que pena! Você perdeu!\nDeseja continuar jogando?", "Fim de jogo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                            if (resposta == 0) {
                                Jogador.getJogador().limpaGridLogico();
                                Jogador.getJogador().setPontos(0);
                                Jogador.getJogador().zeraContador();
                                Jogador.getJogador().zeraContadorConsecutivo();
                                Chat.getChat().limpaAreaChat();
                                Main.reiniciaJogo();
                            }
                            if (resposta == 1) {
                                enviaAvisoDesistencia();
                                fechaFluxos();
                                System.exit(0);
                            }
                            paraExecucao();
                            Thread.currentThread().interrupt();
                        }
                        if (mensagem.charAt(0) == 'd') {
                            JOptionPane.showMessageDialog(Main.getJanela(), "O outro jogador desistiu!", "Fim de jogo", JOptionPane.INFORMATION_MESSAGE);
                            if (Jogador.getJogador().getServidor()) {
                                soqueteServidor.close();
                            }
                            Jogador.getJogador().limpaGridLogico();
                            Jogador.getJogador().setPontos(0);
                            Jogador.getJogador().zeraContador();
                            Jogador.getJogador().zeraContadorConsecutivo();
                            Chat.getChat().limpaAreaChat();
                            Main.voltaAoInicio();
                            paraExecucao();
                            Thread.currentThread().interrupt();
                        }
                        if (mensagem.charAt(0) == 'i') {
                            Jogador.getJogador().setTurno(true);
                            Chat.getChat().colocaMensagemAreaChat("Sistema: Seu turno!");
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void conectarCliente(String _endereco, int _porta) {
        try {
            soqueteCliente = new Socket(_endereco, _porta);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        inicializarFluxos();
    }

    public void inicializarServidor(int _porta) {
        try {
            soqueteServidor = new ServerSocket(_porta);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Thread aceita = new Thread(new EventoAceitaConexao());
        aceita.start();
    }

    public class EventoAceitaConexao implements Runnable {

        @Override
        public void run() {
            try {
                soqueteCliente = soqueteServidor.accept();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            inicializarFluxos();

            Main.mostraConfigGrid();
            Thread.currentThread().interrupt();
        }
    }

    public void enviaMensagemChat(String _msg) {
        writer.println("c:" + _msg);
        writer.flush();
    }

    public void enviaCoordenadas(int x, int y) {
        writer.println("j:" + x + ":" + y);
        writer.flush();
    }

    public void enviaPontuacao(int pontos, String icone, int x, int y) {
        writer.println("p:" + pontos + ":" + icone + ":" + x + ":" + y);
        writer.flush();
    }

    public void enviaAvisoReinicioJogo() {
        writer.println("r");
        writer.flush();
    }

    public void enviaAvisoDesistencia() {
        writer.println("d");
        writer.flush();
    }

    public void enviaSinalInicio() {
        writer.println("i");
        writer.flush();
    }

    public String detectarIP() {
        String enderecoIP = null;
        try {
            enderecoIP = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (enderecoIP.equals("127.0.0.1")) {
            JOptionPane.showMessageDialog(Main.getJanela(), "Não há conexão de rede disponível.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }

        return enderecoIP;
    }

    public void fechaFluxos() throws IOException {
        writer.close();
        reader.close();
        soqueteCliente.close();
        if (Jogador.getJogador().getServidor()) {
            soqueteServidor.close();
        }
    }

    public boolean writerInstanciado() {
        if (writer == null) {
            return false;
        } else {
            return true;
        }
    }
}