/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Scanner;

public class AnniversaryCakes3899 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int w=leer.nextInt();
        int h=leer.nextInt();
        int ax=leer.nextInt();
        int ay=leer.nextInt();
        int bx=leer.nextInt();
        int by=leer.nextInt();
        if(ax!=bx){
            System.out.println(ax+" 0 "+bx+" "+h);
        }else{
            System.out.println("0 "+ay+" "+w+" "+by);
        }
    }
}
