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
public class IntegerSecuencesFromAddition927 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int n=leer.nextInt();
            long aux[]=new long[n+1];
            for (int i = 0; i < n+1; i++) {
                aux[i]=leer.nextLong();
            }
            long d=leer.nextLong();
            long k=leer.nextLong();
            long ac=1*d;
            long cont=1;
            while(ac<k){
                cont++;
                ac+=cont*d;
            }
            //System.out.println(cont+" ksdjh");
            long res=0;
            for (int i = 0; i < n+1; i++) {
                res+=aux[i]*(Math.pow(cont, i));
            }
            System.out.println(res);
        }
    }
}
