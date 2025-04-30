package conta_bancaria.model;

public class ContaPoupanca extends Conta {

    private int aniversario;

    public ContaPoupanca(int agencia, int numero, float saldo, int tipo, String titular, int aniversario) {
        super(agencia, numero, saldo, tipo, titular);
        this.aniversario = aniversario;
    }

    @Override
    public void visualizar() {
        super.visualizar();
        System.out.println("Dia do Aniversário da Conta : " + aniversario);
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }
}
