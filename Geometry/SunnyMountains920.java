/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.Scanner;
import java.util.Arrays;


public class SunnyMountains920 {
    
    static class puntos implements Comparable<puntos>{
        double x;
        double y;

        public puntos(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(puntos o) {
            return (int)(o.x-this.x);
        }        
    }
    
    public static double alt(puntos a, puntos b, double alt){
        double dx=(b.x-a.x);
        double xs=-a.x;
        double dy=(b.y-a.y);
        double ys=-a.y;
        return ((alt*dx)+(ys*dx)-(xs*dy))/(dy);
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int p=leer.nextInt();
            puntos ar[]=new puntos[p];
            for (int i = 0; i < p; i++) {
                ar[i]=new puntos(leer.nextDouble(),leer.nextDouble());
            }
            Arrays.sort(ar);
            double alm=0;
            double result=0;
            double xa;
            for (int i = 1; i < p; i++) {
                //System.out.println("p "+ar[i].x+" "+ar[i].y);
                if(ar[i].y>alm){
                    xa=alt(ar[i],ar[i-1],alm);
                  //  System.out.println(xa);
                    result+=Math.hypot(ar[i].x-xa, ar[i].y-alm);
                    alm=ar[i].y;
                }
                //System.out.println(result);
            }
            System.out.printf("%.2f\n",result);
        }
    }
 
}
