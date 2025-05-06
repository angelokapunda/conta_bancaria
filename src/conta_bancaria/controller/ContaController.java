package conta_bancaria.controller;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

import java.util.ArrayList;
import java.util.List;
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
    public void listarPorTitular(String titular) {
        List<Conta> listaTitulares = listaContas.stream()
                .filter(c -> c.getTitular().toUpperCase().contains(titular.toUpperCase()))
                .toList();
        if (listaTitulares.isEmpty()) {
            System.out.println("Nenhuma Conta foi encontrada com base no critério " + titular);
        }
        for (var conta : listaTitulares) {
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
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            if (conta.get().sacar(valor)) {
                System.out.printf("O Saque no valor de %f foi efectuado com sucesso na conta %d",
                        valor, numero);
            }
        } else {
            System.out.printf("A Conta de número %d não foi encontrada ", numero);
        }
    }

    @Override
    public void depositar(int numero, float valor) {
        Optional<Conta> conta = buscarNaCollection(numero);

        if (conta.isPresent()) {
            conta.get().depositar(valor);
            System.out.printf("O deposito no valor de %f foi efectualdo com sucesso na conta %d",
                    valor, numero);
        } else {
            System.out.printf("A Conta de número %d não foi encontrada ", numero);
        }
    }

    @Override
    public void transferir(int numeroOrigem, int numeroDestino, float valor) {
        Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
        Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

        if (contaOrigem.isPresent() && contaDestino.isPresent()) {
            if (contaOrigem.get().sacar(valor)) {
                contaDestino.get().depositar(valor);
                System.out.printf("A transferencia  no valor de %f da conta %d para a conta %d foi efectuado com sucesso ",
                        valor, numeroOrigem, numeroDestino);
            }
        } else {
            System.out.printf("A Conta de número %d não foi encontrada ", numeroOrigem);
        }
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
