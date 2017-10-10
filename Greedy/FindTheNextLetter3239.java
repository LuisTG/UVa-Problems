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
public class FindTheNextLetter3239 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n-->0){
            int t=leer.nextInt();
            char a[]=leer.next().toCharArray();
            int x[]=new int[27];
            int res[]=new int[t];
            for (int i = t-1; i >-1; i--) {
                x[a[i]-'a']=i+1;
                boolean band=false;
                int max=1000000;
                for (int j = a[i]-'a'+1; j < 27; j++) {
                    if(x[j]!=0  && max>x[j]){
                        max=x[j];
                        res[i]=x[j];
                        band=true;
                    }
                }
                if(band==false){
                    res[i]=-1;
                }
            }
            for (int i = 0; i < t; i++) {
                if(i==0)
                    System.out.print(res[i]);
                else
                    System.out.print(" "+res[i]);
            }
            System.out.println("");
        }
    }
}
