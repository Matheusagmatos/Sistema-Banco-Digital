package src;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.NumberFormat;
import java.util.Locale;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class ExtratoBancario {

  
  static LocalDate dataAtual = LocalDate.now();

  static LocalTime horaAtual = LocalTime.now();
  
  static Locale localeBR = new Locale("pt","BR");

  static NumberFormat realBrasileiro = NumberFormat.getCurrencyInstance(localeBR);

 
 
  public static void extratoSaque(Conta conta, double valorSaque, double taxaSaque, boolean CP, boolean CC) throws IOException{

    File extratoBancario = new File("C:/Users/Administrador/Desktop/ExtratoBancario.txt");
    
    extratoBancario.createNewFile();

    FileWriter fw = new FileWriter(extratoBancario);

    BufferedWriter bw = new BufferedWriter(fw);


    bw.write("-------- BANCO DIGITAL --------");
    bw.newLine();
    bw.write("        Extrato Bancário        ");
    bw.newLine();
    bw.write("-------------------------------");
    bw.newLine();
    if(CP == true){
     bw.write("Operação: SAQUE em conta poupança");
    }if(CC == true){
     bw.write("Operação: SAQUE em conta corrente");
    }
    bw.newLine();
    bw.write("Titular: " + conta.getTitular());
    bw.newLine();
    bw.write("Agência: " + conta.getAgencia());
    bw.newLine();
    bw.write("Conta: " + conta.getNumConta());
    bw.newLine();
    bw.write("Valor: " + realBrasileiro.format(valorSaque));
    bw.newLine();
    //Caso a conta seja uma instância de 'ContaCorrente' imprime no extrato bancário a respectiva taxa de saque correspondente
    if(conta instanceof ContaCorrente){
    bw.write("Taxa saque conta corrente: " + realBrasileiro.format(taxaSaque));
    }
    bw.write("-------------------------------");
    bw.newLine();
    bw.write("Data: " + dataAtual.getDayOfMonth() +"/"+ dataAtual.getMonthValue() +"/"+ dataAtual.getYear() + 
    "     Hora: " + horaAtual.getHour() +":"+ horaAtual.getMinute() +":"+ horaAtual.getSecond());

    bw.close();

  }



  public static void extratoDeposito(Conta conta, double valorDeposito, double valorBonus, boolean CP, boolean CC) throws IOException{

    File extratoBancario = new File("C:/Users/Administrador/Desktop/ExtratoBancario.txt");
    
    extratoBancario.createNewFile();

    FileWriter fw = new FileWriter(extratoBancario);

    BufferedWriter bw = new BufferedWriter(fw);


    bw.write("-------- BANCO DIGITAL --------");
    bw.newLine();
    bw.write("        Extrato Bancário        ");
    bw.newLine();
    bw.write("-------------------------------");
    bw.newLine();
    if(CP == true){
     bw.write("Operação: DEPÓSITO em conta poupança");
    }if(CC == true){
     bw.write("Operação: DEPÓSITO em conta corrente");
    }
    bw.newLine();
    bw.write("Titular: " + conta.getTitular());
    bw.newLine();
    bw.write("Agência: " + conta.getAgencia());
    bw.newLine();
    bw.write("Conta: " + conta.getNumConta());
    bw.newLine();
    bw.write("Valor: " + realBrasileiro.format(valorDeposito));
    bw.newLine();
    //Caso a conta seja uma instância de 'ContaPoupança' imprime no extrato bancário o valor bônus adicionado
    if(conta instanceof ContaPoupanca){
    bw.write("Valor bônus adicionado: " + realBrasileiro.format(valorBonus));
    }
    bw.newLine();
    bw.write("-------------------------------");
    bw.newLine();
    bw.write("Data: " + dataAtual.getDayOfMonth() +"/"+ dataAtual.getMonthValue() +"/"+ dataAtual.getYear() + 
    "     Hora: " + horaAtual.getHour() +":"+ horaAtual.getMinute() +":"+ horaAtual.getSecond());

    bw.close();

  }




  public static void extratoAberturaConta(Conta conta, boolean CP, boolean CC) throws IOException{
   
    File extratoBancario = new File("C:/Users/Administrador/Desktop/ExtratoBancario.txt");
    
    extratoBancario.createNewFile();

    FileWriter fw = new FileWriter(extratoBancario);

    BufferedWriter bw = new BufferedWriter(fw);


    bw.write("-------- BANCO DIGITAL --------");
    bw.newLine();
    bw.write("        Extrato Bancário        ");
    bw.newLine();
    bw.write("-------------------------------");
    bw.newLine();
    if(CP == true){
     bw.write("Operação: ABERTURA de conta poupança");
    }if(CC == true){
     bw.write("Operação: ABERTURA de conta corrente");
    }
    bw.newLine();
    bw.write("Titular: " + conta.getTitular());
    bw.newLine();
    bw.write("Agência: " + conta.getAgencia());
    bw.newLine();
    bw.write("Conta: " + conta.getNumConta());
    bw.newLine();
    bw.write("-------------------------------");
    bw.newLine();
    bw.write("Data: " + dataAtual.getDayOfMonth() +"/"+ dataAtual.getMonthValue() +"/"+ dataAtual.getYear() + 
    "     Hora: " + horaAtual.getHour() +":"+ horaAtual.getMinute() +":"+ horaAtual.getSecond());

    bw.close();
    
  }

    
}
