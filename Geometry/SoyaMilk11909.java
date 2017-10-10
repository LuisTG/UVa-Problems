/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Geometry;

/**
 *
 * @author luis
 */
public class SoyaMilk11909 {
    public static void main(String[] args) {
        double l=9.0, w=6.0, h=19.0, ang=20.0,pi=Math.PI,x,y,vol;
	x=Math.sin(ang*pi/180)*l;
	//cout<<x<<endl;
	y=Math.sqrt((l*l)-(x*x));
	//cout<<y<<endl;
	vol=(x*y/2.0)*w;
	//cout<<vol<<endl;
	vol=(l*w*h)-vol;
	       System.out.println(vol);
        //cout<<vol<<endl;
	//return 0;
    }
}
