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
public class ASpecialDay3412 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n;
        while(true){
            n=leer.nextInt();
            String s=Integer.toBinaryString(n);
            System.out.println(s);
        }
        /*int n=leer.nextInt();
        int ack=leer.nextInt();
        int clas[]=new int[n];
        for (int i = 0; i < n; i++) {
            clas[i]=leer.nextInt();
        }
        int max=0;
        int ack2;
        for (int i = 0; i < n; i++) {
            ack2=ack;
            for (int j = i; j < n ; j++) {
                if(ack2>=clas[j]){
                    ack2-=clas[j];
                }else{
                    j=n;
                }
            }
            max=Math.max(max, ack-ack2);
        }
        System.out.println(max);*/
    }
}
