/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringProcessingwithDynamicProgramming;

import java.util.Scanner;

/**
 *
 * @author luis
 */

public class MakePalindrome10453 {
    static class par{
        int t;
        StringBuilder f,s;

        public par() {
            t=0;
            f=new StringBuilder();
            s=new StringBuilder();
        }
        
    }
    static int memo[][];
    static char INSERT_LEFT ='l';
    static char INSERT_RIGHT ='r';
    static char NONE ='x';
    static char track[][];
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            memo=new int[1001][1001];
            track=new char [1001][1001];
            String s=leer.next();
            int x=minCost(0,s.length()-1,s);
            System.out.print(x+" ");
            construct(0,s.length()-1,s.toCharArray());
        }
    }
    
    static void construct(int i, int j, char text[]){
    char left[]=new char[1001];
    int pos = 0;
    while(i < j){
        if(track[i][j] == NONE){
            System.out.print(text[i]);
            left[pos++] = text[i];
            i++;j--;
        }
        else if(track[i][j] == INSERT_RIGHT){
            System.out.print(text[i]);
            left[pos++] = text[i];
            i++;
        }
        else{
            System.out.print(text[j]);
            left[pos++] = text[j];
            j--;
        }
    }

    if(i == j)
            System.out.print(text[i]);
    for(int k = pos-1; k>= 0; k--) System.out.print(left[k]);
        System.out.println("");
}
    
    static int minCost(int i, int j, String text){
        if(i >= j) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        if(text.charAt(i) == text.charAt(j)){
            track[i][j] = NONE;
            return memo[i][j] = minCost(i + 1, j - 1, text);
        }
        int a = minCost(i+1, j,text);
        int b = minCost(i, j-1,text);
        if(a < b) {
            track[i][j] = INSERT_RIGHT;
            return memo[i][j] = a  + 1;
        }
        track[i][j] = INSERT_LEFT;
        return memo[i][j] = b + 1;

    }
}
