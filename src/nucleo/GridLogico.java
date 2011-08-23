package nucleo;

public class GridLogico {
    private int grid[][];
    private boolean aberto[][];
    
    public void imprimeGridLogico() {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++)
                System.out.print(grid[i][j]);
            System.out.print("\n");
        }
    }

    public void colocaBarco(int x, int y, int tam, boolean vert) {
        for(int i = 0; i < tam; i++)
            if(vert)
                grid[x + i][y] = 10;
            else
                grid[x][y + i] = 10;
    }

    public int abreCampo(int x, int y) {
        if(!aberto[x][y])
            return grid[x][y];
        else
            return -1;
    }

    public void limpa() {
        for(int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++) {
                this.grid[i][j] = 0;
                this.aberto[i][j] = false;
            }
    }

    public GridLogico() {
        this.grid = new int[10][10];
        this.aberto = new boolean[10][10];
        this.limpa();
    }
}