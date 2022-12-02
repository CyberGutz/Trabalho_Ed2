public class Voo {
    double numeroDoVoo, paradas;
    Aeroporto origem = new Aeroporto();
    Aeroporto destino = new Aeroporto();
    String saida, chegada;

    public Voo(){

    }
    public Voo(double numeroDoVoo, Aeroporto origem, Aeroporto destino, String saida, String chegada, double paradas){
        this.numeroDoVoo = numeroDoVoo;
        this.origem = origem;
        this.destino = destino;
        this.saida = saida;
        this.chegada = chegada;
        this.paradas = paradas;
    }

    public double getNumeroDoVoo() {
        return numeroDoVoo;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    public String getSaida() {
        return saida;
    }

    public String getChegada() {
        return chegada;
    }

    public double getParadas() {
        return paradas;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public void setDestino(Aeroporto destino) {
        this.destino = destino;
    }

    public void setNumeroDoVoo(double numeroDoVoo) {
        this.numeroDoVoo = numeroDoVoo;
    }

    public void setOrigem(Aeroporto origem) {
        this.origem = origem;
    }

    public void setParadas(double paradas) {
        this.paradas = paradas;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    @Override
    public String toString() {
        return "\n\nDados do Voo: \n\nNumero do Voo: " + numeroDoVoo + "\nAeroporto de origem: \n" + origem.toString() + "\nHorario de saída: "+ saida.toString() +"\nAeroporto destino: \n" + destino.toString() + "\nHorario de chegada: "+ chegada.toString() + "\nParadas até o destino: " + paradas + "\n";
    }
}
