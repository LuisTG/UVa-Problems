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
public class Matriorskas {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            String s[]=leer.nextLine().split(" ");
            int ar[]=new int[s.length+5];
            int pos=0;
            boolean band=true;
            for(int i=0; i<s.length;i++){
                int x=Integer.parseInt(s[i]);
                if(x<0){
                    ar[pos++]=x;
                }else{
                    int pos2=pos-1;
                    int cont=0;
                    while(ar[pos2]>0){
                        cont+=ar[pos2--];
                    }
                    if(cont>=x){
                        band=false;
                    }else{
                        if(Math.abs(ar[pos2])!=x){
                            band=false;
                        }else{
                            ar[pos2++]=x;
                            pos=pos2;
                        }
                    }
                }
            }
            if(band){
                System.out.println(":-) Matrioshka!");
            }else{
                System.out.println(":-( Try again.");
            }
        }
    }
}
