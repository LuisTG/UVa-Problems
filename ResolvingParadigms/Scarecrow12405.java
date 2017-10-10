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
public class Scarecrow12405 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        for (int i = 1; i <= casos; i++) {
            int tam=leer.nextInt();
            String s=leer.next();
            int cont=0;
            for (int j = 0; j < tam;) {
                if(s.charAt(j)=='.'){
                    cont++;
                    j+=3;
                }else{
                    j++;
                }
            }
            System.out.println("Case "+i+": "+cont);
        }
    }
}
