/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class GCDLongestCommonsubsecuence2897 {
    static int dat[][];
    
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
        
    static int fun(int num, ArrayList<Integer> ar){
        int cont=0;
        ArrayList<Integer> a=new ArrayList<>();
        while(num>0){
            if((num&1)==1){
                for (int i = 0; i < a.size(); i++) {
                    if(dat[a.get(i)][ar.get(cont)]!=1){
                        return 0;
                    }
                }
                a.add(ar.get(cont));
            }
            cont++;
            num=num>>1;
        }
        return a.size();
    }
    
    public static void main(String[] args) {
        dat=new int[27][27];
        for (int i = 1; i < 26; i++) {
            for (int j = i; j < 27; j++) {
                int r=gcd(i,j);
                dat[i][j]=r;
                dat[j][i]=r;
            }
        }
        /*for (int i = 1; i < 26; i++) {
            for (int j = 1; j < 26; j++) {
                System.out.print(dat[i][j]+" ");
            }
            System.out.println("");
        }*/
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        boolean ent[]=new boolean[27];
        ArrayList<Integer> en=new ArrayList<>();
        int e[]=new int[n];
        int contT=0;
        int num;
        for (int i = 0; i < n; i++) {
            num = leer.nextInt();
            if (num == 1) {
                contT++;
                ent[num]=true;
            }  else if (num == 13 && !ent[num]) {
                contT++;
                ent[num]=true;
            } else if (num == 17 && !ent[num]) {
                contT++;
                ent[num]=true;
            } else if (num == 19 && !ent[num]) {
                contT++;
                ent[num]=true;
            } else {
                if (num == 23 && !ent[num]) {
                    contT++;
                    ent[num]=true;
                }else{
                    if(!ent[num]){
                        ent[num]=true;
                        en.add(num);
                    }
                }
            }
        }
        int a=(int)Math.pow(2, en.size());
        int max=0;
        for (int i = 1; i < a; i++) {
            max=Math.max(max, fun(i,en));
        }
        System.out.println((max+contT));
    }
}
