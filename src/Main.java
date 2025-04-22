import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ManipulaDados manipulaDados = new ManipulaDados("estrutura.txt");
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do{

            System.out.println("\n------------------------------------");
            System.out.println("| 1 - Listar conexoes              |");
            System.out.println("| 2 - Buscar conexões de creche    |");
            System.out.println("| 3 - Cadastrar nova conexão       |");
            System.out.println("| 4 - Listar Creches cadastradas   |");
            System.out.println("| 5 - Distância entre duas creches |");
            System.out.println("| 6 - Imprimir Matriz              |");
            System.out.println("| 0 - Sair                         |");
            System.out.println("------------------------------------\n");

            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    manipulaDados.imprimirConexoes();
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Digite o nome da creche: ");
                    String nomeCreche = scanner.next();
                    manipulaDados.buscarConexoesDeCreche(nomeCreche);
                    break;
                case 3:
                    System.out.print("Digite o nome da creche de início: ");
                    String nomeCrecheIncio = scanner.next();
                    System.out.print("Digite o nome da creche de fim: ");
                    String nomeCrecheFim = scanner.next();
                    System.out.print("Informe a distancia entre as creches: ");
                    float distancia = scanner.nextFloat();
                    manipulaDados.cadastrarConexao(nomeCrecheIncio, nomeCrecheFim, distancia);
                    break;
                case 4:
                    manipulaDados.listarCreches();
                    break;
                case 5:
                    System.out.print("Digite o nome da primeira creche: ");
                    String nome1 = scanner.next();
                    System.out.print("Digite o nome da segunda creche: ");
                    String nome2 = scanner.next();
                    manipulaDados.informarDistanciaEntreCreches(nome1, nome2);
                    break;
                case 6:
                    manipulaDados.imprimirMatriz();
                    break;
                case 0:
                    System.out.println("saindo...");
                    break;
            }

        }while (opcao != 0);

    }
}
