package nucleo;

public class Jogador {
    private String nome;
    private byte pontos;
    private Grid campo;

    public Jogador(String _nome) {
        this.nome = _nome;
        this.pontos = 0;
        this.campo = new Grid();
    }
    
    public int pegaCampo(int posX, int posY) {
        return campo.abreCampo(posX, posY);
    }
    
    public void refazCampo() {
        this.campo.limpa();
    }

    public String getNome() {
        return nome;
    }

    public byte getPontos() {
        return pontos;
    }
    
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
}