/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class AnInterestingGame3699 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        LinkedList<Integer> l=new LinkedList<>();
        for (int i = 0; i < n; i++) {
            l.add(leer.nextInt());
        }
        int f=0;
        int s=0;
        int cont=0;
        while(l.size()>1){
            int max=0;
            int pos=0;
            int aux;
            for (int i = 0; i < l.size()-1; i++) {
                aux=l.get(i)+l.get(i+1);
                if(max<aux){
                  max=aux;
                  pos=i;
                }
            }
            l.remove(pos);
            l.remove(pos);
            l.add(pos, max);
            if(cont%2==0){
                f+=max;
            }else{
                s+=max;
            }
        }
        if(s==f){
            System.out.println("Tie");
        }else{
            if(s>f){
                System.out.println("Second");
            }else{
                System.out.println("First");
            }
        }
    }
}
