import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Conta {

  static Scanner input = new Scanner(System.in);
  static Random aleatory = new Random();
    
  private String nome;
  private long cpf;
  private String agencia;
  private int numConta;
  private int senhaConta;
  private double saldo;

  //Constructor
  public Conta(String nome, long cpf, String agencia, int numConta, int senhaConta, double saldo) {
    this.setNome(nome);
    this.setCpf(cpf);
    this.setAgencia(agencia);
    this.setNumConta(numConta);
    this.setSenhaConta(senhaConta);
  }

  
//Getter & setter methods   
public int getSenhaConta() {
    return senhaConta;
  }
public void setSenhaConta(int senhaConta) {
    this.senhaConta = senhaConta;
  }
public int getNumConta() {
    return numConta;
  }
public void setNumConta(int numConta) {
    this.numConta = numConta;
  }
public String getAgencia() {
    return agencia;
  }
public void setAgencia(String agencia) {
    this.agencia = agencia;
  }
public long getCpf() {
    return cpf;
  }
public void setCpf(long cpf) {
    this.cpf = cpf;
  }
public String getNome() {
    return nome;
  }
public void setNome(String nome) {
    this.nome = nome;
  }
public double getSaldo(){
   return saldo;
}
public void setSaldo(double saldo){
  this.saldo = saldo;
}




public static void sacar(Conta conta, String[] args){
  System.out.println("--------------------------------");
  System.out.println("SEU SALDO ATUAL: R$ " + conta.getSaldo() + ",00");
  System.out.println("--------------------------------");
  System.out.println("");
  System.out.println("QUAL VALOR DESEJA SACAR ?"); 
   double valorDigitado = input.nextDouble();
    if(valorDigitado > conta.getSaldo()){
      System.out.println("Valor digitado ultrapassa o saldo atual"); 
      System.out.println("Digite novo valor de saque:"); 
       valorDigitado = input.nextDouble();
        if(valorDigitado > conta.getSaldo()){
          System.out.println("Valor digitado ultrapassa o saldo atual");
          System.out.println("OPERAÇÃO ENCERRADA!");
           System.exit(0);
        }
    } 
    conta.setSaldo(conta.getSaldo() - valorDigitado);
     System.out.println("--------------------------------");
     System.out.println("Saque realizado com sucesso !");
     System.out.println("Valor do saque: R$ " + valorDigitado + ",00");
     System.out.println("Saldo atual: R$ " + conta.getSaldo() + ",00");
     System.out.println("--------------------------------");
      System.out.print("Voltar ao início ? Sim-1, Não-2");
       int option = input.nextInt();
        if(option == 1){
          Menu.main(args);
        }else{
          System.exit(0);
        }
 }


public static void depositar(Conta conta, String[] args){
  System.out.println("--------------------------------");
  System.out.println("SEU SALDO ATUAL: R$ " + conta.getSaldo() + ",00");
  System.out.println("--------------------------------");
  System.out.println("");
  System.out.println("QUAL VALOR DESEJA DEPOSITAR ?"); 
   double valorDigitado = input.nextDouble();
    conta.setSaldo(valorDigitado);
     System.out.println("--------------------------------");
     System.out.println("Depósito realizado com sucesso !");
     System.out.println("Valor do depósito: R$ " + valorDigitado + ",00");
     System.out.println("Saldo atual: R$ " + conta.getSaldo() + ",00");
     System.out.println("--------------------------------");
      System.out.print("Voltar ao início ? Sim-1, Não-2");
       int option = input.nextInt();
        if(option == 1){
          Menu.main(args);
        }else{
          System.exit(0);
        }
 }


public static void acessarConta(ArrayList<Conta> listaContas, String[] args){
  System.out.println("INFORME O NÚMERO DA CONTA:");
         int numDigitado = input.nextInt();
        System.out.println("INFORME A SENHA DE 4 DÍGITOS");
         int senhaDigitada = input.nextInt();

          //verifica se a conta já existe percorrendo a 'listaContas'
          for(int i = 0; i < listaContas.size(); i++){
              //Se o número de conta existe
              if(listaContas.get(i).getNumConta() == numDigitado){ 
                //Se a senha corresponde ao número da conta
                if(listaContas.get(i).getSenhaConta() == senhaDigitada){
                  //Chamada do método da classe 'Conta'
                  Conta.imprimirDetalhesConta(listaContas.get(i));

                  System.out.println("SELECIONE UMA OPÇÃO:");
                   System.out.println("(1) - SACAR");
                   System.out.println("(2) - DEPOSITAR");
                    int option = input.nextInt();
                     if(option == 1){
                       Conta.sacar(listaContas.get(i), args);
                     }else{
                       Conta.depositar(listaContas.get(i), args);
                     }

                }
              }
            }
}



public static void imprimirDetalhesConta(Conta conta){
 System.out.print("-----DADOS DA CONTA-----");
  if(conta instanceof ContaPoupanca){
    System.out.println();
  }else{
    System.out.println();
  }
 System.out.println("TITULAR: " + conta.getNome());
 System.out.println("CPF: " + conta.getCpf());
 System.out.println("AGÊNCIA: " + conta.getAgencia());
 System.out.println("CONTA: " + conta.getNumConta());
 System.out.println("------------------------");
}

public static void abrirConta(ArrayList<Conta> listaContas, String[] args){
 System.out.println("QUAL O TIPO DE CONTA DESEJA ABRIR ?");
  System.out.println("(1) - POUPANÇA");
  System.out.println("(2) - CORRENTE");
   System.out.println("(3) - VERIFICAR DIFERENÇAS ENTRE OS TIPOS");
  int option = input.nextInt();

  switch(option){
    
    case 1: System.out.println("INFORME SEU NOME:"); 
       String nomeDigitado = input.nextLine();
         System.out.println();
         long cpfDigitado = input.nextLong();
           System.out.println();
           int senhaDigitada = input.nextInt();
       //Instance of 'ContaPoupanca' object   
       ContaPoupanca CP = new ContaPoupanca(nomeDigitado,cpfDigitado,"3920-9",aleatory.nextInt((10000-1000) + 1) + 1000,senhaDigitada, 0);
       //Add the object 'CP' to the 'listaContas'
       listaContas.add(CP);
       //Confirma que a conta foi criada com sucesso
       System.out.println();
       Conta.imprimirDetalhesConta(CP);

       System.out.println("Voltar ao início ? Sim-1, Não-2");
       input.nextInt();
        if(option == 1){
          Menu.main(args);
        }else{
          System.exit(0);
        }

  }

}




}
