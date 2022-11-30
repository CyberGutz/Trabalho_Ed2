import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.security.sasl.SaslException;
import javax.sound.midi.Soundbank;

public class Carregador {

    private BufferedReader leitorAeroportos;
    private BufferedReader leitorVoos;
    private BufferedReader leitorRotas;

    StringTokenizer st;

    ArrayList<Aeroporto> aero = new ArrayList<Aeroporto>();
    ArrayList<Voo> vo = new ArrayList<Voo>();
    ArrayList<Rota> ro = new ArrayList<Rota>();
    Aeroporto aux;
    Voo vAux;
    Rota rAux;

    public Carregador() {

    }

    public Aeroporto percorreAero(String sigla, ArrayList<Aeroporto> li) {
        Aeroporto aux = new Aeroporto();
        int i;

        for(i=0; i<li.size(); i++){
            if(li.get(i).getSigla().equals(sigla)){
                aux = li.get(i);
                break;
            }
        }
        
        return aux;
    }

    public ArrayList<Aeroporto> leAeroportos() throws IOException{
        leitorAeroportos = new BufferedReader(new FileReader("Aeroportos.txt"));
        String frase = "";

        while (frase != null){  
            aux = new Aeroporto();
            frase = leitorAeroportos.readLine();
            st = new StringTokenizer(frase);

            if (frase.equals("#")){
                break;
            }
            
            aux.setSigla(st.nextToken(","));
            aux.setNome(st.nextToken(","));
            aux.setTimezone(Double.parseDouble(st.nextToken(",")));
            aux.setXcord(Double.parseDouble(st.nextToken(",")));
            aux.setYcord(Double.parseDouble(st.nextToken(",")));

            aero.add(aux);
        }

        return aero;
    }

    public ArrayList<Voo> leVoo() throws IOException {
        if (aero == null) {
            System.out.println("Lista de Aeroportos vazia, encerrando programa...");
            System.exit(-1);
        }

        leitorVoos = new BufferedReader(new FileReader("Voos.txt"));
        String frase = "";
        String sAux;

        while (frase != null) {
            vAux = new Voo();
            aux = new Aeroporto();
            frase = leitorVoos.readLine();
            st = new StringTokenizer(frase);

            if (frase.equals("#")){
                break;
            }
            
            vAux.setNumeroDoVoo(Double.parseDouble(st.nextToken(",")));

            sAux = st.nextToken(",");
            aux = percorreAero(sAux, aero);
            vAux.setOrigem(aux);
            vAux.setSaida(st.nextToken(","));

            sAux = st.nextToken(",");
            aux = percorreAero(sAux, aero);
            vAux.setDestino(aux);

            vAux.setChegada(st.nextToken(","));

            vAux.setParadas(Double.parseDouble(st.nextToken(",")));

            vo.add(vAux);
        }
        return vo;
    }

    public ArrayList<Rota> leRota() throws IOException {
        if (aero == null) {
            System.out.println("Lista de Aeroportos vazia, encerrando programa...");
            System.exit(-1);
        }

        leitorRotas = new BufferedReader(new FileReader("Rotas.txt"));
        String frase = "";
        String sAux;
        rAux = new Rota();
        aux = new Aeroporto();

        while (frase != null) {
            frase = leitorRotas.readLine();
            st = new StringTokenizer(frase);

            if (frase.equals("#")){
                break;
            }

            sAux = st.nextToken(",");
            aux = percorreAero(sAux, aero);
            rAux.setOrigem(aux);

            sAux = st.nextToken(",");
            aux = percorreAero(sAux, aero);
            rAux.setDestino(aux);

            double dist = rAux.calculaDistancia();
            rAux.setDistancia(dist);

            ro.add(rAux);
        }

        return ro;
    }
}
