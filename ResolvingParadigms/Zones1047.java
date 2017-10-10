/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class Zones1047 {
    
    static class par{
        boolean ar[];
        int p;

        public par(int n) {
            ar=new boolean[n];
        }
        
    }
    static ArrayList<par> array;
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n,sel;
        n=leer.nextInt();
        sel=leer.nextInt();
        int casos=1;
        while(n!=0 && sel!=0){
            int cus[]=new int[n];
            for (int i = 0; i < n; i++) {
                cus[i]=leer.nextInt();
            }
            int m=leer.nextInt();
            array=new ArrayList<>();
            int aux;
            for (int i = 0; i < m; i++) {
                aux=leer.nextInt();
                par ar=new par(n);
                for (int j = 0; j < aux; j++) {
                    ar.ar[leer.nextInt()-1]=true;
                }
                ar.p=leer.nextInt();
                array.add(ar);
            }
            int lim=(int)Math.pow(2, n);
            par max=fun(cus,1,sel,n);
            for (int i = 2 ; i < lim; i++) {
                par me=fun(cus,i,sel,n);
                //if(i==10) imprimir(me);
                max=mayor(max,me);
            }
            System.out.println("Case Number  "+casos);
            System.out.println("Number of Customers: "+max.p);
            System.out.print("Locations recommended: ");
            boolean band=false;
            for (int i = 0; i < n; i++) {
                if(max.ar[i]){
                    if(band)
                        System.out.print(" "+(i+1));
                    else
                        System.out.print((i+1));
                    band=true;
                }
            }
            System.out.println("");
            System.out.println("");
            n=leer.nextInt();
            sel=leer.nextInt();
            casos++;
        }
    }
    
    static void imprimir(par a){
        for (int i = 0; i < a.ar.length; i++) {
            System.out.print(a.ar[i]+" ");
        }
        System.out.println(a.p);
        
    }
    
    public static par mayor(par a, par b){
        if(a.p!=b.p){
            if(a.p>b.p) return a;
            else return b;
        }else{
           /* if(a.p==6 && a.p==b.p){
                for (int i = 0; i < a.ar.length; i++) {
                    System.out.print(a.ar[i]+" ");
                }
                System.out.println("");
                for (int i = 0; i < a.ar.length; i++) {
                    System.out.print(b.ar[i]+" ");
                }
                System.out.println("");
            }*/
            for (int i = 0; i < a.ar.length; i++) {
                if(a.ar[i]!=b.ar[i]){
                    if(a.ar[i]) return a;
                    else return b;
                }
            }
        }
        return a;
    }
    
    public static par fun(int ar[],int x, int num, int tam){
        int dob=x;
        int cont=0;
        int aux=0;
        int sel=0;
        par a=new par(tam);
        while(x>0 && sel<num){
            if((x&1)==1){
                aux+=ar[cont];
                sel++;
                a.ar[cont]=true;
                //if(dob==10) System.out.println(ar[cont]+" bueno "+aux);
            }
            cont++;
            x=x>>1;
        }
        if(sel!=num){
            par xx=new par(tam);
            xx.p=-1;
            return xx;
        }
        //if(dob==10) System.out.println("hola "+aux);
        int s=0;
        for (int i = 0; i < array.size(); i++) {
            s=0;
            for (int j = 0; j < tam; j++) {
                if(a.ar[j]==true){
                    if(array.get(i).ar[j]==true){
                        s++;
                                        if(s>1){
                    //if(dob==3) System.out.print(i+" ");
                    aux-=array.get(i).p;
                }
                    }
                }
            }
        }
        //System.out.println("");
        a.p=aux;
        return a;
    }
}
