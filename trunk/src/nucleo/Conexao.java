package nucleo;

import componentesUI.Chat;
import janelas.Main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    private static Conexao conexao;
    private static Thread aceita;
    private Socket soqueteCliente;
    private ServerSocket soqueteServidor;
    private InputStreamReader streamReader;
    private BufferedReader reader;
    private PrintWriter writer;
    private String entrada;
    private String saida;
    
    public static Conexao getConexao() {
        if(conexao == null)
            conexao = new Conexao();
        return conexao;
    }
    
    public static Thread getAceita() {
        return aceita;
    }
    
    private Conexao() {}
    
    public void conectarCliente(String _endereco, int _porta) throws IOException, UnknownHostException {
        soqueteCliente = new Socket(_endereco, _porta);
        inicializarFluxos();
    }
    
    public void inicializarServidor(int _porta) throws IOException {
        // precisamos de um try/catch/finally para pegar caso a porta já esteja sendo usada
        soqueteServidor = new ServerSocket(_porta);
        
        aceita = new Thread(new EventoAceitaConexao());
        aceita.start();
    }
    
    public void aceitaCliente() throws IOException {
        soqueteCliente = soqueteServidor.accept();
        inicializarFluxos();
    }
    
    public void inicializarFluxos() throws IOException {
        streamReader = new InputStreamReader(soqueteCliente.getInputStream());
        reader = new BufferedReader(streamReader);
        writer = new PrintWriter(soqueteCliente.getOutputStream());
    }
    
    public void enviarMensagem(String _msg) {
        System.out.println(_msg);
    }
    
    public class EventoAceitaConexao implements Runnable {
        boolean desconectado = true;

        @Override
        public void run() {
            while(desconectado) {
                try {
                    if((soqueteCliente = soqueteServidor.accept()) != null) {
                        desconectado = false;
                        inicializarFluxos();
                        Main.atualizaPainelConfigGrid();
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
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
            if(enderecoIP.equals("127.0.0.1"))
                JOptionPane.showMessageDialog(null, "Não há conexão de rede disponível.", "Alerta", JOptionPane.WARNING_MESSAGE);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return enderecoIP;
    }
}
