/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Scanner;

public class TIMSKO2652 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int g=leer.nextInt();
        int b=leer.nextInt();
        int k=leer.nextInt();
        
        int maxg,gf=0,bf=0;
        maxg=g/2;
        int eq=0;
        if(g/2>b){
            eq=b;
            gf=g-(b*2);
        }else{
            eq=g/2;
            bf=b-(g/2);
        }
        if((bf+gf)>=k){
            System.out.println(eq);
        }else{
            //System.out.println(eq+" "+bf+" "+gf);
            k=k-bf-gf;
            int res=(int)Math.ceil(k/3.0);
            if(res>eq) System.out.println("0");
            else
                System.out.println((eq-res));
        }
        
    }
}
