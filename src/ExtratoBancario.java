package src;

import java.io.File;
import java.io.IOException;

public class ExtratoBancario {


  public static void extratoSaque(Conta conta, double valorSaque, boolean CP, boolean CC) throws IOException{

    File extratoBancario = new File("C:/Users/Administrador/Desktop/ExtratoBancario.txt");
    
    extratoBancario.createNewFile();

  }



  public static void extratoDeposito(Conta conta, double valorDeposito, boolean CP, boolean CC){
   
  }


  public static void extratoAberturaConta(Conta conta, boolean CP, boolean CC){

    
  }

    
}
