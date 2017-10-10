/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Scanner;


public class PrimeRingProblem524 {
    static boolean primes[];
    static int mat[];
    static void era(){
        primes=new boolean[40];
        primes[0]=primes[1]=true;
        for (int i = 2; i < 40; i++) {
            if(!primes[i]){
                for (int j = i*i; j < 40; j+=i) {
                    primes[j]=true;
                }
            }
        }
    }
    static void create(int pos, int n){
        if(pos==n){
            if(!primes[mat[0]+mat[n-1]]){
                System.out.print(mat[0]);
                for (int i = 1; i < n; i++) {
                    System.out.print(" "+mat[i]);
                }
                System.out.println("");
            }
        }
        for (int i = 2; i < n+1; i++) {
            if(!primes[i+mat[pos-1]]){
                boolean ban=true;
                for (int j = 0; j < pos; j++) {
                    if(mat[j]==i)
                        ban=false;
                }
                if(ban){
                    mat[pos]=i;
                    create(pos+1,n);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int cont=1;
        era();
        boolean band=false;
        while(leer.hasNext()){
            int n=leer.nextInt();
            mat=new int[n];
            mat[0]=1;
            if(band)
                System.out.println("");
            System.out.println("Case "+cont+":");
            if(n!=0)
                create(1,n);
            cont++;
            band=true;
        }
    }
}
