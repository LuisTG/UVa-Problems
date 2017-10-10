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
public class MyLongestPalindrome3735 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int n=leer.nextInt();
            String s=leer.next();
            int ar[]=new int[27];
            for (int i = 0; i < n; i++) {
                ar[s.charAt(i)-'A']++;
            }
            StringBuilder rig=new StringBuilder();
            StringBuilder lef=new StringBuilder();
            char cen='a';
            boolean c=false;
            for (int i = 0; i < 27; i++) {
                if (ar[i] != 0) {
                    if (ar[i] % 2 == 1 && !c) {
                        c = true;
                        cen = (char) (i + 'A');
                    }
                                           
                    while (ar[i] > 1) {
                        ar[i] -= 2;
                        //System.out.println((char) (i + 'A'));
                        lef.append((char) (i + 'A'));
                        rig.append((char) (i + 'A'));
                    }
                }

            }
            //System.out.println(lef.toString());
            if(c){
                lef.append(cen);
            }
            rig=rig.reverse();
            lef.append(rig.toString());
            System.out.println(lef.toString());
        }
    }
}
