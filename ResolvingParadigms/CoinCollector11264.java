/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class CoinCollector11264 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int n=leer.nextInt();
            int cont=1;
            long sum=0;
            int ar[]=new int[n];
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
            }
            int m;
            for(int i=0;i<n-1; i++){
                //sum+=ar[i];
                if(sum+ar[i]<ar[i+1]){
                    sum+=ar[i];
                    cont++;
                }
                //System.out.println("cuanto "+cont+" m "+m+" sum "+sum);
            }
            //cont=Math.max(cont, mon(157,ar));
            System.out.println(cont);
        }
    }
}
