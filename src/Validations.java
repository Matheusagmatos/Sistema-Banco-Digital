package src;

import java.util.Scanner;
import java.util.ArrayList;

public class Validations {
    
  static Scanner input = new Scanner(System.in);



  public static boolean validarCPF(String cpfDigitado){
    System.out.println();
    do{
     if(!(cpfDigitado.length() == 11)){
       System.out.println("Inválido!");
       System.out.println("CPF deve conter 11 dígitos númericos");
       return false;
     }
    }while(cpfDigitado.length() != 11);
    return true;
  }




  public static boolean validarNumeroDaConta(ArrayList<Conta> listaContas, int numConta){
     for(int i = 0; i < listaContas.size(); i++){
       if(listaContas.get(i).getNumConta() == numConta){
        return false;
       }
     }
    return true;
  }



  public static boolean validarSenha(int senhaDigitada){
    System.out.println();
    //Verifica se a senha possui menos de 4 dígitos
    if(senhaDigitada < 1000 || senhaDigitada > 9999){
      System.out.println("Senha inválida!");
      System.out.println("Digite 4 dígitos numéricos");
      return false;
    }
    //Verifica se a senha possui mais de 1 dígito igual
    char[] digitosDaSenha = String.valueOf(senhaDigitada).toCharArray();
    boolean digitoIgual = false;
     if(digitosDaSenha[0] == digitosDaSenha[1] || digitosDaSenha[0] == digitosDaSenha[2] || digitosDaSenha[0] == digitosDaSenha[3]){
      digitoIgual = true;
     }if(digitosDaSenha[1] == digitosDaSenha[0] || digitosDaSenha[1] == digitosDaSenha[2] || digitosDaSenha[1] == digitosDaSenha[3]){
      digitoIgual = true;
     }if(digitosDaSenha[2] == digitosDaSenha[0] || digitosDaSenha[2] == digitosDaSenha[1] || digitosDaSenha[2] == digitosDaSenha[3]){
      digitoIgual = true;
     }if(digitosDaSenha[3] == digitosDaSenha[0] || digitosDaSenha[3] == digitosDaSenha[1] || digitosDaSenha[3] == digitosDaSenha[2]){
      digitoIgual = true;
     }
    if(digitoIgual == true){
      System.out.println("Senha inválida!");
      System.out.println("A senha não pode conter dígitos iguais");
      return false;
    }
    return true;
  }


}
