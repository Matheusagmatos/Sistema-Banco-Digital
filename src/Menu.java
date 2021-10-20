package src;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {

//Cria uma lista para armazenar todas as contas criadas
static ArrayList<Conta> listaContas = new ArrayList<Conta>();

  public static void main(String[] args){

     Scanner input = new Scanner(System.in);

     //TESTE
     System.out.println("Tamanho da listaContas: " + listaContas.size());

     System.out.println("--- BANCO DIGITAL ---");
     System.out.println("(1) -> ACESSAR CONTA");
     System.out.println("(2) -> ABRIR CONTA");
     
     int option = input.nextInt(); 

      if(option == 1){
        Conta.acessarConta(listaContas, args);    
      }if(option == 2){
        Conta.abrirConta(listaContas, args);
      }


      input.close();

 }

    
}
