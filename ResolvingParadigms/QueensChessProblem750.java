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
public class QueensChessProblem750 {
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
       if(c==8 && row[b]==a){
           System.out.printf("%2d      %d", ++lineCounter, row[0] + 1);
           for (int i = 1; i < 8; i++) {
                   System.out.print(" "+(row[i]+1));
           }
           System.out.println("");
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
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            a=leer.nextInt()-1;
            b=leer.nextInt()-1;
            row=new int[8];
            lineCounter=0;
            System.out.println("SOLN       COLUMN");
            System.out.println(" #      1 2 3 4 5 6 7 8");
            System.out.println("");
            backtrack(0);
            if(casos!=0) System.out.println("");
            
        }
    }
}
