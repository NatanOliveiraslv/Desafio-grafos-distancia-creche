import java.util.Scanner;

public class Grafo {

    private int aresta;
    private int nodos;
    private int[][] matriz;
    private boolean ehDigrafo;

    public Grafo(int nodos, boolean ehDigrafo) {
        this.nodos = nodos;
        this.ehDigrafo = ehDigrafo;
        this.matriz = new int[nodos][nodos];
    }

    public void adicionarAresta(int nodo1, int nodo2) {
        if(this.nodos < nodo1 || this.nodos < nodo2){
            System.out.println("Nodo não existe");
        }
        matriz[nodo1][nodo2] = 1;
        if (!ehDigrafo) {
            matriz[nodo2][nodo1] = 1;
        }
        this.aresta++;
    }

    public void imprimirMatriz() {
        System.out.println("Matriz de Adjacência:");
        for (int i = 0; i < this.nodos; i++) {
            for (int j = 0; j < this.nodos; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] retornaMatriz(){
        return matriz;
    }

    public int getAresta() {
        return aresta;
    }

    public int[] imprimiGrau() {
        int[] grauArray = new int[nodos];
        if (!ehDigrafo) {
            for (int i = 0; i < nodos; i++) {
                int grau = 0;
                for(int j = 0; j < nodos; j++){
                    if (matriz[i][j] == 1) {
                        grau++;
                    }
                }
                grauArray[i] = grau;
            }
        } else {
            for (int i = 0; i < nodos; i++) {
                int entrada = 0;
                int saida = 0;
                for (int j = 0; j < nodos; j++) {
                    if (matriz[i][j] == 1) {
                        saida++;
                    }
                    if (matriz[j][i] == 1) {
                        entrada++;
                    }
                }
                System.out.println("Grau do " + (i+1) + "° vertice informado:\n" + "Entrada: " + entrada + "  Saída: " + saida);
                System.out.println();
            }
        }
        return grauArray;
    }

}