/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Arrays;

/**
 *
 * @author luis
 */
public class TheNecklace {
    
        static class mipar{
        int a;
        boolean b=true;

        public mipar(int a) {
            this.a = a;
        }
        
        
    }
    static LinkedList<Integer> list;
    static ArrayList<ArrayList<mipar>> adj;
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        for (int i = 1; i <= casos; i++) {
            int in[]=new int[51];
            int out[]=new int[51];
            int ed=leer.nextInt();
            adj=new ArrayList<ArrayList<mipar>>();
            //p.addAll(Collections.nCopies(v,-1));
            //adj.addAll(Collections.nCopies(51, new ArrayList<par>() ));
            //adj.addAll(Collections.nCopies(51, new ArrayList<par>()));
            //adj=Arrays.fill(list, ArrayList<mipar>);
/*            for (int m = 0; m < 51; m++) {
                adj.add(new ArrayList<par>());
            }*/
            int a,b;
            int indI=0,indF;
            a=leer.nextInt();
            b=leer.nextInt();
            indI=a;
            indF=b;
            in[a]++;
            in[b]++;
            out[a]++;
            out[b]++;
            list=new LinkedList<>();
            adj.get(a).add(new mipar(b));
            adj.get(b).add(new mipar(a));
            ed--;
            while(ed-->0){
                a=leer.nextInt();
                b=leer.nextInt();
                in[a]++;
                in[b]++;
                out[a]++;
                out[b]++;
                adj.get(a).add(new mipar(b));
                adj.get(b).add(new mipar(a));
            }
            int cont=0;
            for (int j = 1; j < 51; j++) {
                if(in[j]!=out[j] || in[j]%2==1){
                    cont++;
                }
            }
            if (i!=1) System.out.println("");
            if(cont==0){
                System.out.println("Case #"+i);
                dfs(indI);
                for (int j = 0; j < list.size()-1; j++) {
                    System.out.println(list.get(j)+" "+list.get(j+1));
                }
                System.out.println(list.get(list.size()-1)+" "+list.get(0));
            }else{
                System.out.println("Case #"+i);
                System.out.println("some beads may be lost");
            }
        }
    }
    
    static void dfs (int u){
        for (int i = 0; i < adj.get(u).size(); i++) {
            mipar v= adj.get(u).get(i);
            if(v.b==true){
                v.b=false;
                for (int j = 0; j < adj.get(v.a).size(); j++) {
                    mipar uu= adj.get(v.a).get(j);
                    if(uu.a==u && uu.b==true){
                        uu.b=false;
                        break;
                    }
                }
                list.add(u);
                dfs(v.a);
            }
        }
    }
}
