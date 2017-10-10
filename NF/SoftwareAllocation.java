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

/**
 *
 * @author luis
 */
public class SoftwareAllocation {
    static int res[][];
    static int INF=1000000000;
    static ArrayList<Integer> p=new ArrayList<>();
    static int f,so;
    
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
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int v = 38;
            so = 0;
            int t = 37;
            res=new int[v][v];
            int us=0;
            while (s!=null &&(s = s.trim()).length() > 0) {
                String data[]=s.split(" ");
                res[so][(data[0].charAt(0)-'A')+1]=data[0].charAt(1)-'0';
                us+=data[0].charAt(1)-'0';
                char com[]=data[1].toCharArray();
                for (int i = 0; i < com.length-1; i++) {
                    res[(data[0].charAt(0)-'A')+1][(com[i]-'0')+27]=100000000;
                     res[(com[i]-'0')+27][t]=1;
                     //System.out.println("com "+((com[i]-'0')+27));
                }
                s=br.readLine();
            }
           /* for (int i = 0; i < 37; i++) {
                for (int j = 0; j < 37; j++) {
                    System.out.print(res[i][j]+" ");
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
            //System.out.println(mf+" "+us);
            if(mf==us){
                char r[]=new char[10];
                for (int i = 27,k=0; i < 37; i++,k++) {
                    r[k]='_';
                    for (int j = 1; j < 27; j++) {
                        if(res[i][j]==1){
                            r[k]=(char)((j+'A')-1);
                        }
                    }
                }
                for (int i = 0; i < 10; i++) {
                    System.out.print(r[i]);
                }
                System.out.println("");
            }else{
                System.out.println("!");
            }
        }
    }
}
