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


public class CollectorsProblem {
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
        int casos=leer.nextInt();
        for (int h = 1; h <= casos; h++) {
            int v, n, m,t;
            n=leer.nextInt();
            m=leer.nextInt();
            int jug[][]=new int[n][m];
            so=0;
            v=(n*2*m)+2;
            t=v-1;
            res=new int[v][v];
            int aux;
            for (int i = 0; i < n; i++) {
                aux=leer.nextInt();
                for (int j = 0; j < aux; j++) {
                    jug[i][leer.nextInt()-1]++;
                }
            }
            for (int i = 0; i < m; i++) {
                res[so][i+1]=jug[0][i];
                res[(n*2*m)-m+i+1][t]=1;
                res[i+1][(n*2*m)-m+i+1]=INF;
            }
            
            for (int i = 0; i < n*2-2; i+=2) {
                for (int j = 0; j < m; j++) {
                    res[j+1][m*i+m+j+1]=1;
                }
            }
            for (int i = 0, ju=1; i < n*2-2; i+=2,ju++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < m; k++) {
                        if(jug[ju][j]==0)
                        res[m*i+m+j+1][m*(i+1)+m+k+1]=1;
                    }
                    res[m*i+m+j+1][m*(i+1)+m+j+1]=0;
                }
            }     
            for (int i = 2,k=1; i <n*2 ; i+=2,k++) {
                for (int j = 0; j < m; j++) {
                    res[i*m+j+1][j+1]=jug[k][j]-1;
                }
            }
             /*                      for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    System.out.print(res[i][j]+ " ");
                }
                System.out.println("");
            }*/
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
 
            System.out.println("Case #"+h+": "+mf);
                                               for (int i = 0; i < v; i++) {
                /*for (int j = 0; j < v; j++) {
                    System.out.print(res[i][j]+ " ");
                }
                System.out.println("");*/
            }
        }
    }
}
