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
public class AMatchMakingProblem12210 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n,m;
        n=leer.nextInt();
        m=leer.nextInt();
        int casos=1;
        while(n!=0 && m!=0){
            int ar[]=new int[n];
            int er[]=new int[m];
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
            }
            for (int i = 0; i < m; i++) {
                er[i]=leer.nextInt();
            }
            if(n>m){
                int aux=n-m;
                Arrays.sort(ar);
                System.out.println("Case "+casos+": "+aux+" "+ar[0]);
            }else{
                System.out.println("Case "+casos+": 0");
            }
            n=leer.nextInt();
            m=leer.nextInt();
            casos++;
        }
    }
}
