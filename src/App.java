import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao;
        try (Scanner entrada = new Scanner(System.in)) {
            Relatorio report = new Relatorio();
            Carregador load = new Carregador();
            ArrayList<Aeroporto> aero = load.leAeroportos();
            ArrayList<Voo> vo = load.leVoo();
            ArrayList<Rota> ro = load.leRota();
            String siglaA1, siglaA2;


            do{
                System.out.println("*** Simulador de Tráfego Aéreo ***\n");
                System.out.println("\tMENU DE OPÇÕES\n\n1- Mostrar o Registro de Aeroportos\n\n2- Mostrar o Grafo de Voos\n\n3- Mostrar o grafo de rotas\n");
                System.out.println("4- Mostrar o caminho de um aeroporto até outro\n\n5- Mostrar voos diretos que saem de um aeroporto\n\n6- Verificar menor rota\n");
                System.out.println("7- Verificar possibilidade de rota\n\n---> Digite sua opção: (Digite 0 pra sair)");
                opcao = entrada.nextInt();

                switch(opcao){
                    case 0:
                        System.out.println("\n\nSaindo do programa.....\n\n");
                        System.exit(0);
                    break;

                    case 1:
                        report.listagemAeroportos(aero);
                    break;

                    case 2:
                        report.listagemVoos(vo);
                    break;

                    case 3:
                        report.listagemRotas(ro);
                    break;

                    case 4:
                        siglaA1 = entrada.next("Digite a sigla do aeroporto de origem: ");
                        siglaA2 = entrada.next("Digite a sigla do aeroporto de destino: ");
                        report.mostraCaminho(siglaA1, siglaA2, ro);
                    break;

                    case 5:
                        siglaA1= entrada.next("Digite a sigla do aeroporto: ");
                        report.vooSemEscalas(siglaA1, vo, ro);
                    break;

                    case 6: 
                        siglaA1 = entrada.next("Digite a sigla do aeroporto de origem: ");
                        siglaA2 = entrada.next("Digite a sigla do aeroporto de destino: ");
                        report.menorCusto(siglaA1, siglaA2, ro);
                    break;

                    case 7:
                        siglaA1 = entrada.next("Digite a sigla do aeroporto: ");
                        report.possivelAtingir(siglaA1, ro, aero);
                    break;

                    default:
                        System.out.println("\n\nOpção inválida, tente novamente\n\n");
                    break;
                }

                
            }while(opcao != 0);
        }


        

        
    }
}
