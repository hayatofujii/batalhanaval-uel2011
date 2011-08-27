package nucleo;

import componentesUI.Chat;
import janelas.EmJogo;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConexaoCliente {
    private static ConexaoCliente conexao;
    protected Socket soqueteCliente;
    
    protected InputStreamReader streamReader;
    protected BufferedReader reader;
    protected PrintWriter writer;
    
    private String mensagem;
    
    protected int testeInt = 0;
        
    public static ConexaoCliente getConexao() {
        if (conexao == null)
            conexao = new ConexaoCliente();
        return conexao;
    }
    
    public class Ouvinte implements Runnable {
        
        @Override
        public void run() {
            try {
                while ((ConexaoCliente.getConexao().mensagem = ConexaoCliente.getConexao().reader.readLine()) != null) {
                    if (ConexaoCliente.getConexao().mensagem.charAt(0) == 'c') {
                        String temp = ConexaoCliente.getConexao().mensagem.substring(2);
                        Chat.getChat().colocaMensagemAreaChat(temp);
                    }
                    if (ConexaoCliente.getConexao().mensagem.charAt(0) == 'j') {
                        int x = Integer.parseInt(Character.toString(ConexaoCliente.getConexao().mensagem.charAt(2)));
                        int y = Integer.parseInt(Character.toString(ConexaoCliente.getConexao().mensagem.charAt(4)));
                        String resultado = Jogador.getJogador().getPontosLogico(x, y);
                        
                        int pontos = 0;
                        if (!resultado.equals("sea_tile")) {
                            pontos = 10;
                        }
                        EmJogo.getMini().setBotao(x, y, resultado);
                        ConexaoCliente.getConexao().enviarPontuacao(pontos, resultado, x, y);
                    }
                    if (ConexaoCliente.getConexao().mensagem.charAt(0) == 'p') {
                        String vetor[] = ConexaoCliente.getConexao().mensagem.split(":");
                        int pontos = Integer.parseInt(vetor[1]);
                        String icone = vetor[2];
                        int x = Integer.parseInt(vetor[3]);
                        int y = Integer.parseInt(vetor[4]);
                        
                        Jogador.getJogador().setPontos(Jogador.getJogador().getPontos() + pontos);
                        EmJogo.getGrid().setBotao(x, y, icone);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public void conectarCliente(String _endereco, int _porta) {
        try {
            soqueteCliente = new Socket(_endereco, _porta);
        } catch(UnknownHostException ex) {
            ex.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        
        inicializarFluxos();
    }

    public void inicializarFluxos() {
        try {
            streamReader = new InputStreamReader(ConexaoCliente.getConexao().soqueteCliente.getInputStream());
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        reader = new BufferedReader(streamReader);
        
        try {
            writer = new PrintWriter(ConexaoCliente.getConexao().soqueteCliente.getOutputStream());
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void enviarMensagemChat(String _msg) {
        System.out.println("c:" + _msg + " aaa:" + testeInt);
        
        if (soqueteCliente == null)
            System.out.println("soqueteCliente nulo!");
        
        if (writer == null || reader == null) 
        {
             System.out.println("Writer nulo, reinicializando.");
             inicializarFluxos();
        }
        writer.print("c:" + _msg);
        writer.flush();
    }
    
    public void enviarCoordenadas(int x, int y) {
        
        System.out.println("j:" + x + ":" + y + " aaa:" + testeInt);
        
        if (soqueteCliente == null)
            System.out.println("ALERTA SOQUETECLIENTE NULO");
        
        while (writer == null || reader == null) 
        {
             System.out.println("Writer nulo, reinicializando.");
             inicializarFluxos();
        }
        
        
        
        writer.print("j:" + x + ":" + y);
        writer.flush();
    }
    
    public void enviarPontuacao(int pontos, String icone, int x, int y) {
        System.out.println("p:" + pontos + ":" + icone + ":" + x + ":" + y);
        writer.print("p:" + pontos + ":" + icone + ":" + x + ":" + y);
        writer.flush();
    }

    public String detectarIP() {
        String enderecoIP = null;
        try {
            enderecoIP = InetAddress.getLocalHost().getHostAddress();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        if(enderecoIP.equals("127.0.0.1")) {
             JOptionPane.showMessageDialog(null, "Não há conexão de rede disponível.", "Alerta", JOptionPane.WARNING_MESSAGE);
        }
        
        return enderecoIP;
    }
}