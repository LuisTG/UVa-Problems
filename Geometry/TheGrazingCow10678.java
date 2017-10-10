/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.Scanner;

public class TheGrazingCow10678 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        double pi=Math.PI;
        int n=leer.nextInt();
        while(n-->0){
            double a,b,c,area;
            a=leer.nextDouble();
            b=leer.nextDouble();
            c=b/2;
            b=Math.sqrt(((b/2)*(b/2))-((a/2)*(a/2)));
            area=(c)*b*pi;
            //System.out.println(b+" "+(a/2)+" "+pi);
            System.out.printf("%.3f\n",area);
        }
    }
}
