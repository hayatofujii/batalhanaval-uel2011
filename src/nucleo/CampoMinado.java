/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nucleo;

import java.util.Scanner;

/**
 *
 * @author hayato
 */
public class CampoMinado {
    
    private Jogador player1, player2;
    
    public CampoMinado()
    {
       String nome;
       Scanner teclado = new Scanner(System.in);

       nome = teclado.nextLine();
       player1 = new Jogador(nome);
       
       nome = teclado.nextLine();
       player2 = new Jogador(nome);
       
       teclado.close();  
    }
    
    public static void main(String[] args) {
        CampoMinado game;
        game = new CampoMinado();
    }
}
