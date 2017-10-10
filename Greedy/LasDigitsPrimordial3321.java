/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class LasDigitsPrimordial3321 {
    
    static boolean bs[];
    static int pos[];
    static long sieveSize;
    static ArrayList<Long> ar;        
    static void sieve(long upperbound){
        sieveSize=upperbound+1;
        bs=new boolean[(int)sieveSize+1];
        pos=new int[(int)sieveSize+1];
        ar=new ArrayList<>();
        int cont=-1;
        for (long i = 2; i <= sieveSize; i++) {
            if(!bs[(int) i]){
                for (long j = i*i; j <= sieveSize; j+=i) {
                    bs[(int) j]=true;
                }
                cont++;
                ar.add(i);
            }
            pos[(int)i]=cont;
        }
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        long mod=(long)Math.pow(10, 10);
        sieve(1000000);
        long result[]=new long[ar.size()];
        result[0]=ar.get(0);
        for (int i = 1; i < ar.size(); i++) {
            result[i]=(result[i-1]*ar.get(i))%mod;
            //System.out.println(result[i]);
        }
        int n;
        while(casos-->0){
            n=leer.nextInt();
            if(n<29)
            System.out.println(result[pos[n]]);
            else
                System.out.printf("%010d\n",result[pos[n]]);
        }
    }
}
/*
 223092870
6469693230
560490130
 */