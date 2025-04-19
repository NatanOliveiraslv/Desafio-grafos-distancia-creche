import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CarregaTxt carregaTxt = new CarregaTxt("estrutura.txt");
        Scanner scanner = new Scanner(System.in);

        int opcao = 0;

        do{

            System.out.println("\n----------------------------------");
            System.out.println("| 1 - Listar conexoes            |");
            System.out.println("| 2 - Buscar conexão de creche   |");
            System.out.println("| 3 - Cadastrar nova creche      |");
            System.out.println("| 0 - Para sair                  |");
            System.out.println("----------------------------------\n");

            System.out.println("Digite a opção desejada");
            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    carregaTxt.imprimirConexoes();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 0:
                    System.out.println("saindo...");
                    break;
            }

        }while (opcao != 0);

    }

    private static void cadastrarCreches() {

        }

}
