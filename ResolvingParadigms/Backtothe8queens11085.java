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
public class Backtothe8queens11085 {
    
    static int row[], TC, a, b, lineCounter; // ok to use global variables
    static int result[][],  cont;
    
    static boolean place(int r, int c) {
        for (int prev = 0; prev < c; prev++) // check previously placed queens
        {
            if (row[prev] == r || (Math.abs(row[prev] - r) == Math.abs(prev - c))) {
                return false; // share same row or same diagonal -> infeasible
            }
        }
        return true;
    }
    
   static void backtrack(int c) {
       if(c==8){
           System.arraycopy(row, 0, result[cont], 0, 8);
           cont++;
           //System.out.println("");
       }
        for (int r = 0; r < 8; r++) // try all possible row
        {
            if (place(r, c)) { // if can place a queen at this col and row
                row[c] = r;
                backtrack(c + 1); // put this queen here and recurse
            }
        }
    }

    public static void main(String[] args) {
        row=new int[8];
        result=new int[92][8];
        cont=0;
        backtrack(0);
        Scanner leer=new Scanner(System.in);
        int casos=1;
        while(leer.hasNext()){
            int x[]=new int[8];
            for (int i = 0; i < 8; i++) {
                x[i]=leer.nextInt();
            }
            int min=10000;
            int c;
            for (int i = 0; i < 92; i++) {
                c=0;
                for(int j=0;j<8;j++){
                    if(result[i][j]!=(x[j]-1)){
                        c++;
                    }
                }
                min=Math.min(min, c);
            }
            System.out.println("Case "+casos+": "+min);
            casos++;
        }
    }
}
