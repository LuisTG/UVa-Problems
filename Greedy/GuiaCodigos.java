
package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class GuiaCodigos {
    
    static class arista{
        int NO,ND,P;

        public arista(int NO,int ND, int P) {
            this.NO=NO;
            this.ND = ND;
            this.P = P;
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
    }  
}


/*
 LISTA DE ADYACENCIA
 * 
    static class par{
        int ND,P;

        public par(int ND, int P) {
            this.ND = ND;
            this.P = P;
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int N = leer.nextInt();
        int M = leer.nextInt();
        ArrayList<ArrayList<par>> lista=new ArrayList<>();
        /*Se inicializa el primer vector con sus
         respectivos vectores
        for (int i = 0; i < N; i++) {
            lista.add(new ArrayList<par>());
        }
        int NO,ND,P;
        for (int i = 0; i < M; i++) {
            NO=leer.nextInt();
            ND=leer.nextInt();
            P=leer.nextInt();
            lista.get(NO-1).add(new par(ND-1,P));
             lista.get(ND-1).add(new par(NP-1,P)); 
             * Si se trata de un grafo no dirigido
        }
    }  
 */


/*
 * MATRIZ DE ADYACENCIA CON HASHMAP
   public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int N = leer.nextInt();
        int M = leer.nextInt();
        int matriz[][]=new int[N][N];
        int indice=0;
        String NO,ND;
        int INO,IND,P;
        HashMap<String,Integer> hash=new HashMap<>();
        for (int i = 0; i < M; i++) {
            NO=leer.next();
            ND=leer.next();
            P=leer.nextInt();
            if(!hash.containsKey(NO)){
                hash.put(NO, indice++);
            }
            if(!hash.containsKey(ND)){
                hash.put(ND, indice++);
            }
            INO=hash.get(NO);
            IND=hash.get(ND);
            matriz[INO][IND] = P;
            /*matriz[IND][INO] = P; //en caso de ser no dirigido
            
        }
    }  
 */



  /*  
   * MATRIZ DE ADYACENCIA
   * public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println(('Z'-'A'));
        int N = leer.nextInt();
        int M = leer.nextInt();
        int NO1, ND1, P1;
        int matriz[][]=new int[N][N];
        for (int i = 0; i < M; i++) {
            NO1=leer.nextInt();
            ND1=leer.nextInt();
            P1=leer.nextInt();
            matriz[NO1][ND1] = P1;
            matriz[ND][NO] = P; 
              En caso de ser un grafo no dirigido se
              deben guardar ambas aristas A->C y C->A
        String NO,ND;
        int P;
        NO=leer.next();
        ND=leer.next();
        P=leer.nextInt();
        matriz[NO.charAt(0)-'A'][ND.charAt(0)-'A'] = P;
        
        }
    }
}*/
