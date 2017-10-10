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


public class PowerTransmission {
    
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
        while(leer.hasNext()){
            int t,v;
            int reg=leer.nextInt();
            v=reg*2+2;
            so=0;
            t=v-1;
            res=new int[v][v];
            for (int i = 1; i <= reg; i++) {
                res[i*2-1][i*2]=leer.nextInt();
            }
            int edges=leer.nextInt();
            int x,y;
            for (int i = 0; i < edges; i++) {
                x=leer.nextInt();
                y=leer.nextInt();
                res[x*2][y*2-1]=leer.nextInt();
            }
            int b,d;
            b=leer.nextInt();
            d=leer.nextInt();
            for (int i = 0; i < b; i++) {
                res[so][leer.nextInt()*2-1]=INF;
            }
            for (int i = 0; i < d; i++) {
                res[leer.nextInt()*2][t]=INF;
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
            System.out.println(mf);
        }
    }
}
