import java.util.ArrayList;

public class Relatorio {

    public Relatorio(){

    }

    public void listagemAeroportos(ArrayList<Aeroporto> aero){
        for(int i = 0; i < aero.size(); i++){
            System.out.println(aero.get(i).toString());
        }
    }

    public void listagemVoos(ArrayList<Voo> vo){
        for(int i = 0; i < vo.size(); i++){
            System.out.println(vo.get(i).toString());
        }
    }

    public void listagemRotas(ArrayList<Rota> ro){
        for(int i = 0; i < ro.size(); i++){
            System.out.println(ro.get(i).toString());
        }
    }

    public void mostraCaminho(String siglaA1, String siglaA2, ArrayList<Rota> ro){
        ArrayList<Aeroporto> caminho = new ArrayList<Aeroporto>();
        int i;

        for(i=0; i<ro.size(); i++){
            if(ro.get(i).getOrigem().getSigla() == siglaA1){
                if(ro.get(i).getDestino().getSigla() == siglaA2){

                    caminho.add(ro.get(i).getOrigem());
                    caminho.add(ro.get(i).getDestino());
                    
                    System.out.println("Rota do aeroporto " + siglaA1 + " até o aeroporto " + siglaA2 +": ");
                    for(int j = 0; j< caminho.size(); j++){
                        System.out.println(caminho.get(i).toString());
                    }
                    return;
                }
                else{
                    caminho.add(ro.get(i).getOrigem());
                    caminho.add(ro.get(i).getDestino());
                    mostraCaminho(ro.get(i).getDestino().getSigla(), siglaA2, ro);
                }
            }
        }
        
    }

    public void vooSemEscalas(String sigla, ArrayList<Voo> vo, ArrayList<Rota> ro){
        ArrayList<Voo> aux = new ArrayList<Voo>();
        int i, j;
        
        System.out.println("Listas de voo sem escalas pro aeroporto " + sigla + ": \n");

        for(i = 0; i < vo.size(); i++){
            if(vo.get(i).getOrigem().getSigla() == sigla){
                if(vo.get(i).getParadas() == 0){
                    aux.add(vo.get(i));
                }
            }
        }

        for(i = 0; i < aux.size(); i++){
            for(j = 0; j < ro.size(); j++){
                if(aux.get(i).getOrigem() == ro.get(j).getOrigem()){
                    if(aux.get(i).getDestino() == ro.get(j).getDestino()){
                        System.out.println(aux.get(i).toString());
                    }
                }
            }
        }
    }

    public void menorCusto(String siglaA1, String siglaA2, ArrayList<Rota> ro){
        int i;
        double dist = 0;
        double distAux = 0;
        ArrayList<Aeroporto> rota = new ArrayList<>();
        ArrayList<Aeroporto> aux = new ArrayList<>();

        for(i=0; i<ro.size(); i++){
            if(ro.get(i).getOrigem().getSigla() == siglaA1){
                	if(ro.get(i).getDestino().getSigla() == siglaA2){
                        if(distAux <= dist){
                            aux.add(ro.get(i).getOrigem());
                            aux.add(ro.get(i).getDestino());
                            rota = aux;
                            dist = distAux;
                        }
                    }
                    else{
                        aux.add(ro.get(i).getOrigem());
                        aux.add(ro.get(i).getDestino());
                        distAux = distAux + ro.get(i).getDistancia();
                        menorCusto(ro.get(i).getDestino().getSigla(), siglaA2, ro);
                    }
            }
        }

        for(i=0; i<rota.size(); i++){
            System.out.println(rota.toString());
        }
    }

    public void possivelAtingir(String sigla, ArrayList<Rota> ro, ArrayList<Aeroporto> aero){
        int i;

        for(i=0; i<aero.size(); i++){
           mostraCaminho(sigla, aero.get(i).getSigla(), ro);
        }
    }

}
