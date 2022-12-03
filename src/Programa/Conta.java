package Programa;

import utilitarios.Utils;

public class Conta {
    private static int contadorDeContas = 1;

    private int numeroDaConta;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.numeroDaConta = contadorDeContas;
        this.cliente = cliente;
        contadorDeContas =+ 1;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "\nConta: " + getNumeroDaConta() +
                "\nNome: " + cliente.getNome() +
                "\nCPF: " + cliente.getCpf() +
                "\nemail: " + cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(getSaldo()) +
                "\n";
    }

    public void depositar(Double valor){
        if (valor > 0){
            setSaldo(getSaldo() + valor);
            System.out.println("Seu deposito foi realizado!");
        }else{
            System.out.println("Não foi possivel realizar seu deposito");
        }
    }

    public void sacar(Double valor){
        if (valor > 0 && getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque foi realizado");
        }else{
            System.out.println("Seu saque não pode ser realizado");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor){
        if (valor > 0 && getSaldo() >= valor){
            setSaldo(getSaldo() - valor);
            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso");
        }else{
            System.out.println("Não foi possivel realizar sua tranferência");
        }
    }
}
