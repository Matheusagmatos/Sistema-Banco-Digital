import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
 public static void main(String[] args){

     Scanner input = new Scanner(System.in);

     //cria uma lista para armazenar todas as contas criadas
     ArrayList<Conta> listaContas = new ArrayList<>();

     System.out.println("--- BANCO DIGITAL ---");
     System.out.println("(1) -> ACESSAR CONTA");
     System.out.println("(2) -> ABRIR CONTA");
     
     int option = input.nextInt(); 

      if(option == 1){
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
                }
              }
          }      
      }

 }

    
}
