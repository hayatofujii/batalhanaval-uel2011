package nucleo;

public class Grid {
    private int grid[][];
    private boolean aberto[][];
    private boolean qtdeBarcos[];

    private void colocaBarco(int x, int y, int tipo, boolean vert) {
        int tam;
        
        if(tipo < 2)
            tam = tipo + 2;
        else
            tam = tipo + 1;
                
        for(byte i = 0; i < tam; i++)
            if(vert)
                grid[x][y + i] = 10 * tipo + i;
            else
                grid[x + i][y] = 10 * tipo + i;
    }

    private boolean verificaEspaco(int x, int y, int tipo, boolean vert) {
        int tam;
        
        if(tipo < 2)
            tam = tipo + 2;
        else
            tam = tipo + 1;
        
        for(byte i = 0; i < tam; i++) {
            if(vert)
                if(x < 0 || x >= 10 || y + i < 0 || y + i >= 10 || grid[x][y + i] != 0)
                    return false;
            else if(x + i < 0 || x + i >= 10 || y < 0 || y >= 10 || grid[x + i][y] != 0)
                return false;
        }
        return true;
    }

    public int abreCampo(int x, int y) {
        if(!aberto[x][y])
            return grid[x][y];
        else
            return -1;
    }

    public void limpa() {
        byte i, j;

        for(i = 0; i < 10; i++)
            for (j = 0; j < 10; j++) {
                this.grid[i][j] = 0;
                this.aberto[i][j] = false;
            }

        for(i = 0; i < 5; i++)
            this.qtdeBarcos[i] = false;
    }

    public Grid() {
        this.grid = new int[10][10];
        this.aberto = new boolean[10][10];
        this.limpa();
    }
}