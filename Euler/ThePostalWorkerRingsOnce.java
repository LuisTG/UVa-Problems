/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class ThePostalWorkerRingsOnce {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            String s;
            int map[][]=new int[26][26];
            int grado[]=new int[26];
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    map[i][j]=100;
                }
            }
            int in,fin;
            int tam;
            int suma=0;
            while(!(s=leer.next()).equals("deadend")){
                tam=s.length();
                in=s.charAt(0)-'a';
                fin=s.charAt(tam-1)-'a';
                grado[in]++;
                grado[fin]++;
                map[in][fin]=Math.min(tam,map[in][fin]);
                map[fin][in]=Math.min(tam, map[fin][in]);
                suma+=map[in][fin];
            }
            int extremos[]=new int[2];
            int ind=0;
            for (int i = 0; i < 26; i++) {
                if(grado[i]%2==1){
                    extremos[ind++]=i;
                }
            }
            if(ind==0){
                System.out.println(suma);
            }else{
                //System.out.println("ext "+extremos[0]+" "+extremos[1]);
                for (int k = 0; k < 26; k++) {
                    for (int i = 0; i < 26; i++) {
                        for (int j = 0; j < 26; j++) {
                            map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
                        }
                    }
                }
                suma+=map[extremos[0]][extremos[1]];
                System.out.println(suma);
            }
        }
    }
}
