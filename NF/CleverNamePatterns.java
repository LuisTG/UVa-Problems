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
import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class CleverNamePatterns {
    
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
            int v,t;
            so=0;
            v=730;
            t=729;
            res=new int[v][v];
            HashMap<String, Integer> hm=new HashMap<>();
            HashMap<Integer, String> hm2=new HashMap<>();
            int problemas=leer.nextInt();
            for (int i = 1; i <= problemas; i++) {
                res[so][i]=1;
                res[i+702][t]=1;
            }
            String s;
            int cont=27;
            for (int i = 0; i < problemas; i++) {
                int nom=leer.nextInt();
                for (int j = 0; j < nom; j++) {
                    s=leer.next().toLowerCase();
                    res[(s.charAt(0)-'a')+1][cont]=1;
                    res[cont][703+i]=1;
                    hm2.put(cont, s);
                    hm.put(s, cont++);
                }
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
/*            for (int i = 27; i < 53; i++) {
                for (int j = 53; j < 79; j++) {
                    System.out.print(res[i][j]+" ");
                }
                System.out.println("");
            }*/
            /*for (int i = 703; i < 729; i++) {
                System.out.print(res[32][i]+" ");
            }*/
           // System.out.println("jsjs "+res[705][t]);
            TreeSet<String> tr=new TreeSet();
            for (int i = 703; i < 729; i++) {
                for (int j = 27; j < 703; j++) {
                    if(res[i][j]==1){
                        tr.add(hm2.get(j).substring(0, 1).toUpperCase()+hm2.get(j).substring(1));
                    }
                }
            }
            System.out.println("Case #"+h+":");
            while(!tr.isEmpty()){
                System.out.println(tr.pollFirst());
            }
        }
    }
}
