/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.Scanner;


public class MorningWalk {
    static int visit[];
    static int map[][];
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int a,b;
            a=leer.nextInt();
            int in[]=new int[a];
            int out[]=new int[a];
            map=new int[a][a];
            visit=new int[a];
            b=leer.nextInt();
            int x,y;
            int aux=-1;
            for (int i = 0; i < b; i++) {
                x=leer.nextInt();
                y=leer.nextInt();
                if(aux==-1) aux=x;
                in[x]++;
                in[y]++;
                out[x]++;
                out[y]++;
                map[x][y]=1;
                map[y][x]=1;
            }
            int cont=0;
            for (int i = 0; i < a; i++) {
                if(in[i]!=out[i] || in[i]%2==1){
                    cont++;
                }
            }
            if(cont==0 && aux!=-1){
                dfs(aux);
                for (int i = 0; i < a; i++) {
                    for (int j = 0; j < a; j++) {
                        if(map[i][j]==1) cont++;
                    }
                }
                if(cont==0)
                System.out.println("Possible");
                else System.out.println("Not Possible");
            }else{
                System.out.println("Not Possible");
            }
        }        
    }
    
        static void dfs(int u){
        if(visit[u]==1) return;
        visit[u]=1;
        for (int i = 0; i < map[u].length; i++) {
            if(map[u][i]>0){
                map[u][i]=0;
                map[i][u]=0;
                dfs(i);
            }
        }
    }
}
