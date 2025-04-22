import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

public class ManipulaDados {

    private static final ListaEncadeadaCreche listaCreches = new ListaEncadeadaCreche();
    private static final ListaEncadeadaDistanciaCreche listaDistanciaCreche = new ListaEncadeadaDistanciaCreche();
    private Grafo grafo;
    private String nomeArq;

    public ManipulaDados(String nomeArq){
        this.nomeArq = Paths.get("src", nomeArq).toString(); //utilizado para obter o caminho correto do arquivo
        try(BufferedReader br = new BufferedReader(new FileReader(this.nomeArq))) {
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

    public void listarCreches(){
        for (Creche creche : listaCreches.conteudo()) {
            System.out.println("-> Creche " + creche.getId() + ": " + creche.getNome());
        }
    }

    public void imprimirMatriz(){
        grafo.imprimirMatriz();
    }

    public void imprimirConexoes(){
        int[] grau = grafo.imprimiGrau();
        for (int i = 0; i < grau.length; i++) {
            System.out.println("-> Creche: " + listaCreches.retornaCrechePorId(i).getNome() + " - Conexões: " + grau[i]);
        }
    }

    public void buscarConexoesDeCreche(String nomeCrecheBuscada) {

        Creche crecheBuscada = listaCreches.retornaCrechePorNome(nomeCrecheBuscada);
        ListaEncadeadaDistanciaCreche distanciaBuscada = new ListaEncadeadaDistanciaCreche();

        if (crecheBuscada == null) {
            System.out.println("Creche não encontrada.");
            return;
        }

        int[][] matriz = grafo.retornaMatriz();
        DistanciaCreche distanciaCreche;
        for (int j = 0; j < matriz.length; j++) {
            if (matriz[crecheBuscada.getId()][j] == 1) {
                distanciaCreche = listaDistanciaCreche.retornaDistanciaCreche(crecheBuscada.getId(), j);
                distanciaBuscada.adicionar(distanciaCreche);
            }
        }

        if (distanciaBuscada.conteudo() == null) {
            System.out.println("Esta creche nao possui conexoes registradas.");
            return;
        }

        System.out.println("Conexoes da creche '" + nomeCrecheBuscada + "' (ordenadas por distancia):\n");
        for (DistanciaCreche c : distanciaBuscada.conteudoOrdenadoPorDistancia()) {
            String nomeCreche = listaCreches.retornaCrechePorId(c.getCrecheFim()).getNome();
            System.out.println("-> " + nomeCreche + " - Distancia: " + c.getDistancia() + " km");
        }
    }

    public void cadastrarConexao(String nomeCrecheInicio, String nomeCrecheFim, float distancia) {

        Creche crecheBuscadaInicio = listaCreches.retornaCrechePorNome(nomeCrecheInicio);
        Creche crecheBuscadaFim = listaCreches.retornaCrechePorNome(nomeCrecheFim);

        if (crecheBuscadaInicio == null || crecheBuscadaFim == null) {
            System.out.println("\"Uma ou ambas as creches nao foram encontradas.\"");
            return;
        }

        DistanciaCreche novaConexao = new DistanciaCreche(crecheBuscadaInicio.getId(), crecheBuscadaFim.getId(), distancia);
        listaDistanciaCreche.adicionar(novaConexao);
        grafo.adicionarAresta(crecheBuscadaInicio.getId(), crecheBuscadaFim.getId());

        //Utilizado para adicionar a nova conexão no arquivo
        try {
            FileWriter gravador = new FileWriter(this.nomeArq, true);
            gravador.write("\n"+ crecheBuscadaInicio.getId() + "," + crecheBuscadaFim.getId() + "," + distancia);
            gravador.close();
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e);
        }

        System.out.println("\nNova conexão cadastrada com suecesso! \n");
    }

    public void informarDistanciaEntreCreches(String nome1, String nome2) {
        Creche[] creches = listaCreches.conteudo();
        int id1 = -1, id2 = -1;

        for (Creche c : creches) {
            if (c.getNome().equalsIgnoreCase(nome1)) {
                id1 = c.getId();
            }
            if (c.getNome().equalsIgnoreCase(nome2)) {
                id2 = c.getId();
            }
        }

        if (id1 == -1 || id2 == -1) {
            System.out.println("Uma ou ambas as creches nao foram encontradas.");
            return;
        }

        int[][] matriz = grafo.retornaMatriz();
        if (matriz[id1][id2] == 1) {
            Float distancia = listaDistanciaCreche.retornaDistanciaCreche(id1, id2).getDistancia();
            if (distancia == null) {
                distancia = listaDistanciaCreche.retornaDistanciaCreche(id2, id1).getDistancia();
            }
            System.out.println("\nDistancia entre '" + nome1 + "' e '" + nome2 + "': " + distancia + " km");
        } else {
            System.out.println("\nNao existe conexão direta entre '" + nome1 + "' e '" + nome2 + "'.");
        }
    }

}