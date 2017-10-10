/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author luis
 */
public class BrightLight10927 {
    static class point implements Comparable<point>{
        double x,y,h,p,c,d;

        public point(double x, double y, double h, double p, double c) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.p = p;
            this.c = c;
            this.d=Math.hypot(x,y);
        }

        @Override
        public int compareTo(point o) {
            if(d!=0){
                return (int)(this.d-o.d); 
            }else{
                if(this.x != o.x){
                    return (int)(this.x-o.x);
                }else{
                    return (int)(this.y-o.y);
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        int casos=1;
        while(n!=0){
            double x,y,h,p,c;
            HashMap<String, TreeSet<point>> hs=new HashMap<>();
            for (int i = 0; i < n; i++) {
                c=0;
                x=leer.nextDouble();
                y=leer.nextDouble();
                h=leer.nextDouble();
                if(x>0 && y>0) c=1;
                else if(x<0 && y>0) c=2;
                else if(x<0 && y<0) c=3;
                else if(x>0 && y<0) c=4;
                p=y/x;
                //System.out.println("c "+c+" p "+p);
                if(!hs.containsKey(c+" "+p)){
                    hs.put(c+" "+p, new TreeSet<point>());
                    hs.get(c+" "+p).add(new point(x,y,h,p,c));
                }else{
                    hs.get(c+" "+p).add(new point(x,y,h,p,c));
                }
            }
            TreeSet<point> res=new TreeSet<>();
            for (Map.Entry<String, TreeSet<point>> entry : hs.entrySet()) {
                TreeSet<point> s=entry.getValue();
                double ha=-1;
                while(!s.isEmpty()){
                    point it=s.pollFirst();
        if(casos==2 && it.x==-63112 && it.y==7225)
                        System.out.println(entry.getKey()+"********************************************"+ha+"********************************************************"+it.h);
                    if(it.h>ha){
                        ha=it.h;
                    }else{
                        it.d=0;
                        res.add(it);
                    }
                }
            }
            System.out.printf("Data set %d:\n",casos);
            if(res.isEmpty()){
                System.out.println("All the lights are visible.");
            }else{
                System.out.println("Some lights are not visible:");
                while(!res.isEmpty()){
                    point t=res.pollFirst();
                    if(res.isEmpty())
                    System.out.printf("x = %d, y = %d.\n",(int)t.x,(int)t.y);
                    else
                        System.out.printf("x = %d, y = %d;\n",(int)t.x,(int)t.y);
                }
            }
            casos++;
            n=leer.nextInt();
        }
    }
}
