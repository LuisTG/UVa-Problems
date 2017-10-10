/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author luis
 */
public class GrapeVine12192 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        int m=leer.nextInt();
        while(n!=0 && m!=0){
            int row[][]=new int[n][m];
            int colum[][]=new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    row[i][j]=leer.nextInt();
                    colum[j][i]=row[i][j];
                }
            }
           /* for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(row[i][j]+" ");
                }
                System.out.println("");
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(colum[i][j]+" ");
                }
                System.out.println("");
            }*/
            int q=leer.nextInt();
            while(q-->0){
                int x,y,pos;
                x=leer.nextInt();
                y=leer.nextInt();
                int x1max=-1,y1min=10000;
                for (int i = 0; i < n; i++) {
                    pos=Arrays.binarySearch(row[i], x);
                    if(pos<0) pos=pos*-1-1;
                    x1max=Math.max(pos, x1max);
                    pos=Arrays.binarySearch(row[i], y);
                    if(pos<0) pos=pos*-1-1;
                    y1min=Math.min(pos, y1min);
                }
                int x2max=-1,y2min=10000;
                for (int i = 0; i < m; i++) {
                    pos=Arrays.binarySearch(colum[i], x);
                    if(pos<0) pos=pos*-1-1;
                    x2max=Math.max(pos, x2max);
                    pos=Arrays.binarySearch(colum[i], y);
                    if(pos<0) pos=pos*-1-1;
                    y2min=Math.min(pos, y2min);
                }
                System.out.println(Math.max(y1min-x1max+1,y2min-x2max+1));
                System.out.println(x1max+" "+y1min);
                System.out.println(x2max+" "+y2min);
                //System.out.println(inter(x1max,0,y1min,n,0,x2max,m,y2min));                
            }
             n=leer.nextInt();
             m=leer.nextInt();
        }
    }
    
    static int inter(int x1, int y1, int x2, int y2,int x3, int y3, int x4, int y4){
        int a,b,c,d;   
        a=Math.max(x1, x3);
        b=Math.max(y1, y3);
        c=Math.min(x2, x4);
        d=Math.min(y2, y4);
        
        if(a>=c || b>=d){
           //System.out.println("No Overlap");
            return 0;
        }else{
            return Math.min(c-a, d-b);
           //System.out.println(a+" "+b+" "+c+" "+d);
        }
    }
}
