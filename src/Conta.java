package src;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;
import java.util.Locale;

public class Conta {

  static Scanner input = new Scanner(System.in);
  static Random aleatory = new Random();
  static Locale localeBR = new Locale("pt","BR");

  static NumberFormat realBrasileiro = NumberFormat.getCurrencyInstance(localeBR); //essa variável irá armazenar a formatação dos valores em na moeda 'Real Brasileiro'
    
  private String nome; //alterar nome para titular
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

  
//Getter & Setter methods   
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
  System.out.println("SEU SALDO ATUAL: " + realBrasileiro.format(conta.getSaldo()));
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
    }if(valorDigitado == 0){
      System.out.println("Valor inválido !");
      System.out.println("Digite um valor maior que zero");
      valorDigitado = input.nextDouble();
      if(valorDigitado == 0){
        System.out.println("Valor inválido !");
        System.out.println("OPERAÇÃO ENCERRADA!");
      }
    } 
    conta.setSaldo(conta.getSaldo() - valorDigitado);
     //Verifica se o saque foi realizado em conta corrente e cobra a taxa correspondente
     System.out.println("--------------------------------");
     System.out.println("Saque realizado com sucesso !");
     System.out.println("Valor do saque: " + realBrasileiro.format(valorDigitado));
     if(conta instanceof ContaCorrente){
       if(conta.getSaldo() >= 6.50){
         conta.setSaldo(conta.getSaldo() - 6.50);
         System.out.println("Taxa saque conta corrente: R$ 6,50");
       }
     }
     System.out.println("Saldo atual: " + realBrasileiro.format(conta.getSaldo())); 
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
  System.out.println("SEU SALDO ATUAL: " + realBrasileiro.format(conta.getSaldo())); 
  System.out.println("--------------------------------");
  System.out.println("");
  System.out.println("QUAL VALOR DESEJA DEPOSITAR ?"); 
   double valorDigitado = input.nextDouble();
    conta.setSaldo(conta.getSaldo() + valorDigitado);

     System.out.println("--------------------------------");
     System.out.println("Depósito realizado com sucesso !");
     System.out.println("Valor do depósito: " + realBrasileiro.format(valorDigitado)); 
     //Verifica se a conta é Poupança ou Corrente e cobra as taxas correspondentes
     if(conta instanceof ContaPoupanca){
       double valorBonus = 0.01 * valorDigitado;
       conta.setSaldo(conta.getSaldo() + valorBonus);
       System.out.println("Valor bônus adicionado: " + realBrasileiro.format(valorBonus));
     }
     System.out.println("Saldo atual: " + realBrasileiro.format(conta.getSaldo()));
     System.out.println("--------------------------------");
      System.out.println("Voltar ao início ? 1-Sim, 2-Não");
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

 System.out.println("-----DADOS DA CONTA-----");
 System.out.println("TITULAR: " + conta.getNome());
  if(conta instanceof ContaPoupanca){
    System.out.println("TIPO DE CONTA: Poupança");
  }else{
    System.out.println("TIPO DE CONTA: Corrente");
  }
  //Formatando o CPF (inserindo pontos e traço)
  String cpfFormatado = Long.toString(conta.getCpf());
  char[] cpfFormatado1 = cpfFormatado.toCharArray();
 if(cpfFormatado.length() == 11){ //Se o cpf não inicia com "0"
  System.out.print("CPF: " + cpfFormatado1[0] + cpfFormatado1[1] + cpfFormatado1[2] + ".");
   System.out.print(cpfFormatado1[3] + cpfFormatado1[4] + cpfFormatado1[5] + ".");
    System.out.print(cpfFormatado1[6] + cpfFormatado1[7] + cpfFormatado1[8] + "-");
     System.out.print(cpfFormatado1[9] + cpfFormatado1[10]);
      System.out.println();
 }else{ //Se o cpf inicia com "0"
  System.out.print("CPF: " + "0" + cpfFormatado1[0] + cpfFormatado1[1] + ".");
   System.out.print(cpfFormatado1[2] + cpfFormatado1[3] + cpfFormatado1[4] + ".");
    System.out.print(cpfFormatado1[5] + cpfFormatado1[6] + cpfFormatado1[7] + "-");
     System.out.print(cpfFormatado1[8] + cpfFormatado1[9]);
      System.out.println();
 }
 System.out.println("AGÊNCIA: " + conta.getAgencia());
 System.out.println("CONTA: " + conta.getNumConta());
 System.out.println("SALDO: " + realBrasileiro.format(conta.getSaldo()));
 System.out.println("------------------------");

}



