/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Euler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class TheHouseOfSantaClaus {
    static int mat[][]=new int[6][6];
    static TreeSet<String> tr=new TreeSet<>();
    static int lim=8;
    public static void main(String[] args) {
        mat[1][2]=1;
        mat[1][3]=1;
        mat[1][5]=1;
        mat[2][5]=1;
        mat[2][3]=1;
        mat[2][1]=1;
        mat[5][1]=1;
        mat[5][2]=1;
        mat[5][3]=1;
        mat[5][4]=1;
        mat[3][1]=1;
        mat[3][2]=1;
        mat[3][5]=1;
        mat[3][4]=1;
        mat[4][3]=1;
        mat[4][5]=1;
        rec(1,"",0);
        while(!tr.isEmpty()){
            System.out.println(tr.pollFirst());
        }
    }
    
    static void rec(int u, String cad, int edge ){
        if(edge==lim){ 
            tr.add(cad+u);
        }
        for (int i = 1; i < 6; i++) {
            if(mat[u][i]>0){
                mat[u][i]=0;
                mat[i][u]=0;
                rec(i,cad+u,edge+1);
                mat[u][i]=1;
                mat[i][u]=1;
            }
        }
    }
}
