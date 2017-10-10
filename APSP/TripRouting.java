/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TripRouting {
    static int p[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hm=new HashMap<>();
        HashMap<Integer, String> hm2=new HashMap<>();
        HashMap<String, String> r=new HashMap<>();
        String s;
        int cont=0;
        int floyd[][]=new int[101][101];
        p=new int[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                floyd[i][j]=100000000;
                p[i][j]=i;
            }
        }
        while((s=br.readLine().trim()).length()>0){
            String aux[]=s.split(",");
            int in,fin;
            if(!hm.containsKey(aux[0])){
                hm.put(aux[0], cont);
                hm2.put(cont++, aux[0]);
            }
            if(!hm.containsKey(aux[1])){
                hm.put(aux[1], cont);
                hm2.put(cont++, aux[1]);
            }
            in=hm.get(aux[0]);
            fin=hm.get(aux[1]);
            if(floyd[in][fin]>Integer.parseInt(aux[3])){
                floyd[in][fin]=Integer.parseInt(aux[3]);
                floyd[fin][in]=Integer.parseInt(aux[3]);
                r.put(in+","+fin, aux[2]+","+aux[3]);
                r.put(fin+","+in, aux[2]+","+aux[3]);
            }
        }
        for (int k = 0; k < 101; k++) {
            for (int i = 0; i < 101; i++) {
                for (int j = 0; j < 101; j++) {
                    if(floyd[i][k]+floyd[k][j]<floyd[i][j]){
                        floyd[i][j]=floyd[i][k]+floyd[k][j];
                        p[i][j]=p[k][j];
                    }
                }
            }
        }
        while((s=br.readLine())!=null){
            String aux[]=s.split(",");
            System.out.println("");
            System.out.println("");
            System.out.println("From                 To                   Route      Miles");
            System.out.println("-------------------- -------------------- ---------- -----");
            int in,fin;
            in=hm.get(aux[0]);
            fin=hm.get(aux[1]);
            String p=in+printPath(in,fin)+" "+fin;
            String pat[]=p.split(" ");
            String cin,cfin;
            String ro[];
            //System.out.println("hola"+p+" r "+floyd[in][fin]);
            for (int i = 0; i < pat.length-1; i++) {
                cin=hm2.get(Integer.parseInt(pat[i]));
                cfin=hm2.get(Integer.parseInt(pat[i+1]));
                ro=r.get(pat[i]+","+pat[i+1]).split(",");
                System.out.print(cin);
                for (int j = cin.length(); j <= 20; j++) {
                    System.out.print(" ");
                }
                System.out.print(cfin);
                for (int j = cfin.length(); j <= 20; j++) {
                    System.out.print(" ");
                }
                System.out.print(ro[0]);
                for (int j = ro[0].length(); j <= 10; j++) {
                    System.out.print(" ");
                }
                //System.out.println("hhh"+ro[1].length());
                for (int j = ro[1].length(); j < 5; j++) {
                    System.out.print(" ");
                }
                System.out.println(ro[1]);
            }
            System.out.println("                                                     -----");
            System.out.print("                                          Total      ");
            String c=""+floyd[in][fin];
            for (int i = c.length(); i < 5; i++) {
                System.out.print(" ");
            }
            System.out.println(c);
        }
    }
    static String printPath(int i, int j) {
        String s = "";
        if (i != p[i][j]) {
            s += printPath(i, p[i][j]) + " " + (p[i][j]);
        }

        return s;
    }
}
