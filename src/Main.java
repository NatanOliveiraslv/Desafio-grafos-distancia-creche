import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static ListaEncadeadaCreche listaCreches = new ListaEncadeadaCreche();
    private static ListaEncadeadaDistanciaCreche listaDistanciaCreche = new ListaEncadeadaDistanciaCreche();
    private static Grafo grafo;
    private static int qtdCreches;
    private static int qtdQuantidadeDistancia;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.println("Digite a quantidade de creches: ");
        qtdCreches = scanner.nextInt();

        cadastrarCreches();
        imprimirCrechesCadastradas();


        System.out.println("\nDigite a quantidade de distancias: ");
        qtdQuantidadeDistancia = scanner.nextInt();

        grafo = new Grafo(qtdCreches, qtdQuantidadeDistancia, false);

        cadastrarDistanciaCreche();

        grafo.imprimirMatriz();

        System.out.println();



    }

    // Funcao para cadastrar as creches
    private static void cadastrarCreches() {
        for (int i = 0; i < qtdCreches; i++) {
            System.out.println("Digite o nome da creche " + i + ": ");
            String nome = scanner.next();
            Creche creche = new Creche(nome);
            listaCreches.adicionar(creche);
        }
    }

    // Funcao para imprimir as creches cadastradas
    private static void imprimirCrechesCadastradas() {
        System.out.println("\nCreches cadastradas: ");
        for (Creche creche : listaCreches.conteudo()) {
            System.out.println("Creche " + creche.getId() + ": " + creche.getNome());
        }
    }

    // Funcao para cadastrar as distancias entre as creches e o grafo
    private static void cadastrarDistanciaCreche() {
        for (int i = 0; i < qtdQuantidadeDistancia; i++) {
            System.out.println("Digite o id da creche incial: ");
            int crecheInicial = scanner.nextInt();
            System.out.println("Digite o id da creche final: ");
            int crecheFinal = scanner.nextInt();
            System.out.println("Digite a distancia entre as duas: ");
            float distancia = scanner.nextFloat();

            DistanciaCreche distanciaCreche = new DistanciaCreche(crecheInicial, crecheFinal, distancia);
            listaDistanciaCreche.adicionar(distanciaCreche);
            grafo.adicionarAresta(crecheInicial, crecheFinal);
        }
    }

    // Funcao para imprimir as distancias da conexoes entre uma creche
    private int listarCrechesConectadas(int idCreche){
        int qtdConectadas = 0;
        for (int i = 0; i < qtdCreches; i++) {
            if (grafo.retornaMatriz()[idCreche][i] == 1) {
                System.out.println("Creche " + listaCreches.retornaCreche(i).getNome() +
                                   " está conectada a creche " + listaCreches.retornaCreche(i).getNome() +
                                   " com a distancia de " + listaDistanciaCreche.retornaDistancia(idCreche, i));
                qtdConectadas++;
            }
        }
        return qtdConectadas;
    }
    
}
