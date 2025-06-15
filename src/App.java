import java.util.Scanner;

public class App {

    private static int gerarIdAleatorio() {
        return (int)(Math.random() * 900) + 100; // 100 a 999
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fila fila = new Fila();
        ArvoreBinaria arvore = new ArvoreBinaria();

        boolean executa = true;

        while(executa){
            
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Chegada de usuário");
            System.out.println("2 - Atendimento de usuário");
            System.out.println("3 - Status da fila");
            System.out.println("4 - Relatório de atendimentos");
            System.out.println("5 - Verificar situação de uma pessoa");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // consumir quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome do usuário: ");
                    String nome = scanner.nextLine();
                    int id = gerarIdAleatorio();
                    Pessoa nova = new Pessoa(nome, id);
                    fila.enfileira(nova);
                    System.out.println("Usuário " + nome + " inserido na fila com ID " + id);
                    break;

                case 2:
                    if (fila.filaVazia()) {
                        System.out.println("Fila vazia. Ninguém para atender.");
                    } else {
                        Pessoa atendida = fila.desenfileira();
                        System.out.println("Atendendo: " + atendida);
                        arvore.inserir(atendida);
                    }
                    break;

                case 3:
                    System.out.println("=== Pessoas na fila ===");
                    fila.imprimirFila();
                    break;

                case 4:
                    System.out.println("=== Relatório de atendimentos ===");
                    arvore.imprimirEmOrdem();
                    break;

                case 5:
                    System.out.print("Nome da pessoa a buscar: ");
                    String busca = scanner.nextLine();
                    int pos = fila.buscarPosicao(busca);
                    if (pos > 0) {
                        System.out.println(busca + " está aguardando na posição " + pos);
                    } else if (arvore.foiAtendida(busca)) {
                        System.out.println(busca + " já foi atendida.");
                    } else {
                        System.out.println(busca + " não encontrada.");
                    }
                    break;

                case 0:
                    executa = false;
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }


    }
}
