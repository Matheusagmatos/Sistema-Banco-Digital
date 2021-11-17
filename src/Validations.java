package src;

import java.util.Scanner;
import java.util.ArrayList;

public class Validations {
    
  static Scanner input = new Scanner(System.in);


  /**
   * Método para validação do número de CPF digitado pelo usuário.
   * <p>
   * Percorre cada um dos 11 caracteres digitados pelo usuário, e verifica
   * se estes caracteres são algarismos que estão entre 0 e 9 ou se foi digitado
   * algum tipo de dado que não seja um número. 
   * 
   * @param cpfDigitado o número de CPF digitado pelo usuário
   * 
   * @return 'true' se o CPF for válido, ou 'false' se o cpf for inválido
   */
  public static boolean validarCPF(String cpfDigitado){
    System.out.println();

    char[] cpfFormatado = cpfDigitado.toCharArray();

    if(cpfFormatado[0] >= 0 && cpfFormatado[0] <= 9){
      if(cpfFormatado[1] >= 0 && cpfFormatado[1] <= 9){
        if(cpfFormatado[2] >= 0 && cpfFormatado[2] <= 9){
          if(cpfFormatado[3] >= 0 && cpfFormatado[3] <= 9){
            if(cpfFormatado[4] >= 0 && cpfFormatado[4] <= 9){
              if(cpfFormatado[5] >= 0 && cpfFormatado[5] <= 9){
                if(cpfFormatado[6] >= 0 && cpfFormatado[6] <= 9){
                  if(cpfFormatado[7] >= 0 && cpfFormatado[7] <= 9){
                    if(cpfFormatado[8] >= 0 && cpfFormatado[8] <= 9){
                      if(cpfFormatado[9] >= 0 && cpfFormatado[9] <= 9){
                        if(cpfFormatado[10] >= 0 && cpfFormatado[10] <= 9){
                         return true;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    do{
     if(!(cpfDigitado.length() == 11)){
       System.out.println("Inválido!");
       System.out.println("CPF deve conter 11 dígitos númericos");
       return false;
     }
    }while(cpfDigitado.length() != 11);
    return true;
  }



  /**
   * Método para validação do número da conta gerado pelo algoritmo.
   * <p>
   * O algoritmo gera um número aleatório de quatro dígitos, através da classe
   * 'Random' e faz a chamada para este método que vai verificar se a sequência gerada,
   * ou seja, se o número de conta gerado já existe e se é uma sequência válida.
   * <p>
   * Obs: não serão válidos valores com três zeros (000) ao final e nem sequências com
   * quatro números iguais (exe: 1111, 2222);
   * 
   * @param listaContas uma lista do tipo 'Conta', que armazena todas as contas ativas no banco digital
   * @param numConta o número da conta (sequência de 4 dígitos) que foi gerado pelo algoritmo
   * 
   * @return 'true' se o número gerado for válido, ou 'false' se o número gerado for inválido
   */
  public static boolean validarNumeroDaContaGerado(ArrayList<Conta> listaContas, int numConta){
    if(numConta == 1000 || numConta == 1111){
      return false;
    }if(numConta == 2000 || numConta == 2222){
      return false;
    }if(numConta == 3000 || numConta == 3333){
      return false;
    }if(numConta == 4000 || numConta == 4444){
      return false;
    }if(numConta == 5000 || numConta == 5555){
      return false;
    }if(numConta == 6000 || numConta == 6666){
      return false;
    }if(numConta == 7000 || numConta == 7777){
      return false;
    }if(numConta == 8000 || numConta == 8888){
      return false;
    }if(numConta == 9000 || numConta == 9999){
      return false;
    }
     for(int i = 0; i < listaContas.size(); i++){
       if(listaContas.get(i).getNumConta() == numConta){
        return false;
       }
     }
    return true;
  }


  /**
   * Método que valida o acesso do usuário à conta bancária.
   * <p>
   * Verifica se o número da conta e senha digitados pelo usuário são válidos.
   * <p>
   * Caso os dados informamdos sejam válidos, o algoritmo libera o acesso à conta
   * do usuário.
   * 
   * @param listaContas uma lista do tipo 'Conta', que armazena todas as contas ativas no banco digital
   * @param numContaDigitado o número da conta (sequência de 4 dígitos) que foi digitado pelo usuário
   * @param senhaContaDigitada a senha (de 4 dígitos) digitada pelo usuário
   * 
   * @return 'true' se os dados informamdos forem válidos, ou 'false' se os dados informados forem inválidos
   */
  public static boolean validarContaeSenhaDeAcesso(ArrayList<Conta> listaContas, int numContaDigitado, int senhaContaDigitada){
    boolean contaExiste = false;
     for(int i = 0; i < listaContas.size(); i++){
       if(listaContas.get(i).getNumConta() == numContaDigitado){
         contaExiste = true;
        if(listaContas.get(i).getSenhaConta() == senhaContaDigitada){
          return true;
        }
        if(contaExiste == true){
           System.out.println("Senha incorreta");
           System.out.println("OPERAÇÃO ENCERRADA!");
           System.exit(0);
        }
       }
     }
     System.out.println("Conta e/ou senha inválidos!");
     return false;
  }


  /**
   * Método que valida a senha digitada pelo usuário.
   * <p>
   * Válido tanto para a senha cadastrada no momento da abertura da conta, quanto
   * para a senha digitada no momento de acesso à conta.
   * 
   * @param senhaDigitada a senha (de 4 dígitos) digitada pelo usuário
   * 
   * @return 'true' se a senha for válida, ou 'false' se for inválida
   */
  public static boolean validarSenha(int senhaDigitada){
    System.out.println();
    //Verifica se a senha possui menos de 4 dígitos
    if(senhaDigitada < 1000 || senhaDigitada > 9999){
      System.out.println("Senha inválida!");
      System.out.println("Digite 4 dígitos numéricos");
      System.out.println();
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
