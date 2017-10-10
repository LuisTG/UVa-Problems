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
public class JillRidesAgain507 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int routes=leer.nextInt();
        for (int h = 1; h <= routes; h++) {
            int stops=leer.nextInt();
            int sum=0, ans=0;
            int st=1,en=1, fst=0,fen=0;
            for (int i = 0; i < stops-1; i++) {
                sum+=leer.nextInt();
                en++;
                //ans=Math.max(sum, ans);
                if(sum>ans){
                    ans=sum;
                    fst=st;
                    fen=en;
                   // System.out.println("entran "+ans+" fst "+fst+" fen "+fen);
                }else{
                    if(sum==ans && (en-st)>(fen-fst)){
                    ans=sum;
                    fst=st;
                    fen=en;
                    //System.out.println("entran "+ans+" fst "+fst+" fen "+fen);
                }
                }
                if(sum<0){
                    st=en;
                    en=st;
                    sum=0;
                }
            }
            if(ans==0){
                System.out.println("Route "+h+" has no nice parts");
            }else{
                System.out.println("The nicest part of route "+h+" is between stops "+fst+" and "+fen);
            }
        }
    }
}
