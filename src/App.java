import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int opcao;
        Scanner entrada = new Scanner(System.in);
        Carregador load = new Carregador();
        ArrayList aero = load.leAeroportos();
        ArrayList vo = load.leVoo();
        ArrayList ro = load.leRota();


        do{
            System.out.println("*** Simulador de Tráfego Aéreo ***\n");
            System.out.println("\tMENU DE OPÇÕES\n\n1- Mostrar o Registro de Aeroportos\n\n2- Mostrar o Grafo de Voos\n\n3- Mostrar o grafo de rotas\n\n");
            System.out.println("4- Mostrar o caminho de um aeroporto até outro\n\n5- Mostrar voos diretos que saem de um aeroporto\n\n6- Verificar possibilidade de rota de um aeroporto até outro\n\n");
            System.out.println("7- Verificar Rota completa e circuito Hamiltoniano\n\n---> Digite sua opção: (Digite 0 pra sair)");
            opcao = entrada.nextInt();

            switch(opcao){
                case 0:
                    System.out.println("\n\nSaindo do programa.....\n\n");
                    System.exit(0);
                break;

                case 1:

                break;

                case 2:

                break;

                case 3:

                break;

                case 4:

                break;

                case 5:

                break;

                case 6: 

                break;

                case 7:

                break;

                default:
                    System.out.println("\n\nOpção inválida, tente novamente\n\n");
                break;
            }

            
        }while(opcao != 0);


        

        
    }
}
