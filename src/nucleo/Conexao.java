package nucleo;

import componentesUI.Chat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Conexao {
    private static Conexao conexao;
    private Socket soqueteCliente;
    private ServerSocket soqueteServidor;
    private InputStreamReader streamReader;
    private BufferedReader reader;
    private PrintWriter writer;
    private String entrada;
    private String saida;
    
    public static Conexao getConexao() {
        if(conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }
    
    private Conexao() {}
    
    public void inicializarCliente(String _endereco, int _porta) throws IOException {
        soqueteCliente = new Socket(_endereco, _porta);
        streamReader = new InputStreamReader(soqueteCliente.getInputStream());
        reader = new BufferedReader(streamReader);
        writer = new PrintWriter(soqueteCliente.getOutputStream());
    }
    
    public void inicializarServidor(int _porta) throws IOException {
        soqueteServidor = new ServerSocket(_porta);
        soqueteCliente = soqueteServidor.accept();
        streamReader = new InputStreamReader(soqueteCliente.getInputStream());
        reader = new BufferedReader(streamReader);
        writer = new PrintWriter(soqueteCliente.getOutputStream());
    }
    
    public void enviarMensagem(String _msg) {
        System.out.println(_msg);
    }
    
    public class EventoRecebeMensagem implements Runnable {
        @Override
        public void run() {
            try {
                while((entrada = reader.readLine()) != null) {
                    Chat.getChat().colocaMensagemAreaChat(entrada);
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public String detectarIP() {
        String enderecoIP = null;
        try {        
            enderecoIP = InetAddress.getLocalHost().getHostAddress();
            if(enderecoIP.equals("127.0.0.1")) {
                JOptionPane.showMessageDialog(null, "Não há conexão de rede disponível.", "Alerta", JOptionPane.WARNING_MESSAGE);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return enderecoIP;
    }
}