/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class SolveIt10341 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int p=leer.nextInt();
            int q=leer.nextInt();
            int r=leer.nextInt();
            int s=leer.nextInt();
            int t=leer.nextInt();
            int u=leer.nextInt();
            //System.out.println("hola");
            double inf=0,sup=1;
            double x=(inf+sup)/2;
            double err=.00000001;
            //System.out.println(err);
            double res=p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*(x*x)+u;
            //System.out.println();
            boolean band=true;
            while(Math.abs(res)>err && band){
                //System.out.println(res+" "+x);
                if(res<0){
                    sup=x;
                }else{
                    inf=x;
                }
                if(sup==inf) band=false;
                x=(inf+sup)/2;
                res=p*Math.exp(-x)+q*Math.sin(x)+r*Math.cos(x)+s*Math.tan(x)+t*(x*x)+u;
            }
            if(band)
                System.out.printf("%.4f\n",x);
            else
                System.out.println("No solution");
        }
    }
}
