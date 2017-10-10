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
public class theJackpot10684 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        while(n!=0){
            int sum=0, ans=0;
            for(int i=0;i<n;i++){
                sum+=leer.nextInt();
                ans=Math.max(sum, ans);
                if(sum<0)
                    sum=0;
            }
            if(ans==0){
                System.out.println("Losing streak.");         
            }else{
                System.out.println("The maximum winning streak is "+ans+".");
            }
            n=leer.nextInt();
        }
    }
}
