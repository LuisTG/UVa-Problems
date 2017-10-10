/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringProcessingwithDynamicProgramming;

import java.util.Scanner;


public class Vacation {
        static int lcs(String x,String y){
        char ar1[]=x.toCharArray();
        char ar2[]=y.toCharArray();
        int m=ar1.length;
        int n=ar2.length;
        int lcs[][]=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0) lcs[i][j]=0;
                else if(ar1[i-1]==ar2[j-1]) lcs[i][j]=lcs[i-1][j-1]+1;
                else lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        return lcs[m][n];
    }
        
        public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        String s;
        String x;
        int d=1;
        while(leer.hasNext()){
            s=leer.nextLine();
            x=leer.nextLine();
            int c= lcs(s,x);
            //System.out.println("Case #"+d+": you can visit at most "+c+" cities.");
            System.out.println(c);
            d++;
        }
    }
    
}
