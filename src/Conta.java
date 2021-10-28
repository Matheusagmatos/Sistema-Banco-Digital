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
    
  private String titular; //alterar nome para titular
  private String cpf;
  private String agencia;
  private int numConta;
  private int senhaConta;
  private double saldo;

  //Constructor
  public Conta(String titular, String cpf, String agencia, int numConta, int senhaConta, double saldo) {
    this.setTitular(titular);
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
public String getCpf() {
    return cpf;
  }
public void setCpf(String cpf) {
    this.cpf = cpf;
  }
public String getTitular() {
    return nome;
  }
public void setTitular(String nome) {
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
      
      int numDigitado;
      int senhaDigitada;

      do{
        System.out.println("INFORME O NÚMERO DA CONTA:");
         numDigitado = input.nextInt();
        System.out.println("INFORME A SENHA DE 4 DÍGITOS");
         senhaDigitada = input.nextInt();
      }while(Validations.validarContaeSenhaDeAcesso(listaContas, numDigitado, senhaDigitada) == false);

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
 System.out.println("TITULAR: " + conta.getTitular());
  if(conta instanceof ContaPoupanca){
    System.out.println("TIPO DE CONTA: Poupança");
  }else{
    System.out.println("TIPO DE CONTA: Corrente");
  }
 //formatamos a impressão do cpf
 char[] cpfFormatado = (conta.getCpf().toCharArray());
 System.out.println("CPF: " +cpfFormatado[0]+cpfFormatado[1]+cpfFormatado[2]+"."+cpfFormatado[3]+cpfFormatado[4]+cpfFormatado[5]+"."+cpfFormatado[6]+cpfFormatado[7]+cpfFormatado[8]+"-"+cpfFormatado[9]+cpfFormatado[10]);
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
    case 1:
    
        input.nextLine();

        System.out.println("INFORME SEU NOME COMPLETO:"); 
        String nomeDigitado1 = input.nextLine();
        nomeDigitado1.trim();
          
        String cpfDigitado1;
          do{
           System.out.println("INFORME SEU CPF");
           cpfDigitado1 = input.nextLine();
          }while(Validations.validarCPF(cpfDigitado1) == false);
         
        int senhaDigitada1;
         do{
           System.out.println("DIGITE UMA SENHA DE 4 DÍGITOS");
           senhaDigitada1 = input.nextInt();
         }while(Validations.validarSenha(senhaDigitada1) == false);

        int numConta1;
         do{
          numConta1 = aleatory.nextInt((10000-1000) + 1) + 1000;
         }while(Validations.validarNumeroDaContaGerado(listaContas, numConta1) == false);


       //Instance of 'ContaPoupanca' object   
       ContaPoupanca CP = new ContaPoupanca(nomeDigitado1,cpfDigitado1,"3920-9",numConta1,senhaDigitada1, 0);

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
    case 2:

        input.nextLine();

        System.out.println("INFORME SEU NOME COMPLETO:"); 
        String nomeDigitado2 = input.nextLine();
        nomeDigitado2.trim();
          
        String cpfDigitado2;
          do{
           System.out.println("INFORME SEU CPF");
           cpfDigitado2 = input.nextLine();
          }while(Validations.validarCPF(cpfDigitado2) == false);
         
        int senhaDigitada2;
         do{
           System.out.println("DIGITE UMA SENHA DE 4 DÍGITOS");
           senhaDigitada2 = input.nextInt();
         }while(Validations.validarSenha(senhaDigitada2) == false);

        int numConta2;
         do{
          numConta2 = aleatory.nextInt((10000-1000) + 1) + 1000;
         }while(Validations.validarNumeroDaContaGerado(listaContas, numConta2) == false);


    //Instance of 'ContaPoupanca' object   
    ContaCorrente CC = new ContaCorrente(nomeDigitado2,cpfDigitado2,"3920-9",numConta2,senhaDigitada2, 0);
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
