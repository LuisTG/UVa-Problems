/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

import java.util.Scanner;

public class Therestreasureeverywhere587 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        String s=leer.next();
        int cont=1;
        while(!s.equals("END")){
            String steps[]=s.split(",");
            double x=0,y=0,z,a;
            for (int i = 0; i < steps.length; i++) {
              StringBuilder digit=new StringBuilder();
              StringBuilder direc=new StringBuilder();
              int len;
              if(i==steps.length-1){
                  len=steps[i].length()-1;
              }else{
                  len=steps[i].length();
              }
              for (int j = 0; j < len ; j++) {
                    if(Character.isDigit(steps[i].charAt(j))){
                        digit.append(steps[i].charAt(j));
                    }else{
                        direc.append(steps[i].charAt(j));
                    }
                }
              switch(direc.toString()){
                  case "N":
                      x += Double.parseDouble(digit.toString());
                      break;
                  case "S":
                      x -= Double.parseDouble(digit.toString());
                      break;
                  case "E":
                      y += Double.parseDouble(digit.toString());
                      break;
                  case "W":
                      y -= Double.parseDouble(digit.toString());
                      break;
                  case "NW":
                      a=Double.parseDouble(digit.toString());
                      z=(a*a)/2;
                      z=Math.sqrt(z);
                      x += z;
                      y-=z;
                      break;
                  case "SW":
                      a=Double.parseDouble(digit.toString());
                      z=(a*a)/2;
                      z=Math.sqrt(z);
                      x -=z ;
                      y -=z;
                      break;
                  case "NE":
                      a=Double.parseDouble(digit.toString());
                      z=(a*a)/2;
                      z=Math.sqrt(z);
                      x += z;
                      y+=z;
                      break;
                  case "SE":
                      a=Double.parseDouble(digit.toString());
                      z=(a*a)/2;
                      z=Math.sqrt(z);
                      y += z;
                      x-= z;
                      break;
              }
            }
            double dist=Math.hypot(x, y);
            System.out.println("Map #"+cont);
            System.out.printf("The treasure is located at (%.3f,%.3f).\n",y,x);
            System.out.printf("The distance to the treasure is %.3f.\n",dist);
            System.out.println("");
            cont++;
            s=leer.next();
        }
    }
 
}
