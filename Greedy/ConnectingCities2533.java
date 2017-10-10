/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 *
 * @author luis
 */
public class ConnectingCities2533 {
        static int padre[];
    
    static void MakeSet(int n) {
        padre=new int[n];
        for (int i = 0; i < n; ++i) {
            padre[i] = i;
        }
    }

    static int Find(int x) {
        return (x == padre[x]) ? x : (padre[x] = Find(padre[x]));
    }

    static void Union(int x, int y) {
        padre[Find(x)] = Find(y);
    }

    static boolean sameComponent(int x, int y) {
        if (Find(x) == Find(y)) {
            return true;
        }
        return false;
    }
    
    static class Three implements Comparable<Three>{
         int s;
         int d;
         long w;
         boolean puente=false;

        public Three(int s, int d, long w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }
         
        @Override
        public int compareTo(Three o) {
            return this.w<o.w?-1:1;
        }
    
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int casos=Integer.parseInt(br.readLine());
        for (int l = 1; l <= casos; l++) {
            String s[]=br.readLine().split(" ");
            int a=Integer.parseInt(s[0]);
            int b=Integer.parseInt(s[1]);
            long r=Long.parseLong(s[2]);
            Three edge[]=new Three[b];
            for (int i = 0; i < b; i++) {
                s=br.readLine().split(" ");
                edge[i]=new Three(Integer.parseInt(s[0])-1,Integer.parseInt(s[1])-1, Long.parseLong(s[2]));
            }
            Arrays.sort(edge);
            boolean p[]=new boolean[a];
            int cost=0;
            MakeSet(a);
            long cont;
            long puen=0;
            long aux;
            boolean x,xx;
            for (int i = 0; i < b; i++) {
                Three data=edge[i];
                cont=0;
                aux=r;
                x=false;
                xx=false;
                if(!sameComponent(data.s,data.d)){
                    int ps=Find(data.s);
                    int pd=Find(data.d);
                    if(!p[ps]) cont+=r;
                    if(!p[pd]) cont+=r;
                    if((data.w)<r*2){
                        cost+=data.w;
                        Union(data.s,data.d);
                    }
                }
            }
           // System.out.println("puen "+puen);
            for (int i = 0; i < a; i++) {
                if(padre[i]==i) puen++;
            }
            if(puen<2)
            System.out.println((cost));
            else
            System.out.println((cost+puen*r));
        }
    }
}
