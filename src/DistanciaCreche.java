public class DistanciaCreche {

    private int IdCrecheInicio;
    private int IdCrecheFim;
    private float distancia;
    private DistanciaCreche proximo; //usado para criar a lista encadeada

    public DistanciaCreche(int crecheInicio, int crecheFim, float distancia) {
        this.IdCrecheInicio = crecheInicio;
        this.IdCrecheFim = crecheFim;
        this.distancia = distancia;
        this.proximo = null;
    }

    public DistanciaCreche(){
        this.proximo = null;
    }

    public int getCrecheInicio() {
        return IdCrecheInicio;
    }

    public int getCrecheFim() {
        return IdCrecheFim;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setIdCrecheInicio(int idCrecheInicio) {
        IdCrecheInicio = idCrecheInicio;
    }

    public void setIdCrecheFim(int idCrecheFim) {
        IdCrecheFim = idCrecheFim;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public DistanciaCreche getProximo() {
        return proximo;
    }

    public void setProximo(DistanciaCreche proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        return "DistanciaCreche{" +
                "IdCrecheInicio=" + IdCrecheInicio +
                ", IdCrecheFim=" + IdCrecheFim +
                ", distancia=" + distancia +
                ", proximo=" + proximo +
                '}';
    }
}
