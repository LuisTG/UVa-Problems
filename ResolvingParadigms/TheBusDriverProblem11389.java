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
public class TheBusDriverProblem11389 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n,d,r;
        n=leer.nextInt();
        d=leer.nextInt();
        r=leer.nextInt();
        while(n!=0 && d!=0 && r!=0){
            int mor[]=new int[n];
            int after[]=new int[n];
            for (int i = 0; i < n; i++) {
                mor[i]=leer.nextInt();
            }
            for (int i = 0; i < n; i++) {
                after[i]=leer.nextInt();
            }
            int aux=0;
            Arrays.sort(mor);
            Arrays.sort(after);
            for (int i = 0, j=n-1; i < n; i++,j--) {
                if((mor[i]+after[j])>d){
                    aux+=((mor[i]+after[j])-d)*r;
                }
            }
            System.out.println(aux);
            n=leer.nextInt();
            d=leer.nextInt();
            r=leer.nextInt();
        }
    }
}
