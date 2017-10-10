/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class MyTshirtsuitsme {
    static int res[][];
    static int INF=1000000000;
    static ArrayList<Integer> p=new ArrayList<>();
    static int f, so;

    private static void augment(int v, int minEdge) {
        if (v == so) {
            f = minEdge;
            return;
        } else if (p.get(v) != -1) {
            augment(p.get(v), Math.min(minEdge, res[p.get(v)][v]));
            res[p.get(v)][v] -= f;
            res[v][p.get(v)] += f;
        }
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        String s[]={"XXL","XL","L","M","S","XS"};
        HashMap<String, Integer> hm =new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            hm.put(s[i], (i+1));
        }
        int casos=leer.nextInt();
        while(casos-->0){
            int a,b,v,t;
            a=leer.nextInt();
            b=leer.nextInt();
            v=b+8;
            so=0;
            t=v-1;
            res=new int[v][v];
            for (int i = 0; i < s.length; i++) {
                res[b+hm.get(s[i])][t]=a/6;
            }
            for (int i = 0; i < b; i++) {
                res[so][i+1]=1;
            }
            String x,y;
            for (int i = 0; i < b; i++) {
                x=leer.next();
                y=leer.next();
                res[i+1][b+hm.get(x)]=1000000000;
                res[i+1][b+hm.get(y)]=1000000000;
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
            
            if(mf==b){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
