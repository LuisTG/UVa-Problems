/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;

public class MPIMaelstrom {
    static int p[][];
    public static void main(String[] args) throws Exception {
        int i, j, k, V, a, b;
        Scanner leer = new Scanner(System.in);
        while(leer.hasNext()){
        V = leer.nextInt();
        p=new int[V][V];
        int[][] AdjMat = new int[V][V];
        int cant;
        for (int l = 0; l < V; l++) {
            for (int m = 0; m < V; m++) {
                AdjMat[l][m] = 1000000000;
            }
            AdjMat[l][l] = 0;
        }
        String s;
        for (int l = 1; l < V; l++) {
            for (int m = 0; m < l; m++) {
                s=leer.next();
                if(!s.equals("x")){
                    cant=Integer.parseInt(s);
                    AdjMat[l][m]=cant;
                    AdjMat[m][l]=cant;
                }
            }
        }
        int mayor=-1;
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

            for (int m = 0; m < V; m++) {
                //System.out.print(AdjMat[l][m]+" ");
                if(AdjMat[0][m]>mayor) mayor=AdjMat[0][m];
            }
            //System.out.println("");
       
        System.out.println(mayor);
        }
    }
}
