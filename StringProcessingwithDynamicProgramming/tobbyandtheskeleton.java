/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringProcessingwithDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class tobbyandtheskeleton {
    
    static class dato{
        int nodo;
        int ai;
        int bi;

        public dato(int nodo, int ai, int bi) {
            this.nodo = nodo;
            this.ai = ai;
            this.bi = bi;
        }
    }
    
    static class rango{
        int ai;
        int bi;

        public rango(int ai, int bi) {
            this.ai = ai;
            this.bi = bi;
        }
        
    }
    
    static ArrayList<ArrayList<dato>> ar;
    static String x;
    static boolean vis[];
    static int r1;
    static int r2;
    static void path(int a, int b, String c, int r, int nodoi, int nodoj){
        if(a==b){ r1=nodoi; r2=nodoj; x=c+a; return;}
        vis[a]=true;
        //int x=0;
        for (int i = 0; i <ar.get(a).size() ; i++) {
            if(!vis[ar.get(a).get(i).nodo]){
                if(ar.get(a).get(i).bi>r)
                    path(ar.get(a).get(i).nodo,b,c+a,ar.get(a).get(i).bi,a,ar.get(a).get(i).nodo);
                else
                    path(ar.get(a).get(i).nodo,b,c+a,r,nodoi,nodoj);
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        ar=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ar.add(new ArrayList<dato>());
        }
        int n1,n2,a,b;
        HashMap<String, dato> hm=new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            n1=leer.nextInt()-1;
            n2=leer.nextInt()-1;
            a=leer.nextInt();
            b=leer.nextInt();
            ar.get(n1).add(new dato(n2,a,b));
            ar.get(n2).add(new dato(n1,a,b));
            hm.put((n1)+" "+(n2),new dato(n2,a,b));
            hm.put((n2)+" "+(n1),new dato(n1,a,b));
        }
        int cons=leer.nextInt();
        int in,fin;
        while(cons-->0){
             vis=new boolean[n];
             in=leer.nextInt()-1;
             fin=leer.nextInt()-1;
             path(in,fin,"",0,in,0);
             int ai,bi;
             ai=hm.get(r1+" "+r2).ai;
             bi=hm.get(r1+" "+r2).bi;
             ArrayList<rango> ac=new ArrayList<>();
             for (int i = 0, j=1; i < x.length()-1; i++,j++) {
                dato dat=hm.get(x.charAt(i)+" "+x.charAt(j));
                if(dat.bi>ai){
                    ac.add(new rango(dat.ai,dat.bi));
                }
            }
             double num;
             double cont=0;
             if(ac.size()==1){
                 System.out.println((double)((ac.get(0).ai+ac.get(0).bi)/2.0));
             }else{
                
                 for (int i = 0; i < 50000; i++) {
                     num=0;
                     for (int j = 0; j < ac.size(); j++) {
                         num=Math.max(num,(Math.random()*(ac.get(j).bi-ac.get(j).ai)+ac.get(j).ai));
                        // System.out.println(ac.get(j).ai+" "+ac.get(j).bi+" "+num);
                     }
                     cont+=num;
                 }
                 System.out.println(cont/50000);
             }
        }
    }
}
