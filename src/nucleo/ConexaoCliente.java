package nucleo;

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
        
    public static ConexaoCliente getConexao() {
        if(conexao == null)
            conexao = new ConexaoCliente();
        return conexao;
    }
    
    protected ConexaoCliente() {}
    
    public class Ouvinte implements Runnable {
        public Ouvinte() {
            // fazer
        }
        
        @Override
        public void run() {
            // fazer
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
        
        Thread ouvinte =  new Thread(new Ouvinte());
        ouvinte.start();
    }

    public void inicializarFluxos() {
        try {
            streamReader = new InputStreamReader(soqueteCliente.getInputStream());
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        reader = new BufferedReader(streamReader);
        
        try {
            writer = new PrintWriter(soqueteCliente.getOutputStream());
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void enviarMensagemChat(String _msg) {
        System.out.println("0:" + _msg);
        writer.print("0:" + _msg);
        writer.flush();
    }
    
    public void enviarCoordenadas(int x, int y) {
        System.out.println("1:" + x + ":" + y);
        writer.print("1:" + x + ":" + y);
        writer.flush();
    }
    
    public void enviarPontuacao(int pontos, int tipoBarco, int secao, boolean vert) {
        System.out.println("2:" + pontos + ":" + tipoBarco + ":" + secao + ":" + vert);
        writer.print("2:" + pontos + ":" + tipoBarco + ":" + secao + ":" + vert);
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