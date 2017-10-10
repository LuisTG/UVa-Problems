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
public class DegreesofSeparation {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int a,b;
        a=leer.nextInt();
        b=leer.nextInt();
        int cas=1;
        while(a!=0 && b!=0){
            int floyd[][]=new int[a][a];
            HashMap<String,Integer> h=new HashMap<>();
            int x,y;
            String d,e;
            int c=0;
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    floyd[i][j]=1000000000;
                }
                floyd[i][i]=0;
            }
            for (int i = 0; i < b; i++) {
                d=leer.next();
                e=leer.next();
                if(!h.containsKey(d)){
                    h.put(d, c++);
                }
                if(!h.containsKey(e)){
                    h.put(e, c++);
                }
                x=h.get(d);
                y=h.get(e);
                floyd[x][y]=1;
                floyd[y][x]=1;
            }
            for (int k = 0; k < a; k++) {
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        if(floyd[i][k]+floyd[k][j]<floyd[i][j]){
                            floyd[i][j]=floyd[i][k]+floyd[k][j];
                        }
                    }
                }
            }
            int mayor=0;
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    mayor=Math.max(mayor, floyd[i][j]);
                }
            }
            if(mayor==1000000000){
                System.out.println("Network "+cas+": DISCONNECTED");
            }else{
                System.out.println("Network "+cas+": "+mayor);
            }
            System.out.println("");
            cas++;
            a=leer.nextInt();
            b=leer.nextInt();
        }
    }
}
