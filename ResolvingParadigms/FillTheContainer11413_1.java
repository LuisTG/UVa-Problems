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
public class FillTheContainer11413_1 {
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
            int aux=0;
            while(inf<=sup){
                //System.out.println(inf+" "+sup);
                int x = (sup + inf) / 2;
                if(llenar(ar,x,k)){
                    //System.out.println("esta x"+x);
                    aux=x;
                    sup=x-1;
                }else{
                    inf=x+1;
                }
                //x=(inf+sup)/2;
            }
            System.out.println(aux);
        }
    }

    public static boolean llenar(int ar[], int cap, int cont) {
        int c=1;
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
                //if(cap==5)
                //System.out.println("ar "+ar[i]);
                cc=cap;
            }
            cc-=ar[i];
        }
        //if(cap==5) System.out.println("c "+c);
        return true;
    }
}
