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
public class CowsInARow2002 {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        int n=leer.nextInt();
        int a[]=new int[n];
        for (int i = 0; i < n; i++) {
            a[i]=leer.nextInt();
        }
        int num;
        int cont =0;
        int dif=0;
        int numdif=-1;
        int max=0;
        for (int i = 0; i < n; i++) {
            numdif=-1;
            cont=1;
            for (int j = i+1; j < n; j++) {
                if(a[j]!=a[i]){
                    if(numdif==-1){
                        numdif=a[j];
                    }else{
                        if(numdif!=a[j]){
                            j=n;
                            break;
                        }
                    }
                }else{
                    cont++;
                }
            }
            if(cont>max){
                max=cont;
            }
        }
        System.out.println(max);
    }
}
