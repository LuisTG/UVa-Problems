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
public class Area10589 {

    static class point {
        double x, y;

        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
    }

    static int insideCircle(point p, point c, double r) { // all integer version
        double dx = p.x - c.x, dy = p.y - c.y;
        double Euc = dx * dx + dy * dy, rSq = r * r; // all integer
        return Euc < rSq ? 0 : Euc == rSq ? 1 : 2;
    }

    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n;
        double a;
        n=leer.nextInt();
        a=leer.nextDouble();
        while(n!=0 && a!=0){
            int cont=0;
            point cib=new point(0,0);
            point cdb=new point(a,0);
            point cdt=new point(a,a);
            point cit=new point(0,a);
            double x,y;
            for (int i = 0; i < n; i++) {
                x=leer.nextDouble();
                y=leer.nextDouble();
                point ar= new point(x,y);
                if(insideCircle(ar,cib,a)<2 && insideCircle(ar,cdb,a)<2 && insideCircle(ar,cdt,a)<2 && insideCircle(ar,cit,a)<2 ){
                    cont++;
                }
            }
           // System.out.println("cont"+ cont);
            System.out.printf("%.5f\n",(cont*(a*a)/n));
           n=leer.nextInt();
           a=leer.nextDouble(); 
        }
    }
}
