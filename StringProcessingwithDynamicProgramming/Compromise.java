/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringProcessingwithDynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Compromise {
    static ArrayList<String> ar1;
    static ArrayList<String> ar2;
    
        static int lcs(int m, int n){
        int lcs[][]=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0) lcs[i][j]=0;
                else if(ar1.get(i-1).equals(ar2.get(j-1))) lcs[i][j]=lcs[i-1][j-1]+1;
                else lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        //Para saber cual es la palabra
        int ind=lcs[m][n];
        int ind2=ind;
        //System.out.println(ind);
        String sal[]=new String[ind];
        int i=m,j=n;
        while(i>0 && j>0){
            if(ar1.get(i-1).equals(ar2.get(j-1))){
                sal[ind-1]=ar1.get(i-1);
                i--; j--; ind--;
            }else{
                if(lcs[i-1][j]>lcs[i][j-1]) i--;
                else j--;
            }
        }
            System.out.print(sal[0]);
        for(int k=1; k<ind2;k++){
            System.out.print(" "+sal[k]);
        }
            System.out.println("");
        return lcs[m][n];
    }
    
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            ar1=new ArrayList<>();
            ar2=new ArrayList<>();
            String s=leer.next();
            while(!s.equals("#")){
               ar1.add(s);
               s=leer.next();
            }
            s=leer.next();
            while(!s.equals("#")){
               ar2.add(s);
               s=leer.next();
            }
            lcs(ar1.size(),ar2.size());
        }
    }
}
