/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class FractionsAgain10976 {
    static class par{
        int x,y;

        public par(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
    }
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            int n=leer.nextInt();
            int val,res;
            ArrayList<par> ar=new ArrayList<>();
            if(n==1){
                System.out.println("1\n1/1 = 1/2 + 1/2");
            }
            else{
                for (int i = 2*n; i > n ; i--) {
                    if((n*i)%(i-n)==0){
                        ar.add(new par(i,(n*i)/(i-n)));
                    }
                }
                System.out.println(ar.size());
                for (int i = ar.size()-1; i >-1; i--) {
                    System.out.println("1/"+n+" = 1/"+ar.get(i).y+" + 1/"+ar.get(i).x);
                }
            }
        }
    }
}
