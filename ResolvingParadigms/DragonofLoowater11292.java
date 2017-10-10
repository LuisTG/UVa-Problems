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
public class DragonofLoowater11292 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        int m=leer.nextInt();
        while(n!=0 && m!=0){
            int heads[]=new int[n];
            int kni[]=new int[m];
            for(int i=0; i< n; i++){
                heads[i]=leer.nextInt();
            }
            for (int i = 0; i < m; i++) {
                kni[i]=leer.nextInt();
            }
            boolean band=true;
            int cont=0;
            int sum=0;
            if(n>m){
                band=false;
            }else{
                Arrays.sort(heads);
                Arrays.sort(kni);
                for(int i=0, j=0;i<n && j<m;){
                    if(heads[i]<=kni[j]){
                        cont++;
                        sum+=kni[j];
                        i++;
                        j++;
                    }else{
                        j++;
                    }
                }
                if(cont<n){
                    band=false;
                }
            }
            if(band){
                System.out.println(sum);
            }else{
                System.out.println("Loowater is doomed!");
            }
            n=leer.nextInt();
            m=leer.nextInt();
        }
    }
}
