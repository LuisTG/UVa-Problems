/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class TheEasiestWay11207 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n=leer.nextInt();
        while(n!=0){
            double mayor=0;
            int ind=0;
            double a,b;
            double x,y,z,zz;
            for (int i = 0; i < n; i++) {
                a=leer.nextDouble();
                b=leer.nextDouble();
                x=a/4;
                x=Math.min(x, b);
                y=b/4;
                y=Math.min(y, a);
                z=a/2;
                zz=b/2;
                z=Math.min(z, zz);
                x=Math.max(x, y);
                y=Math.max(z, x);
                if(mayor<y){
                    mayor=y;
                    ind=i+1;
                }
            }
            System.out.println(ind);
            n=leer.nextInt();
        }
    }
}
