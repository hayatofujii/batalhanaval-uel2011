package nucleo;

public class GridLogico {
    private String grid[][];
    private boolean aberto[][];
    
    public void imprimeGridLogico() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++)
                System.out.print(grid[i][j]);
            System.out.print("\n");
        }
    }

    public void colocaBarco(int x, int y, String icone) {
        grid[x][y] = icone;
    }

    public String abreCampo(int x, int y) {
        String resultado = null;
        
        if(!aberto[x][y]) {
            aberto[x][y] = true;
            resultado = grid[x][y];
        }
        
        return resultado;
    }

    public void limpa() {
        for(int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = "sea_tile";
                this.aberto[i][j] = false;
            }
    }

    public GridLogico() {
        this.grid = new String[10][10];
        this.aberto = new boolean[10][10];
        this.limpa();
    }
}