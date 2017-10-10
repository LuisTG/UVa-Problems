/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Scanner;

public class ExpertEnough1237 {
    
    static class car{
        String name;
        int x,y;

        public car(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        boolean band=false;
        while(casos-->0){
            int n=leer.nextInt();
            car ar[]=new car[n];
            for (int i = 0; i < n; i++) {
                ar[i]=new car(leer.next(), leer.nextInt(), leer.nextInt());
            }
            int q=leer.nextInt();
            String s;
            if(band){
                System.out.println("");
            }
            band=true;
            for (int i = 0; i < q; i++) {
                int x=leer.nextInt();
                int cont=0;
                s="";
                for (int j = 0; j < n && cont<2; j++) {
                    if(x>=ar[j].x && x<=ar[j].y){
                        cont++;
                        s=ar[j].name;
                    }
                }
                if(cont==1){
                    System.out.println(s);
                }else{
                    System.out.println("UNDETERMINED");
                }
            }
        }
    }
}
