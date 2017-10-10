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
public class DigitSum2973 {
   /* static long x,y;
    
    public static void sum(int n,int s[]){
        long a=0,b=0;
        int cont=0;
        while(cont<s.length){
            if((n&1)==1){
                a=a*10+s[cont];
            }else{
                b=b*10+s[cont];
            }
            cont++;
            n=n>>1;
        }
        System.out.println(a+" "+b);
        if((a+b)<(x+y)){
            x=a;
            y=b;
        }
    }*/
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n!=0){
            int aa[]=new int[n];
            int cont=0;
            for (int i = 0; i < n; i++) {
                aa[i]=leer.nextInt();
                if(aa[i]==0) cont++;
            }
            int a[]=new int[n];
            Arrays.sort(aa);
            a[0]=aa[cont];
            a[1]=aa[cont+1];
            for (int i = 0; i < cont; i++) {
                a[i+2]=0;
            }
            for (int i = cont+2; i < n; i++) {
                a[i]=aa[i];
            }
            long x=0,y=0;
            for (int i = 0; i < n; i++) {
                if(i%2==0){
                    x=x*10+a[i];
                }else{
                    y=y*10+a[i];
                }
            }
            System.out.println((x+y));
            n=leer.nextInt();
        }
    }
}
