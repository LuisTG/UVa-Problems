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
public class TheMonkeyandTheOiled12032 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int c=leer.nextInt();
        for (int m = 1; m <=c ; m++){
            int n=leer.nextInt();
            int ar[]=new int[n];
            long sup=0;
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
                sup+=ar[i];
            }
            long inf=1;
            long x, aux=0;
            while(inf<=sup){
                x=(inf+sup)/2;
                if(fun(ar,x)){
                    aux=x;
                    sup=x-1;
                }else{
                    inf=x+1;
                }
            }
            System.out.println("Case "+m+": "+aux);
        }
    }
    
    public static boolean fun(int ar[], long x){
        if(ar[0]>x) return false;
        if(ar[0]==x) x=x-1;
        for (int i = 1; i < ar.length; i++) {
            if((ar[i]-ar[i-1])>x) return false;
            if((ar[i]-ar[i-1])==x) x=x-1;
        }
        return true;
    }
}
