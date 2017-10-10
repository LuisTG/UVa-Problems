
package StringProcessingwithDynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LongestMatch {
    
    static String ar1[];
    static String ar2[];
    
    static int lcs(String x,String y){
        ar1=x.split(" ");
        ar2=y.split(" ");
        int m=ar1.length;
        int n=ar2.length;
        int lcs[][]=new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i==0 || j==0) lcs[i][j]=0;
                else if(ar1[i-1].equals(ar2[j-1])) lcs[i][j]=lcs[i-1][j-1]+1;
                else lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
            }
        }
        return lcs[m][n];
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner leer=new Scanner(System.in);
        char aux;
        int cont=1;
        while(leer.hasNext()){
            String s=leer.nextLine();
            String b=leer.nextLine();
            char dataS[]=s.toCharArray();
            char dataB[]=b.toCharArray();
            for (int i = 0; i < dataS.length; i++) {
                aux=dataS[i];
                if(aux<47 || (aux>58 && aux<65) || (aux>90&&aux<97)  || aux>122){
                    dataS[i]=' ';
                }
            }
            for (int i = 0; i < dataB.length; i++) {
                aux=dataB[i];
                if(aux<47 || (aux>58 && aux<65) || (aux>90&&aux<97) || aux>122){
                    dataB[i]=' ';
                }
            }
            s=new String(dataS);
            b=new String(dataB);
            String format;
            if(s.isEmpty() || b.isEmpty()){
                format = String.format("%2d. Blank!\n", ++cont);
            }else{
                int x=lcs(s,b);
                format = String.format("%2d. Length of longest match: %d\n", cont, x);   
            }
            System.out.println(format);
            cont++;
        }
    }
}
