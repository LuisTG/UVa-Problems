/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class NonStopTravel {
    static int p[][];
 public static void main(String[] args) throws Exception {
    int i, j, k, V, E, a, b, weight;
    Scanner leer = new Scanner(System.in);
    int casos=1;
    V=leer.nextInt();
    while(V!=0){
        int[][] AdjMat = new int[V][V];
        p=new int[V][V];
        int cant;
        for (int l = 0; l < V; l++) {
            for (int m = 0; m < V; m++) {
                AdjMat[l][m]=1000000000;
                p[l][m]=l;
            }
            AdjMat[l][l] = 0;
        }
        for (int l = 0; l < V; l++) {
            cant=leer.nextInt();
            for (int m = 0; m < cant; m++) {
                a=leer.nextInt()-1;
                b=leer.nextInt();
                AdjMat[l][a]=b;
            }
        }
        for (k = 0; k < V; k++) 
            for (i = 0; i < V; i++) 
                for (j = 0; j < V; j++)
                    if (AdjMat[i][k] + AdjMat[k][j] < AdjMat[i][j]) {
                        AdjMat[i][j] = AdjMat[i][k] + AdjMat[k][j];
                        p[i][j] = p[k][j];
                    }
        int or=leer.nextInt();
        int des=leer.nextInt();
        String s=printPath(or-1,des-1);
        System.out.println("Case "+casos+": Path = "+or+""+s+"; "+AdjMat[or-1][des-1]+" second delay");
        casos++;
        V=leer.nextInt();
    }

   }
    static String printPath(int i, int j) {
        String s="";
        if (i != j){ 
            s+=printPath(i, p[i][j])+" "+(j+1);
        }
        return s;
   }
}
