package conta_bancaria;

import conta_bancaria.util.Cores;

public class Menu {

    public static void main(String[] args) {

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
