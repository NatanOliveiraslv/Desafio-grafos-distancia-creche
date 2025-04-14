public class Creche {

    private static int idContador = 0;
    private final int id;
    private String nome;
    private Creche proximo; //usado para criar a lista encadeada

    public Creche(String nome) {
        this.id = idContador;
        idContador++;
        this.nome = nome;
        this.proximo = null;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Creche getProximo() {
        return proximo;
    }

    public void setProximo(Creche proximo) {
        this.proximo = proximo;
    }
}
