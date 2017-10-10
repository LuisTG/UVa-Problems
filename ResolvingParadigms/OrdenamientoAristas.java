/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class OrdenamientoAristas {
    
    static class arista implements Comparable<arista>{
        int NO,ND,P;

        public arista(int NO,int ND, int P) {
            this.NO=NO;
            this.ND = ND;
            this.P = P;
        }

        @Override
        public int compareTo(arista o) {
            if(this.P<o.P) return -1;
            else if(this.P>o.P) return 1;
            else return 0;
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int N = leer.nextInt();
        int M = leer.nextInt();
        ArrayList<arista> lista=new ArrayList<>();
        int NO,ND,P;
        for (int i = 0; i < M; i++) {
            NO=leer.nextInt();
            ND=leer.nextInt();
            P=leer.nextInt();
            lista.add(new arista(NO,ND,P));
        }
        Collections.sort(lista);
    }  
}