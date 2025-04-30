package conta_bancaria;

import conta_bancaria.controller.ContaController;
import conta_bancaria.exception.ContaException;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ContaController contas = new ContaController();

        int opcao, numero, agencia, tipo, aniversario;
        float saldo, limite;
        String titular;

        ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 1322, 2000, 1, "Angelo dos Santos", 1000);
        contas.cadastrar(cc1);
        ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 1354, 2000, 2, "Angelo dos Santos", 1);
        contas.cadastrar(cp1);

        while (true) {
            System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +
                    """
                            *******************************************************
                                            
                                            BANCO DO BRAZIL COM Z
                                            
                            *******************************************************
                                            
                                        1 - Criar Conta
                                        2 - Listar todas as Contas
                                        3 - Biscar Conta por Número
                                        4 - Atualizar Dados da conta
                                        5 - Apagar Conta
                                        6 - Sacar
                                        7 - Depositar
                                        8 - Tranferir valores entre Contas
                                        9 - Sair
                                            
                            *******************************************************
                            Entre com a opção desejada :
                            """);


            try {
                opcao = scanner.nextInt();

                if (opcao == 9) {
                    sobre();
                    System.exit(0);
                }


                switch (opcao) {

                    case 1:
                        System.out.println("Criar Conta");
                        System.out.println("Digite o número da agencia");
                        agencia = scanner.nextInt();
                        scanner.skip("\\R");

                        System.out.println("Digite o nome do Titular");
                        titular = scanner.nextLine();

                        System.out.println("Digite o O tipo de cinta(1 - CC | 2 - CP)");
                        tipo = scanner.nextInt();

                        System.out.println("Digite o saldo da conta");
                        saldo = scanner.nextFloat();

                        switch (tipo) {
                            case 1 -> {
                                System.out.println("Digite o limite da Conta");
                                limite = scanner.nextFloat();
                                contas.cadastrar(new ContaCorrente(agencia, contas.gerarNumero(), saldo, tipo, titular, limite));
                            }
                            case 2 -> {
                                System.out.println("Digite o Aniversário da Conta");
                                aniversario = scanner.nextInt();
                                contas.cadastrar(new ContaPoupanca(agencia, contas.gerarNumero(), saldo, tipo, titular, aniversario));
                            }
                            default -> System.out.println(Cores.TEXT_RED_BOLD +
                                    "Click 1 - CC ou 2 - CP, a opção de número " + tipo + " que foi digitada por vc é inválida. Tente novamente ...Obrigado!");
                        }
                        keyPress();
                        break;
                    case 2:
                        System.out.println("Listar todas as Contas");
                        contas.listarTodos();
                        keyPress();
                        break;
                    case 3:
                        System.out.println("Consultar dados da conta por número");

                        System.out.println("Digite o número da conta");
                        numero = scanner.nextInt();
                        contas.procurarPoNumero(numero);
                        keyPress();
                        break;
                    case 4:
                        System.out.println("");
                        keyPress();
                        break;
                    case 5:
                        System.out.println("");
                        keyPress();
                        break;
                    case 6:
                        System.out.println("");
                        keyPress();
                        break;
                    case 7:
                        System.out.println("");
                        keyPress();
                        break;
                    case 8:
                        System.out.println("");
                        keyPress();
                        break;
                    default:
                        System.out.println("");
                        keyPress();
                        break;
                }
            } catch (InputMismatchException e) {
                throw new ContaException(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +
                        "Tente novamente e digite os valores corretamente...Obrigado!");
            }
        }

    }

    public static void sobre() {
        System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + """
                *******************************************************
                Projecto Desenvolvido por : Ângelo dos Santos.
                Generation Brasil - angelokapunda@gmail.com
                GitHub : github.com/angelokapunda
                Linkedin : linkedin.com/in/angelokapunda
                *******************************************************
                """);
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Ocorreu um erro ao tentar ler o teclado");
        }
    }
}
