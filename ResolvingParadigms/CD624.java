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
public class CD624 {
    static class par{
        String s;
        int a;

        public par(String s, int a) {
            this.s = s;
            this.a = a;
        }

        public par() {
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int n=leer.nextInt();
            int k=leer.nextInt();
            int ar[]=new int[k];
            for (int i = 0; i < k; i++) {
                ar[i]=leer.nextInt();
            }
            par mayor=fun(-1, ar,n,0,"",k);
            String s[]=mayor.s.substring(1).split(":");
            for (int i = 0; i < s.length; i++) {
                System.out.print(s[i]+" ");
            }
            System.out.println("sum:"+mayor.a);
        }
    }
    
    static par fun(int ind, int ar[], int n, int acum, String s, int k){
        if(ind>=k) return new par(s,acum);
        if(acum==n) {
            return new par(s,acum);
        }
        if(acum>n){
            return new par("",0);
        }
        par mayor=new par(s,acum);
        par aux;
        for (int i = ind+1; i < ar.length; i++) {
            aux=fun(i, ar, n,acum+ar[i],s+":"+ar[i],k);
            mayor=max(mayor,aux);
        }
        return mayor;
    }
    
    static par max(par a, par b){
        if(a.a!=b.a){
            if(a.a>b.a) return a;
            else return b;
        }else{
            if(a.s.split(":").length>b.s.split(":").length){
                return a;
            }else{
                return b;
            }
        }
    }
}
