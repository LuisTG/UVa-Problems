/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class ArbitrageII {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int V=Integer.parseInt(br.readLine().trim());
        int ca=1;
        while(V!=0){
            double floyd[][][]=new double[V][V][V];
            HashMap<String, Integer> hm=new HashMap<>();
            int cont=0;
            for (int i = 0; i < V; i++) {
                hm.put(br.readLine(), cont++);
            }
            for (int i = 0; i < V; i++) {
                floyd[0][i][i]=1.0;
            }
            int e=Integer.parseInt(br.readLine().trim());
            String s[];
            for (int i = 0; i < e; i++) {
                s=br.readLine().split(" ");
                floyd[0][hm.get(s[0])][hm.get(s[2])]=Double.parseDouble(s[1]);
            }
            for (int x = 1; x < V; x++) {
                for (int k = 0; k < V; k++) {
                    for (int i = 0; i < V; i++) {
                        for (int j = 0; j < V; j++) {
                            double aux= floyd[x-1][i][k]*floyd[0][k][j];
                            if(aux>floyd[x][i][j]){
                                floyd[x][i][j]=aux;
                            }
                        }
                    }
                }
            }
            boolean b=false;
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if(floyd[i][j][j]>1.0){
                        b=true;
                    }
                }
            }
            if(b){
                System.out.println("Case "+ca+": Yes");
            }
            else{
                System.out.println("Case "+ca+": No");
            }
            ca++;
            br.readLine();
            V=Integer.parseInt(br.readLine().trim());
        }
    }
}
