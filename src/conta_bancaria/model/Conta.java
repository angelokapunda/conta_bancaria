package conta_bancaria.model;

import conta_bancaria.util.Cores;
import java.text.NumberFormat;

public class Conta {

    private String titular;
    private int numero;
    private int agencia;
    private int tipo;
    private float saldo;

    public Conta(int agencia, int numero, float saldo, int tipo, String titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.tipo = tipo;
        this.titular = titular;
    }

    public boolean sacar ( float valor) {
        if (this.saldo < valor) {
            System.out.println("O Saldo é insuficiente");
            return false;
        }
        this.saldo -= valor;
        return true;
    }

    public void depositar(float valor) {
        this.saldo += valor;
    }

    public void visualizar() {
        NumberFormat nfMoeda = NumberFormat.getNumberInstance();
        String tipo = "";

        switch (this.tipo) {
            case 1 -> tipo = "Conta Corrente";
            case  2 -> tipo = "Conta Poupança";
            default -> tipo = "Inválido";
        }
        System.out.printf(Cores.TEXT_GREEN_BOLD + Cores.ANSI_BLACK_BACKGROUND +
                """ 
                
                *************************************
                DADOS DA CONTA
                *************************************
                Nome do Titular : %s
                Tipo da Conta : %s
                Número da Âgencia : %d
                Número da Conta : %d
                Saldo da Conta : %s
                *************************************
                
                
               
                """,
        this.titular, tipo, this.agencia, this.numero, nfMoeda.format(this.saldo));
    }


    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
