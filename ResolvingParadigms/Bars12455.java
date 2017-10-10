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
public class Bars12455 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int n=leer.nextInt();
            int x =leer.nextInt();
            int ar[]=new int[x];
            for (int i = 0; i < x; i++) {
                ar[i]=leer.nextInt();
            }
            int lim=(int)Math.pow(2, x);
            boolean band=false;
            for (int i = 0; i < lim && band==false; i++) {
                band=fun(ar,i,n);
            }
            if(band) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    
    public static boolean fun(int ar[],int x, int n){
        int cont=0;
        int aux=0;
        while(x>0){
            if((x&1)==1){
                aux+=ar[cont];
            }
            cont++;
            x=x>>1;
        }
        if(aux==n) return true;
        return false;
        
    }
}
