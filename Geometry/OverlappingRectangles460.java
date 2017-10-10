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
public class OverlappingRectangles460 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        for (int i = 0; i < n; i++) {
            int x1,y1,x2,y2,x3,y3,x4,y4;
            x1=leer.nextInt();
            y1=leer.nextInt();
            x2=leer.nextInt();
            y2=leer.nextInt();
            x3=leer.nextInt();
            y3=leer.nextInt();
            x4=leer.nextInt();
            y4=leer.nextInt();
            
           int a,b,c,d;
           a=Math.max(x1, x3);
           b=Math.max(y1, y3);
           c=Math.min(x2, x4);
           d=Math.min(y2, y4);
           if(i!=0)
               System.out.println("");
           if(a>=c || b>=d){
               System.out.println("No Overlap");
           }else{
               System.out.println(a+" "+b+" "+c+" "+d);
           }
           
           
        }
    }
}
