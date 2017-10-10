/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class SumItUp574 {
    
    static class ob implements Comparable<ob>{
        ArrayList<Integer> ar;

        public ob(ArrayList<Integer> ar) {
            this.ar = ar;
        }

        @Override
        public int compareTo(ob o) {
            int min=Math.min(this.ar.size(), o.ar.size());
            for (int i = 0; i < min; i++) {
                if(this.ar.get(i)!=o.ar.get(i)){
                    return o.ar.get(i)-this.ar.get(i);
                }
            }
            
            if(min==this.ar.size()){
                return 1;
            }else{
                return -1;
            }
        }
        
    }
    
    static ArrayList<ob> res;
        public static void fun(int ar[],int x, int n){
        int cont=0;
        int aux=0;
        int cont2=0;
        ArrayList<Integer> a=new ArrayList<>();
        while(x>0){
            if((x&1)==1){
                aux+=ar[cont];
                a.add(ar[cont]);
                cont2++;
            }
            cont++;
            x=x>>1;
        }
        if(aux==n){
            for (int i = 0; i < res.size(); i++) {
                int min=Math.min(res.get(i).ar.size(),cont2);
                boolean band=false;
                for (int j = 0; j < min; j++) {
                    if(res.get(i).ar.get(j)!=a.get(j)){
                        band=true;
                    }
                }
                if(band==false){
                    return;
                }
            }
            res.add(new ob(a));
        } 
    }
        public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int t=leer.nextInt();
        int n=leer.nextInt();
        while(t!=0 && n!=0){
            res=new ArrayList<>();
            int ar[]=new int[n];
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
            }
            int lim=(int)Math.pow(2, n);
            System.out.println("Sums of "+t+":");
            for (int i = 1; i < lim; i++) {
                fun(ar,i,t);
            }
            Collections.sort(res);
            if(res.isEmpty()){
                System.out.println("NONE");
            }else{
                for (int i = 0; i < res.size(); i++) { 
                    for (int j = 0; j < res.get(i).ar.size(); j++) {
                    if (j == 0) {
                        System.out.print(res.get(i).ar.get(j));
                    } else {
                        System.out.print("+" + res.get(i).ar.get(j));
                    }
                }
                    System.out.println("");
            }
            }
            t=leer.nextInt();
            n=leer.nextInt();
        }
    }
}
