/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Apples1622 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int n=leer.nextInt();
            int a[]=new int[n];
            int cont=0;
            for (int i = 0; i < n; i++) {
                a[i]=leer.nextInt();
                cont+=a[i];
            }
            int r=0;
            for (int i = 0; i < n; i++) {
                if((cont-a[i])%2==0){
                    r++;
                }
            }
            System.out.println(r);
        }
    }
}
