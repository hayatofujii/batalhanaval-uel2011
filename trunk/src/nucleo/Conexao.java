package nucleo;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Singleton de gerenciador de conexão.
 * @author hayato
 */
public class Conexao {

    private static Conexao conexao;
    private Socket soqueteCliente;
    private ServerSocket soqueteServer;
    
    private int portaConexao;

    private Conexao() {
        // whatever you want to do
    }

    public static Conexao getConexao() {
        if (conexao == null) {
            conexao = new Conexao();
        }

        return conexao;
    }
}
