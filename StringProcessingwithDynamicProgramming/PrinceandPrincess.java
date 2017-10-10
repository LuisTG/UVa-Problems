/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package StringProcessingwithDynamicProgramming;

import java.util.Scanner;

public class PrinceandPrincess {
    static int ar1[];
    static int ar2[];
static int lis( int arr[], int n ){
    int i, j, max = 0;
    int lis[] =new int[n];
    for (i = 0; i < n; i++ )
        lis[i] = 1;

    for (i = 1; i < n; i++ )
        for (j = 0; j < i; j++ ) 
            if ( arr[i] > arr[j] && lis[i] < lis[j] + 1)
                lis[i] = lis[j] + 1;

    for (i = 0; i < n; i++ )
        if (max < lis[i])
            max = lis[i];
 
    return max;
}
   
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        for (int i = 1; i <= casos; i++) {
            int n=leer.nextInt();
            int p=leer.nextInt();
            int q=leer.nextInt();
            ar1=new int[n*n+1];
            ar2=new int[q+1];
            
            for (int j = 0; j < p+1; j++) {
                ar1[leer.nextInt()]=j;
            }
            for (int j = 0; j < q+1; j++) {
                ar2[j]=ar1[leer.nextInt()];
            }
            int x=lis(ar2,q+1);
            System.out.println("Case "+i+": "+x);
        }        
    }
}
