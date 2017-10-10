/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TheProblemWithTheProblemSetter {
    static int res[][];
    static ArrayList<Integer> p=new ArrayList<>();
    static int f,so;
    static int INF=1000000000;
    
    private static void augment(int v, int minEdge) {
        if (v == so) {
            f = minEdge;
            return;
        } 
        else if (p.get(v) != -1) {
            augment(p.get(v), Math.min(minEdge, res[p.get(v)][v]));
            res[p.get(v)][v] -= f;
            res[v][p.get(v)] += f;
        } 
    }
    
    public static void main(String[] args) throws IOException {
        //Scanner leer=new Scanner(System.in);
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        int a,b;
        String s[]=leer.readLine().split(" ");
        a=Integer.parseInt(s[0]);
        b=Integer.parseInt(s[1]);
        while(a!=0 && b!=0){
            int v=a+b+2;
            int t,z,x;
            int max=0;
            res=new int[v][v];
            so=0;
            t=v-1;
            s=leer.readLine().split(" ");
            for (int i = 0; i < a; i++) {
                res[b+1+i][t]=Integer.parseInt(s[i]);
                max+=res[b+1+i][t];
            }
            for (int i = 0; i < b; i++) {
                s=leer.readLine().split(" ");
                for (int j = 1; j < s.length; j++) {
                    x=Integer.parseInt(s[j]);
                    res[i+1][b+x]=INF;
                }
            }
            for (int i = 0; i < b; i++) {
                res[so][i+1]=1;
            }
             int mf=0;
            while(true){
                f=0;
                Queue <Integer> q=new LinkedList<Integer>();
                ArrayList<Integer> dist=new ArrayList<>();
                dist.addAll(Collections.nCopies(v, INF));
                q.offer(so);
                dist.set(so, 0);
                p.clear();
                p.addAll(Collections.nCopies(v,-1));
                while(!q.isEmpty()){
                    int u=q.poll();
                    if(u==t) break;
                    for (int i = 0; i < v; i++) {
                        if(res[u][i]>0 && dist.get(i)==INF){
                            dist.set(i, dist.get(u)+1);
                            q.offer(i);
                            //System.out.println("v "+v);
                            p.set(i, u);
                        }
                    }
                }
                augment(t, INF); 
                if (f == 0) {
                    break; 
                }
                mf += f; 
            }
            //System.out.println("mf "+mf);
            if(mf==max){
                System.out.println("1");
                boolean prim;
                for (int i = 0; i < a; i++) {
                    prim=true;
                    for (int j = 0; j < b; j++) {
                        if(res[b+1+i][j+1]>0){
                            if(prim){
                                prim=false;
                                System.out.print(j+1);
                            }else{
                                System.out.print(" "+(j+1));
                            }
                        }
                    }
                    System.out.println("");
                }
            }else{
                System.out.println("0");
            }
            s=leer.readLine().split(" ");
        a=Integer.parseInt(s[0]);
        b=Integer.parseInt(s[1]);
        }
    }
}
