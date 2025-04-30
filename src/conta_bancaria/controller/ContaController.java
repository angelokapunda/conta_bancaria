package conta_bancaria.controller;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

import java.util.ArrayList;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<>();

    int numeroContas = 0;

    @Override
    public void procurarPoNumero(int numero) {
        var conta = buscarNaCollection(numero);

        if (conta != null) {
            conta.visualizar();
        } else {
            System.out.printf("A Conta de número %d não foi encontrada ", numero);
        }
    }

    @Override
    public void listarTodos() {
        for (var conta : listaContas) {
            conta.visualizar();
        }
    }

    @Override
    public void cadastrar(Conta conta) {
        listaContas.add(conta);
        System.out.println("Conta criada com sucesso!");
    }

    @Override
    public void atualizar(Conta conta) {

    }

    @Override
    public void deletar(int numero) {

    }

    @Override
    public void sacar(int numero, float valor) {

    }

    @Override
    public void depositar(int numero, float valor) {

    }

    @Override
    public void transferir(int contaOrigem, int contaDestino, float valor) {

    }

    public int gerarNumero() {
        return ++numeroContas;
    }

    public Conta buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}
