public class Conta {
    
  private String nome;
  private long cpf;
  private int agencia;
  private int numConta;
  private int senhaConta;

  //Construcor
  public Conta(String nome, long cpf, int agencia, int numConta, int senhaConta) {
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
public int getAgencia() {
    return agencia;
  }
public void setAgencia(int agencia) {
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





public static void sacar(){

 }


public static void depositar(){

 }

public static void imprimirDetalhesConta(Conta conta){
 System.out.print("-----DADOS DA CONTA-----");
 System.out.print("TITULAR: " + conta.getNome());
 System.out.print("CPF: " + conta.getCpf());
 System.out.print("AGÊNCIA: " + conta.getAgencia());
 System.out.print("CONTA: " + conta.getNumConta());
 System.out.print("------------------------");
}





}
