/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Arrays;
import java.util.Scanner;

public class ExactSum11057 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int n=leer.nextInt();
            int ar[]=new int[n];
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
            }
            int p=leer.nextInt();
            int s=p/2;
            Arrays.sort(ar);
            int pos=Arrays.binarySearch(ar, s);
            
            if(pos<0){
                //System.out.println("pos antes"+pos);
                pos=pos*-1-1;
            }
           /* for (int i = 0; i < n; i++) {
                System.out.print(ar[i]+" ");
            }
            System.out.println("");
            System.out.println(s+" "+pos);*/
            int aux=ar[pos];
            ar[pos]=0;
            int pos2=Arrays.binarySearch(ar, p-aux);
            ar[pos]=aux;
            boolean band=true;
            while(pos2<0 || pos2==pos){
                pos--;
                aux=ar[pos];
                ar[pos]=0;
                pos2=Arrays.binarySearch(ar, p-aux);
                ar[pos]=aux;
            }
            if(ar[pos]>ar[pos2]){
                    System.out.println("Peter should buy books whose prices are "+ar[pos2]+" and "+ar[pos]+".");
            }else{
                                    System.out.println("Peter should buy books whose prices are "+ar[pos]+" and "+ar[pos2]+".");
            }
            System.out.println("");
        }
    }
}
