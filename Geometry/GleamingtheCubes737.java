/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.Scanner;


public class GleamingtheCubes737 {
    
    static class cube{
    int x1,y1,z1,x2,y2,z2;

        public cube(int x1, int y1, int z1, int m) {
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.x2 = x1+m;
            this.y2 = y1+m;
            this.z2 = z1+m;
        }

        public cube(int x1, int y1, int z1, int x2, int y2, int z2) {
            this.x1 = x1;
            this.y1 = y1;
            this.z1 = z1;
            this.x2 = x2;
            this.y2 = y2;
            this.z2 = z2;
        }
    
    }
    static boolean inters;
    public static cube inter(cube a,cube b){
        int x1=Math.max(a.x1, b.x1);
        int y1=Math.max(a.y1, b.y1);
        int z1=Math.max(a.z1, b.z1);
        int x2=Math.min(a.x2, b.x2);
        int y2=Math.min(a.y2, b.y2);
        int z2=Math.min(a.z2, b.z2);
        if(x1>=x2 || y1>=y2 || z1>=z2) inters=false;
        return new cube(x1,y1,z1,x2,y2,z2);
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n!=0){
            inters=true;
            cube inte=inter(new cube(leer.nextInt(),leer.nextInt(),leer.nextInt(),leer.nextInt()),new cube(leer.nextInt(),leer.nextInt(),leer.nextInt(),leer.nextInt()));
            //System.out.println(inte.x1+" "+inte.y1+" "+inte.z1+" "+inte.x2+" "+inte.y2+" "+inte.z2+" ");
            
            for (int i = 2; i < n; i++) {
                inte=inter(inte,new cube(leer.nextInt(),leer.nextInt(),leer.nextInt(),leer.nextInt()));
            }
            //System.out.println(inte.x1+" "+inte.y1+" "+inte.z1+" "+inte.x2+" "+inte.y2+" "+inte.z2+" ");
            int vol=(inte.x2-inte.x1)*(inte.y2-inte.y1)*(inte.z2-inte.z1);
            if(inters)
                System.out.println(vol);
            else
                System.out.println("0");
            n=leer.nextInt();
        }
    }
}
