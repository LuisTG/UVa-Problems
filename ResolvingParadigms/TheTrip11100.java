/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ResolvingParadigms;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class TheTrip11100 {
    public static void main(String[] args) {
        Scanner leer=new Scanner(System.in);
        int n=leer.nextInt();
        boolean band=false;
        while(n!=0){
           int ar[]=new int[n];
            for (int i = 0; i < n; i++) {
                ar[i]=leer.nextInt();
            }
            Arrays.sort(ar);
            int max=-1;
            int cont=1;
            for (int i = 0; i < n; i++) {
                if(i<n-1 && ar[i]==ar[i+1]){
                    cont++;
                    continue;
                }
                if (cont > max) {
                    max = cont;
                }
                cont = 1;
            }
            if(band) System.out.println("");
            band=true;
            System.out.println(max);
            for (int i = 0; i < max; i++) {
                boolean b = true;
                for (int j = i; j < n; j += max) {
                    if (b) {
                        b = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(ar[j]);
                }
                System.out.println("");
            }
            n = leer.nextInt();
        }
    }
}
/*
 #include <cstdio>
#include <cstring>
#include <algorithm>
#define MAX 10100
using namespace std;

int store[MAX];

int main() {
	int n;
	while ((scanf("%d",&n)==1) && (n>0)) {
		memset(store,0,sizeof(store));
		for(int i=0;i<n;i++){
			scanf("%d",&store[i]);
		}
		sort(store,store+n);

		// Find the maximum number of same sized bags
		int maxLug = -1;
		int curr = 1;
		for(int i=0;i<n;i++){
			if(store[i] == store[i+1]) {
				curr++;
				continue;
			}
			if (curr > maxLug) maxLug = curr;
			curr = 1;
		}

		// Output with the max num of same sized bags interval
		printf("%d\n",maxLug);
		for (int i=0;i<maxLug;i++){
			bool first = true;
			for (int j=i;j<n;j+=maxLug) {
				if (first) first = false;
				else  printf(" ");
				printf("%d",store[j]);
			}
			printf("\n");
		}
	}
	return 0;
}
 */