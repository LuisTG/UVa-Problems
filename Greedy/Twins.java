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
public class Twins {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        int cont=0;
        int ar[]=new int[n];
        for (int i = 0; i < n; i++) {
            ar[i]=leer.nextInt();
            cont+=ar[i];
        }
        Arrays.sort(ar);
        int mon=0;
        int pos=n-1;
        int res=0;
        while(cont>=mon){
            mon+=ar[pos];
            cont-=ar[pos];
            res++;
            pos--;
        }
        System.out.println(res);
    }
}
