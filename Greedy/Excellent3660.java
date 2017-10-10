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
public class Excellent3660 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=leer.nextInt();
        }
        Arrays.sort(a);
        int min=3000000;
        for (int i = 0, j = n-1; i < j; j--, i++) {
            min=Math.min(min, a[i]+a[j]);
        }
        System.out.println(min);
    }
}
