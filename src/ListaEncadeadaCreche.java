public class ListaEncadeadaCreche {
    private Creche head;
    private int qtdPosicoesOcupadas = 0;

    public ListaEncadeadaCreche() {
    }

    //Adicionar creche
    public void adicionar(Creche creche) {

        //inser o obeto no head caso esteja nulo
        if (this.head == null) {
            this.head = creche;
            this.qtdPosicoesOcupadas++;
            return;
        }

        Creche aux = this.head;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }

        aux.setProximo(creche);
        this.qtdPosicoesOcupadas++;
    }

    //Remover creche
    public boolean remover(Creche creche) {

        //validação para caso haja somente o primeiro valor
        if (this.head.getProximo() == null) {
            if (this.head.equals(creche)) {
                this.head = null;
                qtdPosicoesOcupadas--;
                return true;
            }
        }

        Creche aux = this.head;
        Creche auxValorAnterior;

        for (int i = 0; i < qtdPosicoesOcupadas; i++) {
            auxValorAnterior = aux;
            aux = aux.getProximo();
            if (aux.equals(creche)) {
                auxValorAnterior.setProximo(aux.getProximo());
                qtdPosicoesOcupadas--;
                return true;
            }
        }

        return false;
    }

    //Retorno o Id pela creche
    public Integer retornaId(Creche creche) {

        int posicao = 0;

        if (this.head.getProximo() == null) {
            if (this.head.equals(creche)) {
                return posicao;
            }
        }

        Creche aux = this.head;

        while (aux.getProximo() != null) {
            aux = aux.getProximo();
            if (aux.equals(creche)) {
                return posicao;
            }
            posicao++;
        }
        return null;
    }

    //Visualizar lista completa
    public Creche[] conteudo() {

        if (qtdPosicoesOcupadas == 0) {
            return null;
        }

        Creche aux = this.head;
        Creche[] lista = new Creche[this.qtdPosicoesOcupadas];
        int i = 0;

        while (aux.getProximo() != null) {
            lista[i] = aux;
            aux = aux.getProximo();
            i++;
        }

        lista[i] = aux; //utilizado para armazenar o ultimo elemento tambem na lista
        return lista;
    }

    //Retorna o quantidade de posicoes ocupadas
    public int getQtdPosicoesOcupadas() {
        return qtdPosicoesOcupadas;
    }

    //Retorna a creche pelo ID
    public Creche retornaCreche(int id){
        Creche aux = this.head;

        while(aux.getProximo() != null){
            if(aux.getId() == id){
                return aux;
            }
            aux = aux.getProximo();
        }
        return null;
    }

}