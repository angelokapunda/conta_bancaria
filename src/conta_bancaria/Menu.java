package conta_bancaria;

import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

    public static void main(String[] args) {


        ContaCorrente contaCorrente = new ContaCorrente(
                0001, 2342, 2000, 1, "Angelo dos Santo", 1000);

        contaCorrente.visualizar();

        contaCorrente.sacar(3001);
        contaCorrente.visualizar();

        ContaPoupanca contaPoupanca = new ContaPoupanca(
                0001, 2342, 2000, 1, "Angelo dos Santo", 5);
        contaPoupanca.visualizar();

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
    }

    public static void sobre() {
        System.out.println(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND + """
                *******************************************************
                Projecto Desenvolvido por : Ângelo dos Santos.
                Generation Brasil - angelokapunda@gmail.com
                github.com/angelokapunda
                *******************************************************
                """);
    }
}
