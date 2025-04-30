package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository {

    void procurarPoNumero(int numero);

    void listarTodos();

    void cadastrar(Conta conta);

    void atualizar(Conta conta);

    void deletar(int numero);

    void sacar(int numero, float valor);

    void depositar(int numero, float valor);

    void transferir(int contaOrigem, int contaDestino, float valor);

}
