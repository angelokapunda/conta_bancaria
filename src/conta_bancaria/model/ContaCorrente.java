package conta_bancaria.model;

public class ContaCorrente extends Conta {

    private float limite;

    public ContaCorrente(int agencia, int numero, float saldo, int tipo, String titular, float limite) {
        super(agencia, numero, saldo, tipo, titular);
        this.limite = limite;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Liminte da conta: " + limite);
    }

    @Override
    public boolean sacar(float valor) {
        if ((getSaldo() + limite) < valor) {
            System.out.println("O Saldo é insuficiente");
            return false;
        }
        setSaldo(getSaldo() - valor);
        return true;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }
}
