/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;

public class RISK {
        public static void main(String[] args) throws Exception {
        int i, j, k, V, a, b;
        Scanner leer = new Scanner(System.in);
        int casos=1;
        while(leer.hasNext()){
        V = 20;
        int[][] AdjMat = new int[V][V];
        int cant;
        for (int l = 0; l < V; l++) {
            for (int m = 0; m < V; m++) {
                AdjMat[l][m] = 1000000000;
            }
            AdjMat[l][l] = 1;
        }
        int aux;
        for (int l = 0; l < V-1; l++) {
            cant=leer.nextInt();
            for (int m = 0; m < cant; m++) {
                aux=leer.nextInt()-1;
                AdjMat[l][aux]=1;
                AdjMat[aux][l]=1;
            }
        }
        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (AdjMat[i][k] + AdjMat[k][j] < AdjMat[i][j]) {
                        AdjMat[i][j] = AdjMat[i][k] + AdjMat[k][j];
                        //if(AdjMat[i][j]>mayor) mayor=AdjMat[i][j];
                    }
                }
            }
        }
        int q=leer.nextInt();
            System.out.println("Test Set #"+casos++);
            for (int l = 0; l < q; l++) {
                a=leer.nextInt();
                b=leer.nextInt();
                if(a<10)
                    System.out.print(" "+a);
                else
                    System.out.print(""+a);
                
                if(b<10) System.out.print(" to  "+b+":");
                else System.out.print(" to "+b+":");
                if(AdjMat[a-1][b-1]<10)
                    System.out.println(" "+AdjMat[a-1][b-1]);
                else System.out.println(" "+AdjMat[a-1][b-1]);
            }
            System.out.println("");    
        }
    }
}
