/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class AlphaCentauriTennis1541 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n-->0){
            int x=leer.nextInt();
            String s=leer.next();
            System.out.println(s.charAt(s.length()-1));
        }
    }
}
