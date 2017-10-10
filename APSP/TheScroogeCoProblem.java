/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.HashMap;
import java.util.Scanner;

public class TheScroogeCoProblem {
    static int p[][];
    static int floyd[][];
    static int copia[][];
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int tam=leer.nextInt();
            floyd=new int[tam][tam];
            copia=new int[tam][tam];
            p=new int[tam][tam];
            HashMap<Integer, String> hm=new HashMap<>();
            HashMap<String, Integer> hm2=new HashMap<>();
            String x;
            for (int i = 0; i < tam; i++) {
                x=leer.next();
                hm.put(i, x);
                hm2.put(x, i);
            }
            int aux;
            for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    aux=leer.nextInt();
                    if(aux==-1){
                        floyd[i][j]=100000000;
                        copia[i][j]=100000000;
                    }else{
                        floyd[i][j]=aux;
                        copia[i][j]=aux;
                    }
                    p[i][j]=i;
                }
            }
            for (int k = 0; k < tam; k++) {
                for (int i = 0; i < tam; i++) {
                    for (int j = 0; j < tam; j++) {
                        if(floyd[i][k]+floyd[k][j]<floyd[i][j]){
                            floyd[i][j]=floyd[i][k]+floyd[k][j];
                            p[i][j]=p[k][j];
                        }
                    }
                }
            }
           /* for (int i = 0; i < tam; i++) {
                for (int j = 0; j < tam; j++) {
                    System.out.print(p[i][j]+" ");
                }
                System.out.println("");
            }*/
            int a=leer.nextInt();
            String nombre,inicio,fin,p;
            int in,fi;
            for (int i = 0; i < a; i++) {
                nombre=leer.next();
                inicio=leer.next();
                fin=leer.next();
                in=hm2.get(inicio);
                fi=hm2.get(fin);
                if(floyd[in][fi]>=100000000){
                    System.out.println("Sorry Mr "+nombre+" you can not go from "+inicio+" to "+fin);
                }else{
                    //System.out.println("este es fi"+fi);
                    p=in+printPath(in,fi)+" "+fi;
                    System.out.println("Mr "+nombre+" to go from "+inicio+" to "+fin+", you will receive "+floyd[in][fi]+" euros");
                    if(inicio.equals(fin) && copia[hm2.get(inicio)][hm2.get(fin)]==floyd[hm2.get(inicio)][hm2.get(fin)]) p=hm2.get(inicio)+" "+hm2.get(fin);
                    String pa[]=p.split(" ");
                    System.out.print("Path:");
                    for (int j = 0; j < pa.length-1; j++) {
                        System.out.print(hm.get(Integer.parseInt(pa[j]))+" ");
                    }
                    System.out.println(hm.get(Integer.parseInt(pa[pa.length-1])));
                }
            }
        }
    }
        static String printPath(int i, int j) {
        String s="";
        if (i != p[i][j]){ 
            s+=printPath(i, p[i][j])+" "+(p[i][j]);
        }
        
        return s;
   }
}
