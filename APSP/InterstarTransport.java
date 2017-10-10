/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;

public class InterstarTransport {

    static int p[][];

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        int en = leer.nextInt();
        int floyd[][] = new int[n][n];
        p = new int[n][n];
        int cant[][] = new int[n][n];
        int c;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                floyd[j][k] = 100000000;
                p[j][k] = j;
                cant[j][k] = 1;
            }
            floyd[j][j] = 0;
        }
        String a, b;
        for (int j = 0; j < en; j++) {
            a = leer.next();
            b = leer.next();
            c = leer.nextInt();
            floyd[a.charAt(0) - 'A'][b.charAt(0) - 'A'] = c;
            floyd[b.charAt(0) - 'A'][a.charAt(0) - 'A'] = c;
            cant[a.charAt(0) - 'A'][b.charAt(0) - 'A'] += 1;
            
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (floyd[i][k] + floyd[k][j] < floyd[i][j]) {
                        floyd[i][j] = floyd[i][k] + floyd[k][j];
                        p[i][j] = p[k][j];
                        cant[i][j]=cant[i][k]+cant[k][j]+1;
                    }else{
                        if(floyd[i][k] + floyd[k][j] == floyd[i][j] && cant[i][k]+cant[k][j]+1<cant[i][j]){
                            p[i][j] = p[k][j];
                            cant[i][j]=cant[i][k]+cant[k][j]+1;
                        }
                    }
                }
            }
        }
   /*     for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(p[i][j] + " ");
            }
            System.out.println("");
        }*/
        int x = leer.nextInt();
        String y, z;
        String aux[];
        for (int i = 0; i < x; i++) {
            y = leer.next();
            z = leer.next();
            aux=((y.charAt(0) - 'A')+printPath(y.charAt(0) - 'A', z.charAt(0) - 'A')).split(" ");
            for (int j = 0; j < aux.length; j++) {
                if(j==0) System.out.print((char)(Integer.parseInt(aux[j])+'A'));
                    else
                System.out.print(" "+(char)(Integer.parseInt(aux[j])+'A'));
            }
            System.out.println("");
        }
    }

    static String printPath(int i, int j) {
        String s = "";
        if (i != j) {
            s += printPath(i, p[i][j]) + " " + j;
        }
        return s;
    }
}


/* for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (floyd[k][j] + floyd[j][l] < floyd[k][l]) {
                            floyd[k][l] = floyd[k][j] + floyd[k][l];
                            p[k][l] = p[j][k]; // update the parent matrix
                            cant[k][l]=cant[j][k]+1;
                        }/*else{
                            if (floyd[k][j] + floyd[j][l] == floyd[k][l] && cant[j][k]<cant[k][l]) {
                                floyd[k][l] = floyd[k][j] + floyd[k][l];
                                p[k][l] = p[j][k]; 
                                cant[k][l]=cant[j][k]+1;
                        }
                        }
                    }
                }
            }*/