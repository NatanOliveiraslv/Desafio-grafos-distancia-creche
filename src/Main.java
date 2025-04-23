import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ManipulaDados manipulaDados = new ManipulaDados("estrutura.txt");
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do{

            System.out.println("\n------------------------------------");
            System.out.println("| 1 - Listar creches               |");
            System.out.println("| 2 - Listar conexoes              |");
            System.out.println("| 3 - Buscar conexões de creche    |");
            System.out.println("| 4 - Distância entre duas creches |");
            System.out.println("| 5 - Cadastrar nova conexão       |");
            System.out.println("| 6 - Imprimir matriz              |");
            System.out.println("| 0 - Sair                         |");
            System.out.println("------------------------------------\n");

            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao){
                // Listar creches
                case 1:
                    manipulaDados.listarCreches();
                    break;


                // Listar conexoes
                case 2:
                    manipulaDados.imprimirConexoes();
                    break;

                // Buscar conexões de creche
                case 3:
                    scanner.nextLine();
                    System.out.print("Digite o nome da creche: ");
                    String nomeCreche = scanner.next();
                    manipulaDados.buscarConexoesDeCreche(nomeCreche);
                    break;

                // Distância entre duas creches
                case 4:
                    System.out.print("Digite o nome da primeira creche: ");
                    String nome1 = scanner.next();
                    System.out.print("Digite o nome da segunda creche: ");
                    String nome2 = scanner.next();
                    manipulaDados.informarDistanciaEntreCreches(nome1, nome2);
                    break;

                // Cadastrar nova conexão
                case 5:
                    System.out.print("Digite o nome da creche de início: ");
                    String nomeCrecheIncio = scanner.next();
                    System.out.print("Digite o nome da creche de fim: ");
                    String nomeCrecheFim = scanner.next();
                    System.out.print("Informe a distancia entre as creches: ");
                    float distancia = scanner.nextFloat();
                    manipulaDados.cadastrarConexao(nomeCrecheIncio, nomeCrecheFim, distancia);
                    break;

                // Imprimir matriz
                case 6:
                    manipulaDados.imprimirMatriz();
                    break;

                // Sair
                case 0:
                    System.out.println("saindo...");
                    break;
            }

        }while (opcao != 0);

    }
}
