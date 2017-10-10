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
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DownWentTransmission {
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
    
    public static void main(String[] args) throws IOException {
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s=leer.readLine())!=null){
            String da[]=s.split(" ");
            int x,y;
            x=Integer.parseInt(da[0]);
            y=Integer.parseInt(da[1]);
            char mat[][]=new char[x][y];
            int pp=Integer.parseInt(da[2]);
            int cont=1;
            HashMap<String,Integer> hm=new HashMap<>();
            for (int i = 0; i < x; i++) {
                mat[i]=leer.readLine().toCharArray();
                for (int j = 0; j < y; j++) {
                    if(mat[i][j]!='~'){
                        hm.put(i+" "+j, cont);
                        cont++;
                    }
                }
            }
            int t,v=hm.size()*2+2;
            so=0;
            t=v-1;
            res=new int[v][v];
            int movx[]={1,-1,0,0};
            int movy[]={0,0,-1,1};
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if(mat[i][j]=='*'){
                        res[hm.get(i+" "+j)*2-1][hm.get(i+" "+j)*2]=1;
                        res[so][hm.get(i+" "+j)*2-1]=1;
                    }
                    if(mat[i][j]=='#'){
                        res[hm.get(i+" "+j)*2-1][hm.get(i+" "+j)*2]=10000;
                        res[hm.get(i+" "+j)*2][t]=pp;
                    }
                    if(mat[i][j]=='@'){
                        res[hm.get(i+" "+j)*2-1][hm.get(i+" "+j)*2]=10000;
                    }
                    if(mat[i][j]=='.'){
                        res[hm.get(i+" "+j)*2-1][hm.get(i+" "+j)*2]=1;
                    }
                    if(mat[i][j]!='~'){
                        for (int k = 0; k < 4; k++) {
                            if(i+movx[k]>-1&&i+movx[k]<x&&j+movy[k]>-1&&j+movy[k]<y){
                                if(mat[i+movx[k]][j+movy[k]]!='~'){
                                    //System.out.println("hola1 "+i+" "+j);
                                    //System.out.println("hola "+(i+movx[k])+" "+(j+movy[k]));
                                    res[hm.get(i+" "+j)*2][hm.get((i+movx[k])+" "+(j+movy[k]))*2-1]=1000;
                                }
                            }
                        }
                    }
                }
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
            leer.readLine();
        }
    }
}
