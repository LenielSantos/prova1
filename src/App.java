import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws InterruptedException, IOException {
        final int TAM_ELEMENTOS = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Piloto> pilotos = new ArrayList<>();
            Scanner in = new Scanner(System.in);
            int UNICadastro = 0;

            int opcao;
            do {
                System.out.println("\n1 - Cadastrar seu Piloto");
                System.out.println("2 - Listar seu pilotos conosco");
                System.out.println("3 - Consulte seu espaço aqui!");
                System.out.println("4 - Aumente o seu espaço!");
                System.out.println("0 - Sair");
                System.out.print("\nDigite a opção desejada ? =>: ");
                opcao = in.nextInt();
                in.nextLine();

                switch (opcao) {
                    case 1: {

                        if (UNICadastro == TAM_ELEMENTOS) {

                            System.out.println(
                                    "\n ATENÇÃO !! Estamos sem  espaço para cadastrar pilotos. \n Vai para a opção 4 do Menu!");
                            System.out.println(" O espaco Atual é de: ( " + UNICadastro + " )");
                            System.out.println(" Lista nova é: ( " + pilotos.size() + " )");

                            voltarMenu(in);
                            continue;
                        } else {
                            System.out.println("Digite o nome do Piloto");
                            String nome = scanner.next();
                            System.out.println("Digite o cpf do Piloto");
                            String cpf = scanner.next();

                            Piloto Piloto = new Piloto(nome, cpf);
                            pilotos.add(Piloto);
                            UNICadastro--;
                            System.out.println("Piloto adicionado!");

                            voltarMenu(in);
                            break;

                        }
                    }
                    case 2:

                        if (UNICadastro == 0) {

                            System.out.println("\nMotoristas cadastrados para exibir.\n");

                        } else {

                            System.out.println("\nListagem de pilotos:\n" + pilotos + "\n");

                            break;
                        }

                    case 3: {
                        System.out.println(" O espaco Atual é: ( " + UNICadastro + " )\n");
                        System.out.println(" O tamanho da lista e: ( " + pilotos.size() + " )");
                        System.out.println("Aumente na opçâo ( 4 ) do Menu..");

                        break;
                    }

                    case 4: {
                        System.out.println("Digite a quantidade que vc precisa!");
                        UNICadastro = scanner.nextInt();

                        break;

                    }
                    default: {
                        System.out.println("Opção inválida!");
                        break;

                    }
                }

            } while (opcao != 0);

            System.out.println("Fim do programa!");
        }

    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu. \n Força Aérea Brasileira (FAB) ");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();

    }
}
