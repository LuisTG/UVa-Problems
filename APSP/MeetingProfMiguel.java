/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package APSP;

import java.util.Scanner;

/**
 *
 * @author luis
 */
public class MeetingProfMiguel {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int a=leer.nextInt();
        while(a!=0){
            int AdjY[][]=new int[30][30];
            int AdjM[][]=new int[30][30];
            
            String s, d, or,des;
            int p;
            int V=30;
            for (int l = 0; l < V; l++) {
                for (int m = 0; m < V; m++) {
                    AdjM[l][m] = 1000000000;
                    AdjY[l][m] = 1000000000;
                }
            }
            for (int i = 0; i < a; i++) {
                s=leer.next();
                d=leer.next();
                or=leer.next();
                des=leer.next();
                p=leer.nextInt();
                if(s.equals("Y")){
                    if(d.equals("U")){
                        AdjY[or.charAt(0)-'A'][des.charAt(0)-'A']=p;
                    }else{
                        AdjY[or.charAt(0)-'A'][des.charAt(0)-'A']=p;
                        AdjY[des.charAt(0)-'A'][or.charAt(0)-'A']=p;
                    }
                }else{
                    if(d.equals("U")){
                        AdjM[or.charAt(0)-'A'][des.charAt(0)-'A']=p;
                    }else{
                        AdjM[or.charAt(0)-'A'][des.charAt(0)-'A']=p;
                        AdjM[des.charAt(0)-'A'][or.charAt(0)-'A']=p;
                    }
                }
            }
            for (int i = 0; i < 30; i++) {
                AdjM[i][i] = 0;
                AdjY[i][i] = 0;
            }
            for (int k = 0; k < V; k++) {
                for (int i = 0; i < V; i++) {
                    for (int j = 0; j < V; j++) {
                        if (AdjY[i][k] + AdjY[k][j] < AdjY[i][j]) {
                            AdjY[i][j] = AdjY[i][k] + AdjY[k][j];
                        }
                        if (AdjM[i][k] + AdjM[k][j] < AdjM[i][j]) {
                            AdjM[i][j] = AdjM[i][k] + AdjM[k][j];
                        }
                    }
                }
            }
            char x,y;
            x=leer.next().charAt(0);
            y=leer.next().charAt(0);
            int menor=1000000000;
            for (int i = 0; i < 30; i++) {
                if(AdjY[x-'A'][i]!=1000000000 && AdjM[y-'A'][i]!=1000000000){
                    if(menor>AdjY[x-'A'][i]+AdjM[y-'A'][i]){
                        menor=AdjY[x-'A'][i]+AdjM[y-'A'][i];
                    }
                }
            }
                if (menor != 1000000000) {
                    System.out.print(menor);
                    for (int i = 0; i < 30; i++) {
                        if (AdjY[x - 'A'][i] != 1000000000 && AdjM[y - 'A'][i] != 1000000000) {
                            if (menor == AdjY[x - 'A'][i] + AdjM[y - 'A'][i]) {
                                System.out.print(" " + (char) (i + 'A'));
                            }
                        }
                    }
                    System.out.println("");
                } else {
                    System.out.println("You will never meet.");
                }
            
            a = leer.nextInt();
        }
    }
}
