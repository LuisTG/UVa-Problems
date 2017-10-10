/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Greedy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class JoshuaString2419 {
    static class popo implements Comparable<popo>{
        String s;

        public popo(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(popo o) {
        char A[]=this.s.toCharArray();
        char B[]=o.s.toCharArray();
        int T = Math.min(A.length, B.length);
        for(int i=0;i<T;i++){
            if(A[i] > B[i]) return -1;
            if(A[i] < B[i]) return 1;
        }
        if(A.length > B.length) return -1;
        return 1;
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int casos=leer.nextInt();
        while(casos-->0){
            int n=leer.nextInt();
            PriorityQueue<popo> q=new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                q.add(new popo(leer.next()));
            }
            StringBuilder st=new StringBuilder();
           /* while(!q.isEmpty()){
                popo s=q.poll();
                System.out.println(s.s);
            }*/
            while(!q.isEmpty()){
                popo s=q.poll();
               
                //System.out.println(s.s);
                st.append(s.s.charAt(0));
                if(s.s.length()>1){
                    q.add(new popo(s.s.substring(1)));
                }
            }
            System.out.println(st.toString());
        }
    }
}
