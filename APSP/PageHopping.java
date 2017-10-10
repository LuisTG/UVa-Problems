/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;
import java.util.TreeSet;

public class PageHopping {
        public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int a,b;
        a=leer.nextInt();
        b=leer.nextInt();
        int casos=1;
        while(a!=0 && b!=0){
        int x,y,V=100;
        x=a;
        y=b;
        int[][] AdjMat = new int[V][V];
        for (int l = 0; l < V; l++) {
            for (int m = 0; m < V; m++) {
                AdjMat[l][m] = 1000000000;
            }
            AdjMat[l][l] = 0;
        }
        TreeSet<Integer> tr=new TreeSet();
        while(x!=0 && b!=0){
            tr.add(x);
            tr.add(y);
            AdjMat[x-1][y-1]=1;
            x=leer.nextInt();
            y=leer.nextInt();
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (AdjMat[i][k] + AdjMat[k][j] < AdjMat[i][j]) {
                        AdjMat[i][j] = AdjMat[i][k] + AdjMat[k][j];
                        //if(AdjMat[i][j]>mayor) mayor=AdjMat[i][j];
                    }
                }
            }
        }
        int cont=0;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(AdjMat[i][j]!=1000000000){
                        cont+=AdjMat[i][j];
                    }
                }
            }
            //System.out.println(cont+" "+tr.size());
            System.out.printf("Case %d: average length between pages = %.3f clicks\n",casos,((cont*1.0)/(tr.size()*(tr.size()-1))));
        casos++;
            a=leer.nextInt();
         b=leer.nextInt();
            
        }
    }
}
