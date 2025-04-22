public class ListaEncadeadaDistanciaCreche {
    private DistanciaCreche head;
    private int qtdPosicoesOcupadas = 0;

    public ListaEncadeadaDistanciaCreche() {
    }

    //Adicionar distanciaCreche
    public void adicionar(DistanciaCreche distanciaCreche) {

        //inser o obeto no head caso esteja nulo
        if (head == null) {
            this.head = distanciaCreche;
            this.qtdPosicoesOcupadas++;
            return;
        }

        DistanciaCreche aux = this.head;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }

        aux.setProximo(distanciaCreche);
        this.qtdPosicoesOcupadas++;
    }

    //Remover distanciaCreche
    public boolean remover(DistanciaCreche distanciaCreche) {

        //validação para caso haja somente o primeiro valor
        if (this.head.getProximo() == null) {
            if (this.head.equals(distanciaCreche)) {
                this.head = null;
                qtdPosicoesOcupadas--;
                return true;
            }
        }

        DistanciaCreche aux = this.head;
        DistanciaCreche auxValorAnterior;

        for (int i = 0; i < qtdPosicoesOcupadas; i++) {
            auxValorAnterior = aux;
            aux = aux.getProximo();
            if (aux.equals(distanciaCreche)) {
                auxValorAnterior.setProximo(aux.getProximo());
                qtdPosicoesOcupadas--;
                return true;
            }
        }

        return false;
    }

    //Pesquisar posição da distanciaCreche
    public Integer posicao(DistanciaCreche distanciaCreche) {

        int posicao = 0;

        if (this.head.getProximo() == null) {
            if (this.head.equals(distanciaCreche)) {
                return posicao;
            }
        }

        DistanciaCreche aux = this.head;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
            if (aux.equals(distanciaCreche)) {
                return posicao;
            }
            posicao++;
        }
        return null;
    }

    //Visualizar lista completa
    public DistanciaCreche[] conteudo() {

        if (qtdPosicoesOcupadas == 0) {
            return null;
        }

        DistanciaCreche aux = this.head;
        DistanciaCreche[] lista = new DistanciaCreche[this.qtdPosicoesOcupadas];
        int i = 0;

        while (aux.getProximo() != null) {
            lista[i] = aux;
            aux = aux.getProximo();
            i++;
        }

        lista[i] = aux; //utilizado para armazenar o ultimo elemento tambem na lista
        return lista;
    }

    public DistanciaCreche retornaDistanciaCreche(int crecheInicio, int crecheFim){
        DistanciaCreche aux = this.head;
        while (aux != null) {
            //verifica se no aux o id da creche incial ou final e igual ao digitado, ou vice e versa, pois trata-se de um grafo
            if ((aux.getCrecheInicio() == crecheInicio && aux.getCrecheFim() == crecheFim) || (aux.getCrecheInicio() == crecheFim && aux.getCrecheFim() == crecheInicio)) {
                //Cria um novo objeto, pois ao retornar o obejto localizado estava ocorrendo erros ao usar o setProximo
                return new DistanciaCreche(aux.getCrecheInicio(), aux.getCrecheFim(), aux.getDistancia());
            }
            aux = aux.getProximo();
        }
        return null;
    }

    //Retorna o quantidade de posicoes ocupadas
    public int getQtdPosicoesOcupadas() {
        return qtdPosicoesOcupadas;
    }

    public DistanciaCreche[] conteudoOrdenadoPorDistancia() {
        DistanciaCreche[] conteudo = conteudo();
        DistanciaCreche aux = null;

        for(int i = 0; i<conteudo.length; i++){
            for(int j = 0; j<conteudo.length - 1; j++){
                if(conteudo[j].getDistancia() > conteudo[j + 1].getDistancia()){
                    aux = conteudo[j];
                    conteudo[j] = conteudo[j+1];
                    conteudo[j+1] = aux;
                }
            }
        }

        return conteudo;
    }
}
