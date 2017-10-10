/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;


public class Arbitrage {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int tam=leer.nextInt();
            double floyd[][][]=new double[tam][tam][tam];
            int pa[][][]=new int [tam][tam][tam];
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    if(i!=j){
                        floyd[0][i][j]=leer.nextDouble();
                    }else{
                        floyd[0][i][j]=1;
                    }
                    pa[0][i][j]=i;
                }
            }
            for (int s = 1; s < tam; s++) {
                for (int k = 0; k < tam; k++) {
                    for (int i = 0; i < tam; i++) {
                        for (int j = 0; j < tam; j++) {
                            double aux= floyd[s-1][i][k]*floyd[0][k][j];
                            if(aux>floyd[s][i][j]){
                                floyd[s][i][j]=aux;
                                pa[s][i][j]=k;
                            }
                        }
                    }
                }
            }
            
            int s,p=-1;
            for ( s = 1; s < tam; s++) {
                for (int i = 0; i < tam; i++) {
                    if(floyd[s][i][i]>1.01){
                        p=i;
                        break;
                    }
                }
                if(p!=-1) break;
            }
            if(p==-1){
                System.out.println("no arbitrage sequence exists");
            }else{
                int reversa[]=new int[tam+1];
                int ind=0;
                int a=p;
                reversa[ind++]=p;
                for (int i = s; i >-1; i--) {
                    a=pa[i][p][a];
                    reversa[ind++]=a;
                }
                
                for (int i = ind-1; i >0; i--) {
                    System.out.print((reversa[i]+1)+" ");
                }
                System.out.println((reversa[0]+1));
            }
        }
    }
}
