/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Scanner;

public class AlexOrigami3899 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        double h,w;
        h=leer.nextDouble();
        w=leer.nextDouble();
        double res1=0,res2=0,res3=0,res4=0;
        if(h>w){
            if(h/3<=w){
                res1=h/3;
            }
            if(w*3<=h){
                res2=w;
            }
        }else{
            if(w/3<=h){
                res3=w/3;
            }
            if(h*3<=w){
                res4=h;
            }
        }
        double min=Math.min(h, w);
        min=min/2;
        res1=Math.max(res1, res2);
        res3=Math.max(res3, res4);
        res1=Math.max(res1, res3);
        res1=Math.max(res1, min);
        System.out.printf("%f\n",res1);
    }
}
