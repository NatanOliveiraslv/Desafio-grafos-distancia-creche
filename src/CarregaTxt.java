import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

public class CarregaTxt {

    private static final ListaEncadeadaCreche listaCreches = new ListaEncadeadaCreche();
    private static final ListaEncadeadaDistanciaCreche listaDistanciaCreche = new ListaEncadeadaDistanciaCreche();
    private Grafo grafo;

    public CarregaTxt(String nomeArq){
        nomeArq = Paths.get("src", nomeArq).toString(); //utilizado para obter o caminho correto do arquivo
        try(BufferedReader br = new BufferedReader(new FileReader(nomeArq))) {
            String linha;
            //cadastrar creche
            //Aqui é isEmpty, pois o codigo não deve rodar em linhas vazias
            while (!(linha = br.readLine()).isEmpty()){
                Creche creche = new Creche(linha);
                listaCreches.adicionar(creche);
            }

             grafo = new Grafo(listaCreches.getQtdCreches(), false);

            //Cadastrar distancias
            //aqui é diferente de null pois o leitor deve ir até o fim
            while ((linha = br.readLine()) != null){
                DistanciaCreche distanciaCreche = new DistanciaCreche();
                String[] arrOfStr = linha.split(",");

                int crecheInicial = Integer.parseInt(arrOfStr[0]);
                int crecheFinal = Integer.parseInt(arrOfStr[1]);
                float distancia = Float.parseFloat(arrOfStr[2]);

                distanciaCreche.setIdCrecheInicio(crecheInicial);
                distanciaCreche.setIdCrecheFim(crecheFinal);
                distanciaCreche.setDistancia(distancia);
                listaDistanciaCreche.adicionar(distanciaCreche);
                grafo.adicionarAresta(crecheInicial, crecheFinal);
            }
        }catch (IOException e){
            System.out.println("Deu erro: " + e);
        }
    }

    public void ler(){
        System.out.println("\nCreches cadastradas: ");
        for (Creche creche : listaCreches.conteudo()) {
            System.out.println("Creche " + creche.getId() + ": " + creche.getNome());
        }
        System.out.println("\nDistancias cadastradas: ");
        for(DistanciaCreche a : listaDistanciaCreche.conteudo()){
            System.out.println(a);
        }

    }

    public void imprimirMatriz(){
        grafo.imprimirMatriz();
    }

    public void imprimirConexoes(){
        int[] grau = grafo.imprimiGrau();
        for (int i = 0; i < grau.length; i++) {
            System.out.println("Creche: " + listaCreches.retornaCreche(i).getNome() + " Conexões: " + grau[i]);
        }
    }
}