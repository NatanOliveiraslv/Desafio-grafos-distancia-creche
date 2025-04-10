public class DistanciaCreche {

    int IdCrecheInicio;
    int IdCrecheFim;
    float distancia;

    public DistanciaCreche(int crecheInicio, int crecheFim, float distancia) {
        this.IdCrecheInicio = crecheInicio;
        this.IdCrecheFim = crecheFim;
        this.distancia = distancia;
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

}
