import java.text.DecimalFormat;

public class Rota {
    private Aeroporto origem = new Aeroporto();
    private Aeroporto destino = new Aeroporto();
    DecimalFormat formatador = new DecimalFormat("0.00");
    private double distancia;

    public Rota(){
        distancia = calculaDistancia();
    }

    public Rota(Aeroporto origem, Aeroporto destino){
        this.origem = origem;
        this.destino = destino;
        distancia = calculaDistancia();
    }

    public double calculaDistancia(){
        double x = destino.getXcord() - origem.getXcord();              //(Xb - Xa)
        double y = destino.getYcord() - origem.getYcord();              //(Yb - Ya)

        x = Math.pow(x,2);                                           //(xb - xa)²
        y = Math.pow(y,2);                                           //(yb - ya)²

        return Math.sqrt(x+y);                                         //Completa a formula √(xb - xa)² + (yb - ya)²                b = destino     a = origem
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }
    
    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Aeroporto getOrigem(){
        return this.origem;
    }

    public Aeroporto getDestino() {
        return this.destino;
    }

    public double getDistancia() {
        return this.distancia;
    }

    @Override
    public String toString() {
            return "\nAeroporto Origem: \n\n" + origem.toString() + "\n\nAeroporto Destino: \n\n" + destino.toString() + "\n\nDistancia entre os dois aeroportos: " + formatador.format(distancia);
    }

}
