/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Redezvous {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int a,b;
        a=leer.nextInt();
        b=leer.nextInt();
        int casos=1;
        while(a!=0){
            HashMap< Integer, String> hm=new HashMap<>();
            for (int i = 0; i < a; i++) {
                hm.put( i,leer.next());
            }
            int AdjMat[][]=new int[a][a];
            for (int l = 0; l < a; l++) {
                for (int m = 0; m < a; m++) {
                    AdjMat[l][m] = 1000000000;
                }
                AdjMat[l][l] = 0;
            }
            int x,y,z;
            for (int i = 0; i < b; i++) {
                x=leer.nextInt();
                y=leer.nextInt();
                z=leer.nextInt();
                AdjMat[x-1][y-1]=z;
                AdjMat[y-1][x-1]=z;
            }
            for (int k = 0; k < a; k++) {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        if (AdjMat[i][k] + AdjMat[k][j] < AdjMat[i][j]) {
                            AdjMat[i][j] = AdjMat[i][k] + AdjMat[k][j];    
                        }
                    }
                }
            }
            int cont=100000000, num=0;
            int suma=0;
            for (int i = 0; i < a; i++) {
                suma=0;
                for (int j = 0; j < a; j++) {
                    suma+=AdjMat[i][j];
                }
                if(suma<cont){
                    cont=suma;
                    num = i;
                }
            }
            System.out.println("Case #"+casos+" : "+hm.get(num));
            casos++;
            a = leer.nextInt();
            b = leer.nextInt();
        }
    }
}
