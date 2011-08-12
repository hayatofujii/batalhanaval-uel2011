package nucleo;

public class Jogador {
    private static Jogador jogador;
    private String nome;
    private int pontos;
    
    public static Jogador getJogador() {
        if(jogador == null)
            jogador = new Jogador();
        return jogador;
    }

    private Jogador() {
        pontos = 0;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public int getPontos() {
        return pontos;
    }
    
    /*
    public void fazJogada(Jogador oponente, int posX, int posY) {
        int rodadaSeguida = 0;
        boolean sair = false;
        
        do {
            if(oponente.pegaCampo(posX, posY) > 0) {
                rodadaSeguida++;
                pontos += rodadaSeguida * 10;
            }
            else
                sair = true;
        } while(!sair);
    }
    */
}