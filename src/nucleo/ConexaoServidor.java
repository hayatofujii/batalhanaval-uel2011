package nucleo;

import janelas.Main;

import java.net.ServerSocket;
import java.io.IOException;

public class ConexaoServidor extends ConexaoCliente {
    private ServerSocket soqueteServidor;

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
            
            // precisamos notificar a interface gráfica que a conexão foi aberta
            Main.mostraConfigConexao();
        }
    }
}
