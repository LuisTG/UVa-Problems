/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author luis
 */
public class AirlineComparison {
    public static void main(String[] args) throws IOException {
        BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(leer.readLine().trim());
        leer.readLine();
        while(n-->0){
            int a=Integer.parseInt(leer.readLine().trim());
            int aux=26;
            int inf=100000000;
            int f1[][]=new int[aux][aux];
            int f2[][]=new int[aux][aux];
            for (int j = 0; j < aux; j++) {
                for (int k = 0; k < aux; k++) {
                    f1[j][k]=inf;
                    f2[j][k]=inf;
                }
            }
            String s;
            for (int i = 0; i < a; i++) {
                s=leer.readLine();
                f1[s.charAt(0)-'A'][s.charAt(2)-'A']=1;
                f1[s.charAt(2)-'A'][s.charAt(0)-'A']=1;
                
            }
            int b=Integer.parseInt(leer.readLine().trim());
            for (int i = 0; i < b; i++) {
                s=leer.readLine();
                f2[s.charAt(0)-'A'][s.charAt(2)-'A']=1;
                f2[s.charAt(2)-'A'][s.charAt(0)-'A']=1;
                
            }
            
            for (int j = 0; j < aux; j++) {
                for (int k = 0; k < aux; k++) {
                    for (int l = 0; l < aux; l++) {
                        f1[k][l]=Math.min(f1[k][l], f1[k][j]+f1[j][l]);
                        f2[k][l]=Math.min(f2[k][l], f2[k][j]+f2[j][l]);
                    }
                }
            }
            boolean ban=false;
            for (int i = 0; i < aux; i++) {
                for (int j = 0; j < aux; j++) {
                    if(f1[i][j]==inf && f2[i][j]!=inf || f1[i][j]!=inf && f2[i][j]==inf){
                        ban=true;
                        i=aux;
                        j=aux;
                    }
                }
            }
            
            if(ban) System.out.println("NO");
            else System.out.println("YES");
            if(n!=0){
                System.out.println("");
                leer.readLine();
            }
            
        }
    }
}
