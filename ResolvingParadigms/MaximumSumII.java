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
public class MaximumSumII {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n!=0){
            int aux;
            int cont=0;
            for(int i=0; i<n;i++){
                aux=leer.nextInt();
                if(aux!=0){
                   if(cont==0)
                        System.out.print(aux);
                   else
                        System.out.print(" "+aux);
                   cont++;
                }
            }
            if(cont==0){
                System.out.println("0");
            }else{
                System.out.println("");
            }
            n=leer.nextInt();
        }
    }
}
