/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class NumberingPaths {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int a;
        int cas=0;
        while(leer.hasNext()){
            a=leer.nextInt();
            int floyd[][]=new int[30][30];
            int mayor=-1;
            int x,y;
            for (int i = 0; i < a; i++) {
                x=leer.nextInt();
                y=leer.nextInt();
                mayor=Math.max(mayor, Math.max(x, y));
                floyd[x][y]=1;
            }
            mayor++;
            for (int k = 0; k < mayor; k++) {
                for (int i = 0; i < mayor; i++) {
                    for (int j = 0; j < mayor; j++) {
                        if(floyd[i][k]>0 && floyd[k][j]>0 ){
                            if(floyd[i][k]>1 || floyd[k][j]>1) floyd[i][j]+=Math.max(floyd[i][k],floyd[k][j]);
                            else
                            floyd[i][j]+=1;
                        }
                    }
                }
            }
            ArrayList<Integer> ad=new ArrayList<>();
            for (int i = 0; i < mayor; i++) {
                if(floyd[i][i]>0){
                    for (int j = 0; j < mayor; j++) {
                        if(floyd[i][j]>0) floyd[i][j]=-1;
                    }
                }else{
                    ad.add(i);
                }
            }
            for (int i = 0; i < ad.size(); i++) {
                int k=ad.get(i);
                for (int j = 0; j < mayor; j++) {
                    if(floyd[k][j]>0 && floyd[j][j]<0){
                        for (int l = 0; l < mayor; l++) {
                            if(floyd[j][l]<0)
                                floyd[k][l]=-1;
                        }
                    }
                }
            }
          /*  for (int i = 0; i < mayor; i++) {
                for (int j = 0; j < mayor; j++) {
                    System.out.print(floyd[i][j]+" ");
                }
                System.out.println("");
            }*/
            System.out.println("matrix for city "+cas);
            cas++;
            for (int i = 0; i < mayor; i++) {
                for (int j = 0; j < mayor; j++) {
                    if(j==0) System.out.print(floyd[i][j]);
                    else System.out.print(" "+floyd[i][j]);
                }
                System.out.println("");
            }
        }
    }
}
