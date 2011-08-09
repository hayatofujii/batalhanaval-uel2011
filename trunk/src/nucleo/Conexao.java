package nucleo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao {
    private static Conexao conexao;
    private Socket soqueteCliente;
    private ServerSocket soqueteServer;
    private int portaConexao;
    private InputStreamReader streamReader;
    private BufferedReader reader;
    private String entrada;
    private String saida;

    private Conexao() {/*
        try {
            streamReader = new InputStreamReader(soqueteCliente.getInputStream());
            reader = new BufferedReader(streamReader);
        } catch(IOException ex) {
            ex.printStackTrace();
        }*/
    }

    public static Conexao getConexao() {
        if(conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }
    
    public static void enviarMensagem(String _msg) {
        //System.out.println(_msg);
    }
    
    public class EventoRecebeMensagem implements Runnable {
        public void run() {
            try {
                while((entrada = reader.readLine()) != null) {
                    // append na área de chat
                }
            } catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}