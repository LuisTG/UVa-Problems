/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public class InternetBandwidth {
    static int res[][];
    static int INF=1000000000;
    static ArrayList<Integer> p=new ArrayList<>();
    static int f,s;
    private static void augment(int v, int minEdge) {
        if (v == s) {
            f = minEdge;
            return;
        } 
        else if (p.get(v) != -1) {
            augment(p.get(v), Math.min(minEdge, res[p.get(v)][v]));
            res[p.get(v)][v] -= f;
            res[v][p.get(v)] += f;
        } 
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int v=leer.nextInt();
        int t,c;
        int a,b,d;
        int red=1;
        while(v!=0){
            s=leer.nextInt()-1;
            t=leer.nextInt()-1;
            c=leer.nextInt();
            res=new int[v][v];
            for (int i = 0; i < c; i++) {
                a=leer.nextInt()-1;
                b=leer.nextInt()-1;
                d=leer.nextInt();
                res[a][b]+=d;
                res[b][a]+=d;
            }
            
            int mf=0;
            
            while(true){
                f=0;
                Queue <Integer> q=new LinkedList<Integer>();
                ArrayList<Integer> dist=new ArrayList<>();
                dist.addAll(Collections.nCopies(v, INF));
                q.offer(s);
                dist.set(s, 0);
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
            System.out.println("Network "+red);
            System.out.println("The bandwidth is "+mf+".");
            System.out.println("");
            red++;
            v=leer.nextInt();
        }
    }
}
