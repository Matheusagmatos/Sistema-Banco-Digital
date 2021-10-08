package src;
public class ContaPoupanca extends Conta{

    public ContaPoupanca(String nome, long cpf, String string, int numConta, int senhaConta, double saldo) {
        super(nome, cpf, string, numConta, senhaConta, saldo);
    }

    @Override
    public static void depositar(Conta conta, String[] args){

    }



}
