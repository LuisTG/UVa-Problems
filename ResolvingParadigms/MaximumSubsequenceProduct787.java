/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class MaximumSubsequenceProduct787 {
     public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        while(leer.hasNext()){
            BigInteger ar[]=new BigInteger[100];
            int neg[]=new int[100];
            int num=leer.nextInt();
            int n=0;
            while(num!=-999999){
                ar[n++]=new BigInteger(""+num);
                num=leer.nextInt();
            }
            BigInteger sum=new BigInteger("1");
            BigInteger ans=new BigInteger("-999999");
            for (int i = 0; i < n; i++) {
                sum=sum.multiply(ar[i]);
                //System.out.println("sum "+sum);
                ans=ans.max(sum);
                for(int j=i+1;j<n;j++){
                    sum=sum.multiply(ar[j]);
                    ans=ans.max(sum);
                }
                sum=new BigInteger("1");
            }
            System.out.println(ans);
        }
    }
}
