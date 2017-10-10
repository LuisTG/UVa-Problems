/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package NF;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Buggy {
    static class nodo{
        int x,y;
        String s;
        char val;

        public nodo(int x, int y, String s, char val) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.val = val;
        }
  
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int a,b;
        int ax[]={0,1,-1,0};
        int ay[]={1,0,0,-1};
        char cor[]={'R','D','U','L'};
        a=leer.nextInt();
        b=leer.nextInt();
        char map[][]=new char[a][b];
        for (int i = 0; i < a; i++) {
            map[i]=leer.next().toCharArray();
        }
        nodo x = null;
        String comando=leer.next();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if(map[i][j]=='R'){
                    x=new nodo(i,j,"",'R');
                    break;
                }
            }
        }
        Queue<nodo> q=new LinkedList<nodo>();
        q.add(x);
        boolean band=false;
        String camino="";
        while(!q.isEmpty()){
            nodo aux=q.poll();
            if(aux.val=='E'){
                band=true;
                camino=aux.s;
                break;
            }
            for (int i = 0; i < 4; i++) {
                if(aux.x+ax[i]<a && aux.x+ax[i]>-1 && aux.y+ay[i]>-1 && aux.y+ay[i]<b){
                    if(map[aux.x+ax[i]][aux.y+ay[i]]!='#'){
                        q.add(new nodo(aux.x+ax[i],aux.y+ay[i],(aux.s+cor[i]),map[aux.x+ax[i]][aux.y+ay[i]]));
                        map[aux.x+ax[i]][aux.y+ay[i]]='#';
                        //System.out.println(q.peek().s);
                    }
                }
            }
        }
        //int cont=0;
        /*System.out.println(camino);
        for (int i = 0, j = 0; i < camino.length() && j<comando.length();) {
            System.out.println("camino "+camino.charAt(i)+" comando "+comando.charAt(j));
            if(camino.charAt(i)==comando.charAt(j)){
                cont++;
                j++;
                i++;
            }else{
                j++;
            }
        }
        System.out.println(cont);*/
        System.out.println(camino);
        int m=camino.length();
        int n=comando.length();
        int lcs[][]=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0) lcs[i][j]=0;
                else if(camino.charAt(i-1)==comando.charAt(j-1)) lcs[i][j]=lcs[i-1][j-1]+1;
                else lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        
        System.out.println(camino.length()-lcs[m][n]);
    }
}
