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
public class FillContainers {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int n=leer.nextInt();
            int k=leer.nextInt();
            int ar[]=new int[n];
            int sup=0;
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
                sup+=ar[i];
            }
            int inf=sup/k;
            int x = (sup + inf) / 2;
            int aux=0;
            while(inf<=sup){
                if(llenar(ar,x,k)){
                    aux=x;
                    sup=x-1;
                }else{
                    inf=x+1;
                }
                
            }
            System.out.println(aux);
        }
    }

    public static boolean llenar(int ar[], int cap, int cont) {
        int c=0;
        int cc=cap;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i]>cap){
                return false;
            }
            if(ar[i]>cc){
                if(c==cont){
                    return false;
                }
                c++;
                cc=c;
            }
            c-=ar[i];
        }
        return true;
    }
}

