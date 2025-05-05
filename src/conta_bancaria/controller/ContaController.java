package conta_bancaria.controller;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

import java.util.ArrayList;
import java.util.Optional;

public class ContaController implements ContaRepository {

    private ArrayList<Conta> listaContas = new ArrayList<>();

    int numeroContas = 0;

    @Override
    public void procurarPoNumero(int numero) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            conta.get().visualizar();
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
        Optional<Conta> buscaConta = buscarNaCollection(conta.getNumero());

        if (buscaConta.isPresent()) {
            listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
            System.out.printf("A Conta de número %d foiatualizada com sucesso!", conta.getNumero());
        } else {
            System.out.printf("A Conta de número %d não foi encontrada ", conta.getNumero());
        }
    }

    @Override
    public void deletar(int numero) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            if (listaContas.remove(conta.get())) {
                System.out.printf("A Conta de número %d foi excluido com sucesso! ", numero);
            }
        } else {
            System.out.printf("A Conta de número %d não foi encontrada ", numero);
        }
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

    public Optional<Conta> buscarNaCollection(int numero) {
        for (var conta : listaContas) {
            if (conta.getNumero() == numero) {
                return Optional.of(conta);
            }
        }
        return Optional.empty();
    }
}
