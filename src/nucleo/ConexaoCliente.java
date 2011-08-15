package nucleo;

import java.net.Socket;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;

public class ConexaoCliente {
    private static ConexaoCliente conexao;
    protected Socket soqueteCliente;
    
    protected InputStreamReader streamReader;
    protected BufferedReader reader;
    protected PrintWriter writer;
    
    protected String entrada;
    protected String saida;
    
    public static ConexaoCliente getConexao() {
        if(conexao == null)
            conexao = new ConexaoCliente();
        return conexao;
    }
    
    protected ConexaoCliente() {}
    
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
    
     public void inicializarFluxos() {
        try {
            streamReader = new InputStreamReader(soqueteCliente.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        reader = new BufferedReader(streamReader);
        
        try {
            writer = new PrintWriter(soqueteCliente.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void enviarMensagem(String _msg) {
        System.out.println(_msg);
    }

    public String detectarIP() {
        String enderecoIP = null;
        try {        
            enderecoIP = InetAddress.getLocalHost().getHostAddress();  
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        if (enderecoIP.equals("127.0.0.1"))
             JOptionPane.showMessageDialog(null, "Não há conexão de rede disponível.", "Alerta", JOptionPane.WARNING_MESSAGE);
        
        return enderecoIP;
    }
}
