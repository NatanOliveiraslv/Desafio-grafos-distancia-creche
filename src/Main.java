import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        ArrayList<Creche> crechesCadastradas = new ArrayList<Creche>();
        String nome;
        Scanner scanner = new Scanner(System.in);
        ArrayList<DistanciaCreche> distanciaCrecheLista = new ArrayList<DistanciaCreche>();
        DistanciaCreche distanciaCreche;
        Creche creche;
        Grafo grafo;

        System.out.println("Digite a quantidade de creches: ");
        int qtdCreches = scanner.nextInt();

        //Cadastra creche
        for (int i = 0; i < qtdCreches; i++) {
            System.out.println("Digite o nome da creche " + i + ": ");
            nome = scanner.next();
            creche = new Creche(i, nome);
            crechesCadastradas.add(creche);
        }

        System.out.println("Digite a quantidade de distancias: ");
        int qtdQuantidadeDistancia = scanner.nextInt();

        grafo = new Grafo(qtdCreches, qtdQuantidadeDistancia, false);

        //Cadastra distancia entre as creches
        for (int i = 0; i < qtdQuantidadeDistancia; i++) {
            System.out.println("Digite o id da creche incial: ");
            int crecheInicial = scanner.nextInt();
            System.out.println("Digite o id da creche final: ");
            int crecheFinal = scanner.nextInt();
            System.out.println("Digite a distancia entre as duas: ");
            float distancia = scanner.nextFloat();

            distanciaCreche = new DistanciaCreche(crecheInicial, crecheFinal, distancia);
            distanciaCrecheLista.add(distanciaCreche);
            grafo.adicionarAresta(crecheInicial, crecheFinal);
        }

        grafo.imprimirMatriz();
        System.out.println();

        int[][] matriz = grafo.retornaMatriz();

        String nomeCreche = null;
        String nomeCreche2 = null;
        float distancia = 0;

        for (int i = 0; i < qtdCreches; i++) {
            //busca creche
            for (Creche creche1 : crechesCadastradas) {
                if (creche1.getId() == i) {
                    nomeCreche = creche1.getNome();
                }
            }

            for (int j = 0; j < qtdCreches; j++) {
                if (j == 1) {
                    for (Creche creche2 : crechesCadastradas) {
                        if (creche2.getId() == j) {
                            nomeCreche2 = creche2.getNome();
                        }
                    }
                    for (DistanciaCreche teste : distanciaCrecheLista) {
                        if (teste.getCrecheInicio() == i && teste.getCrecheFim() == j) {
                            distancia = teste.getDistancia();
                        }
                    }
                    System.out.println("A distancia entre a creche " + nomeCreche + "e a creche " + nomeCreche2 + "é " + distancia);
                }
            }
        }

    }

}