public static void abrirConta(ArrayList<Conta> listaContas, String[] args){

 System.out.println("QUAL O TIPO DE CONTA DESEJA ABRIR ?");
  System.out.println("(1) - POUPANÇA");
  System.out.println("(2) - CORRENTE");
  System.out.println("(3) - VERIFICAR DIFERENÇAS ENTRE OS TIPOS");
  int option = input.nextInt();

  switch(option){
    
    //CASO 'POUPANÇA' FOR ESCOLHIDA
    case 1:input.nextLine();
       System.out.println("INFORME SEU NOME COMPLETO:"); 
       String nomeDigitado = input.nextLine();
        nomeDigitado.trim();
         System.out.println("INFORME SEU CPF");
         long cpfDigitado = input.nextLong();
           System.out.println("DIGITE UMA SENHA DE 4 DÍGITOS");
           int senhaDigitada = input.nextInt();
       //Instance of 'ContaPoupanca' object   
       ContaPoupanca CP = new ContaPoupanca(nomeDigitado,cpfDigitado,"3920-9",aleatory.nextInt((10000-1000) + 1) + 1000,senhaDigitada, 0);
       //Add the object 'CP' to the 'listaContas'
       listaContas.add(CP);
       //Confirma que a conta foi criada com sucesso
       System.out.println();
       Conta.imprimirDetalhesConta(CP);

       System.out.println("Voltar ao início ? Sim-1, Não-2");
       option = input.nextInt();
        if(option == 1){
          Menu.main(args);
        }else{
          System.exit(0);
        }
        break;
    
    //CASO 'CORRENTE' FOR ESCOLHIDA
    case 2:input.nextLine();
    System.out.println("INFORME SEU NOME:"); 
    nomeDigitado = input.nextLine();
      System.out.println("INFORME SEU CPF");
    cpfDigitado = input.nextLong();
        System.out.println("DIGITE UMA SENHA DE 4 DÍGITOS");
    senhaDigitada = input.nextInt();
    //Instance of 'ContaPoupanca' object   
    ContaCorrente CC = new ContaCorrente(nomeDigitado,cpfDigitado,"3920-9",aleatory.nextInt((10000-1000) + 1) + 1000,senhaDigitada, 0);
    //Add the object 'CP' to the 'listaContas'
    listaContas.add(CC);
    //Confirma que a conta foi criada com sucesso
    System.out.println();
    Conta.imprimirDetalhesConta(CC);

    System.out.println("Voltar ao início ? Sim-1, Não-2");
    option = input.nextInt();
     if(option == 1){
       Menu.main(args);
     }else{
       System.exit(0);
     } 
     break;

    //CASO 'OPÇÃO 3' FOR ESCOLHIDA
    case 3:
       System.out.println("------------------------------");
       System.out.println("       CONTA POUPANÇA");
       System.out.println("*DEPÓSITO: a cada depósito efetuado é adicionado \n um bônus de 1,0% ao valor depositado");
       System.out.println("*SAQUE: não há taxas para saques realizados");
       System.out.println("------------------------------");
       System.out.println("       CONTA CORRENTE");
       System.out.println("*DEPÓSITO: não há bônus para depósitos");
       System.out.println("*SAQUE: taxa de R$ 6,50 reais para cada depósito realizado");
       System.out.println("Obs: taxa de saque somente será cobrada se o valor do saldo \n após a operação for maior que R$ 6,50");
       System.out.println("------------------------------");
       
       System.out.println("Voltar ao início ? Sim-1, Não-2");
       option = input.nextInt();
       if(option == 1){
         Menu.main(args);
       }else{
         System.exit(0);
       } 
       break;

  }

}




}
