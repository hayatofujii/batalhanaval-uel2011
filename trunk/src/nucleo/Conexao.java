package nucleo;

import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexao {
    private static Conexao conexao;
    private Socket soqueteCliente;
    private ServerSocket soqueteServer;
    private int portaConexao;
    private String entrada;
    private String saida;

    private Conexao() {
        // whatever you want to do
    }

    public static Conexao getConexao() {
        if(conexao == null) {
            conexao = new Conexao();
        }
        return conexao;
    }
    
    public class EventoRecebeMensagem implements Runnable {
        private BufferedReader reader;
        
        public EventoRecebeMensagem() {
            //reader = 
        }
        
        public void run() {
            //while(entrada = )
        }
    }
}