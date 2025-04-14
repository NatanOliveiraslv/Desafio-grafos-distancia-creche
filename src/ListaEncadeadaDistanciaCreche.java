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

    //retorna distancia
    public Float retornaDistancia(int crecheInicio, int crecheFim){
        DistanciaCreche aux = this.head;
        while (aux != null) {
            if (aux.getCrecheInicio() == crecheInicio && aux.getCrecheFim() == crecheFim) {
                return aux.getDistancia();
            }
            aux = aux.getProximo();
        }
        return null;
    }

    //Retorna o quantidade de posicoes ocupadas
    public int getQtdPosicoesOcupadas() {
        return qtdPosicoesOcupadas;
    }
}
