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

public class Sabotage {
    
    
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
        int n, m;
        int cont=0;
        n=leer.nextInt();
        m=leer.nextInt();
        while(n!=0 && m!=0){
            int v,t;
            v=n;
            so=0;
            t=1;
            res=new int[v][v];
            int x,y;
            for (int i = 0; i < m; i++) {
                x=leer.nextInt()-1;
                y=leer.nextInt()-1;
                res[x][y]=leer.nextInt();
                res[y][x]=res[x][y];
            }
            int mf = 0;

            while (true) {
                f = 0;
                Queue<Integer> q = new LinkedList<Integer>();
                ArrayList<Integer> dist = new ArrayList<>();
                dist.addAll(Collections.nCopies(v, INF));
                q.offer(so);
                dist.set(so, 0);
                p.clear();
                p.addAll(Collections.nCopies(v, -1));
                while (!q.isEmpty()) {
                    int u = q.poll();
                    if (u == t) {
                        break;
                    }
                    for (int i = 0; i < v; i++) {
                        if (res[u][i] > 0 && dist.get(i) == INF) {
                            dist.set(i, dist.get(u) + 1);
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
            int com[]=new int[n];
            Queue<Integer> q = new LinkedList<Integer>();
                ArrayList<Integer> dist = new ArrayList<>();
                dist.addAll(Collections.nCopies(v, INF));
                q.offer(so);
                dist.set(so, 0);
                p.clear();
                p.addAll(Collections.nCopies(v, -1));
                while (!q.isEmpty()) {
                    int u = q.poll();
                    if (u == t) {
                        break;
                    }
                    com[u]=1;
                    for (int i = 0; i < v; i++) {
                        if (res[u][i] > 0 && dist.get(i) == INF) {
                            dist.set(i, dist.get(u) + 1);
                            q.offer(i);
                            p.set(i, u);
                        }
                    }
                }
                String resp="";
              /*  for (int i = 0; i < n; i++) {
                 if(com[i]==1) System.out.print(i+" ");
            }
            System.out.println("");*/
                for (int i = 0; i < n; i++) {
                    if(com[i]==1){
                        for (int j = 0; j < n; j++) {
                            if(com[j]==0){
                                if(res[j][i]>0){
                                    resp+=(i+1)+" "+(j+1)+"\n";
                                }
                            }
                        }
                    }
                }
                if(cont!=0) System.out.println("");
                System.out.print(resp);
                cont++;
            n=leer.nextInt();
            m=leer.nextInt();
        }
    }
}
