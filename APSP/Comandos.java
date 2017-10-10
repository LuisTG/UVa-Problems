/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;

public class Comandos {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        for (int i = 1; i <= casos; i++) {
            int n=leer.nextInt();
            int en=leer.nextInt();
            int floyd[][]=new int[n][n];
            int a,b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    floyd[j][k]=100000000;
                }
                floyd[j][j]=0;
            }
            for (int j = 0; j < en; j++) {
                a=leer.nextInt();
                b=leer.nextInt();
                floyd[a][b]=1;
                floyd[b][a]=1;
            }
            int in=leer.nextInt();
            int fin=leer.nextInt();
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        floyd[k][l]=Math.min(floyd[k][l], floyd[k][j]+floyd[j][l]);
                    }
                }
            }
            int resp=0;
            for (int j = 0; j < n; j++) {
                    resp=Math.max(resp, floyd[in][j]+floyd[j][fin]);
            }
            System.out.println("Case "+i+": "+resp);
        }   
    }
}
