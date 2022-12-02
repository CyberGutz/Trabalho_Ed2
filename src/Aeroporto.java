public class Aeroporto{
    private String sigla, nome;
    private double timezone, xcord, ycord;

    public Aeroporto(){}

    public Aeroporto(String sigla, String nome, int timezone, int xcord, int ycord){
        this.sigla = sigla;
        this.nome = nome;
        this.timezone = timezone;
        this.xcord = xcord;
        this.ycord = ycord;
    }

    public String getSigla() {
        return this.sigla;
    }

    public String getNome() {
        return this.nome;
    }

    public double getTimezone() {
        return timezone;
    }

    public double getXcord() {
        return xcord;
    }

    public double getYcord() {
        return ycord;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTimezone(double d) {
        this.timezone = d;
    }

    public void setXcord(double xcord) {
        this.xcord = xcord;
    }

    public void setYcord(double ycord) {
        this.ycord = ycord;
    }

    @Override
    public String toString() {
        return "Dados do Aeroporto\n\nNome: " + nome + "\tSigla: " + sigla + "\nTimezone: " + timezone + "\tCoordenada X: " + xcord + "\tCoordenada Y: " + ycord+"\n\n";
    }
}