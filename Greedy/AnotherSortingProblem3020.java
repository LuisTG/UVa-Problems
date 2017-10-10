/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author luis
 */
public class AnotherSortingProblem3020 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int n=leer.nextInt();
            int ar[]=new int[n];
            int ar2[]=new int[n];
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
                ar2[i]=ar[i];
            }
            Arrays.sort(ar2);
            int cos=0;
            for (int i = 0; i < n; i++) {
                if(ar2[i]!=ar[i]){
                    for (int j = 0; j < n; j++) {
                        if(ar2[i]==ar[j]){
                            cos+=ar2[i]*Math.abs(j-i);
                            int x=ar[j];
                            ar[j]=ar[i];
                            ar[i]=x;
                            j=n;
                        }
                    }
                }
            }
            System.out.println(cos);
        }
    }
}
