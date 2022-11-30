public class Horario {
    Float valor;
    String indicador;

    public Horario(){}

    public Horario(Float valor, String indicador){
        this. valor = valor;
        this.indicador = indicador;
    }

    @Override
    public String toString() {
        return valor+indicador;
    }
}
