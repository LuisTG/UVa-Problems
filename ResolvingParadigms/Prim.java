package ResolvingParadigms;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {

    static class par implements Comparable<par> {

        int nd, p;

        public par(int nd, int p) {
            this.nd = nd;
            this.p = p;
        }

        @Override
        public int compareTo(par o) {
            if (this.p < o.p) {
                return -1;
            } else if (this.p > o.p) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    static PriorityQueue<par> pq;
    static boolean seleccionado[];
    static ArrayList<ArrayList<par>> lista;

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n = leer.nextInt();
        int m = leer.nextInt();
        //representacion del grafo en lista de adyacencia
        lista = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lista.add(new ArrayList<par>());
        }
        int no, nd, p;
        for (int i = 0; i < m; i++) {
            no = leer.nextInt();
            nd = leer.nextInt();
            p = leer.nextInt();
            lista.get(no).add(new par(nd, p));
            lista.get(nd).add(new par(no, p));
        }
        seleccionado = new boolean[n];
        pq = new PriorityQueue();
        //toma arbitraria de un nodo
        insertar(0);
        int acumulador = 0;
        while (!pq.isEmpty()) {
            par arista = pq.poll();
            if (!seleccionado[arista.nd]) {
                //acumulador de costos
                //si la arista permite llegar a nodo no visitado
                acumulador += arista.p;
                //proceso de insercion de aristas
                insertar(arista.nd);
            }
        }
        System.out.println(acumulador);
    }

    public static void insertar(int u) {
        //marcar nodo como seleccionada
        seleccionado[u] = true;
        for (int i = 0; i < lista.get(u).size(); i++) {
            par n = lista.get(u).get(i);
            if (!seleccionado[n.nd]) {
                //si nd no ha sido previmente visitada
                //agregar arista a la cola
                pq.add(n);
            }
        }
    }
}
