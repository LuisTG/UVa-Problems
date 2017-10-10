/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.ArrayList;
import java.util.Scanner;

public class PackingPolygons10005 {
    static class point{
        double x,y;

        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    static boolean circle2PtsRad(point p1, point p2, double r) {
        double d2 = (p1.x - p2.x) * (p1.x - p2.x)
                + (p1.y - p2.y) * (p1.y - p2.y);
        double det = r * r / d2 - 0.25;
        if (det < 0.0) {
            return false;
        }
        double h = Math.sqrt(det);
        c.x = (p1.x + p2.x) * 0.5 + (p1.y - p2.y) * h;
        c.y = (p1.y + p2.y) * 0.5 + (p2.x - p1.x) * h;
        return true;
    }
    
    static boolean insideCircle(point p, point c, double r) { // all integer version
        double dx = p.x - c.x, dy = p.y - c.y;
        double Euc = dx * dx + dy * dy, rSq = r * r; // all integer
        return Euc < rSq ? true : Euc == rSq ? true : false;
    }

    static point c=new point(0,0);
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n!=0){
            point ar[]=new point[n];
            for (int i = 0; i < n; i++) {
                ar[i]=new point(leer.nextDouble(),leer.nextDouble());
            }
            double rad=leer.nextDouble();
            ArrayList<point> al=new ArrayList<>();
            for (int i = 0; i < n-1; i++) {
                for (int j = i+1; j < n; j++) {
                    if(circle2PtsRad(ar[i],ar[j],rad)){
                        al.add(new point(c.x,c.y));
                    }
                    if (circle2PtsRad(ar[j], ar[i], rad)) {
                        al.add(new point(c.x, c.y));
                    }
                }
            }
            int cont;
            boolean band=false;
            for (int i = 0; i < al.size(); i++) {
                cont=0;
                for (int j = 0; j < n; j++) {
                    if(!insideCircle(ar[j],al.get(i),rad)){
                        j=n;
                        break;
                    }else
                    cont++;
                }
                if(cont==n){
                    band=true;
                    i=al.size();
                    break;
                }
            }
            if(band) System.out.println("The polygon can be packed in the circle.");
            else System.out.println("There is no way of packing that polygon.");
            n=leer.nextInt();
        }
    }
}
