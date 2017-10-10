/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class PlayonWords {
    static int map[][];
    static int visit[];
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int inside[]=new int[26];
            int outside[]=new int[26];
            map=new int[26][26];
            visit=new int[26];
            int words=leer.nextInt();
            int aux=words;
            String s;
            int in,fin;
            aux=words;
            TreeSet<Integer> tr=new TreeSet<>();
            int comp=0;
            while(words-->0){
                s=leer.next();
                in=s.charAt(0)-'a';
                fin=s.charAt(s.length()-1)-'a';
                    outside[in]++;
                    inside[fin]++;
                    if(in==fin) comp++;
                    map[in][fin]=1;
                    map[fin][in]=1;
            }
            int cont=0;
            int cc=0;
            in=-1;
            for (int i = 0; i < 26; i++) {
                if(outside[i]!=0) in=i;
                if(Math.abs(inside[i]-outside[i])>0){
                    if(Math.abs(inside[i]-outside[i])>=2){
                        cc=1;
                    }else{
                        cont++;
                    }
                }
            }
            //System.out.println(cont);
            boolean resp=true;
            if(cont<=2 && cc==0  || aux==1){
                if(in!=-1){
                    //System.out.println("hola "+in);
                    dfs(in);
                    for (int i = 0; i < 26; i++) {
                        for (int j = 0; j < 26; j++) {
                           // System.out.print(map[i][j]+" ");
                            if(map[i][j]!=0){
                                
                                resp=false;
                            }
                        }
                        //System.out.println("");
                    }
                }
                if(resp)
                System.out.println("Ordering is possible.");
                else{
                    System.out.println("The door cannot be opened.");
                }
            }
            else System.out.println("The door cannot be opened.");
        }
        
    }
    
    static void dfs(int u){
        if(visit[u]==1) return;
        visit[u]=1;
        for (int i = 0; i < 26; i++) {
            if(map[u][i]>0){
                map[u][i]=0;
                map[i][u]=0;
                dfs(i);
            }
        }
    }
}
