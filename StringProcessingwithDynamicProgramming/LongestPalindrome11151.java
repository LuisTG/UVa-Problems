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
public class LongestPalindrome11151 {
    static int mat[][];
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=Integer.parseInt(leer.nextLine());
        while(casos-->0){
            mat=new int[1000][1000];
            String s=leer.nextLine();
            if(s.length()==0)
                System.out.println("0");
            else
            System.out.println(pal(0,s.length()-1,s));
        }
    }
    
    static int pal(int i, int j, String s){
        if(i==j) return 1;
        if(i+1==j){
            if(s.charAt(i)==s.charAt(j)){
                return 2;
            }else{
                return 1;
            }
        }
        if(mat[i][j]!=0)
            return mat[i][j];
        if(s.charAt(i)==s.charAt(j))
            return mat[i][j]=2+pal(i+1,j-1,s);
        else
        return mat[i][j]=Math.max(pal(i+1,j,s),pal(i,j-1,s));
    }
}
