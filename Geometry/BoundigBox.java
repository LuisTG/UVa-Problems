/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.Scanner;


public class BoundigBox {
    static class point{
        double x,y;

        public point(double x, double y) {
            this.x = x;
            this.y = y;
        }    

        public point() {
        }
    }
    
    static class line{
        double a,b,c;

        public line(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
    }
    
    static double dist(point a, point b){
        return Math.hypot(b.x-a.x,b.y-a.y);
    }
    
    static double area(double a,double b, double c){
        double s=(a+b+c)*0.5;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }
    
    static double rCircumCircle(double ab, double bc, double ca) {
return ab * bc * ca / (4.0 * area(ab, bc, ca)); }
    
    static double rCircumCircle(point a, point b, point c) {
    return rCircumCircle(dist(a, b), dist(b, c), dist(c, a)); }
    
    static double area(point a, point b, point c) {
    return area(dist(a, b), dist(b, c), dist(c, a)); }
    
    
    
    static point is_formCircle(double x1, double y1, double x2, double y2, double x3, double y3) {
    double h = calculateH(x1, y1, x2, y2, x3, y3);
    double k = calculateK(x1, y1, x2, y2, x3, y3);
    return new point(h,k);
    }
    
    static double calculateH(double x1, double y1, double x2, double y2, double x3, double y3) {
    double numerator = (x2*x2+y2*y2)*y3 - (x3*x3+y3*y3)*y2 - 
                      ((x1*x1+y1*y1)*y3 - (x3*x3+y3*y3)*y1) +
                      (x1*x1+y1*y1)*y2 - (x2*x2+y2*y2)*y1;
    double denominator = (x2*y3-x3*y2) -
                        (x1*y3-x3*y1) +
                        (x1*y2-x2*y1);
    denominator *= 2;
    return numerator / denominator;
}
    static double calculateK(double x1, double y1, double x2, double y2, double x3, double y3) {
        double numerator = x2*(x3*x3+y3*y3) - x3*(x2*x2+y2*y2) -
                          (x1*(x3*x3+y3*y3) - x3*(x1*x1+y1*y1)) +
                          x1*(x2*x2+y2*y2) - x2*(x1*x1+y1*y1);
        double denominator = (x2*y3-x3*y2) -
                            (x1*y3-x3*y1) +
                            (x1*y2-x2*y1);
        denominator *= 2;
        return numerator / denominator;
    }
    
    static class vec{
        double x,y;

        public vec(double x, double y) {
            this.x = x;
            this.y = y;
        }
        
    }
    
    static vec rotate(vec s,double radians){
        double COS = Math.cos(radians);
        double SIN = Math.sin(radians);
        return new vec((COS*s.x-SIN*s.y),
                        (SIN*s.x+COS*s.y));
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        double pi=Math.PI;
        int n=leer.nextInt();
        int casos=0;
        while(n!=0){
            point ar[] =new point[n];
            for (int i = 0; i < 3; i++) {
               ar[i]=new point(leer.nextDouble(),leer.nextDouble());
            }
            
            //double area=area(ar[0],ar[1],ar[2]);
            //double r=rCircumCircle(ar[0],ar[1],ar[2]);
            point centro=is_formCircle(ar[0].x,ar[0].y,ar[1].x,ar[1].y,ar[2].x,ar[2].y);
            double ang=2*pi/n;
            vec v=new vec(ar[0].x-centro.x,ar[0].y-centro.y);
            double minx = ar[0].x, miny = ar[0].y, maxx = ar[0].x, maxy = ar[0].y;
            for (int i = 1; i < n; i++) {
                v = rotate(v, ang);
                double ax = v.x + centro.x;
                double ay = v.y + centro.y;
                minx = Math.min(minx, ax);
                miny = Math.min(miny, ay);
                maxx = Math.max(maxx, ax);
                maxy = Math.max(maxy, ay);
            }
            double arr = (maxy - miny) * (maxx - minx);
            System.out.printf("Polygon %d: %.3f\n", ++casos, arr);
            n = leer.nextInt();
        }
    }
}
