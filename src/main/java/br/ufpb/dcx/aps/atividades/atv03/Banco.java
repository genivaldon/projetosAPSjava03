package br.ufpb.dcx.aps.atividades.atv03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Banco {

    private Map<Integer, Conta> contas = new HashMap<>();
    private int numeroContaLivre;
    private Map<String, Correntista> correntistas = new HashMap<>();
    private String nome;

    public Banco() {
        this.numeroContaLivre = 0;
        this.nome = "";
    }
    public Banco(String nome){
        this.nome = nome;
        
    }

    public void addCorrentista(Correntista correntista) throws BancoException{
        if(!Correntista.cpfValido(correntista.getCpf())){
            throw new RuntimeException("CPF invalido:" +correntista.getCpf());
            
        } 
        if(this.correntistas.containsKey(correntista.getCpf())){
            throw new RuntimeException("Correntista ja cadastrado:Correntista{cpf='"+correntista.getCpf()+"', nome='"+correntista.getNome()+"'}");

        } 
        correntistas.put(correntista.getCpf(),correntista);
        }

        

    public Conta criarConta(Correntista correntista) {
        if(!this.correntistas.containsKey(correntista.getCpf())){
            throw new RuntimeException("Correntista não cadastrado no banco:Correntista{cpf='" +correntista.getCpf()+"', nome='"+correntista.getNome()+"'}");
        }
        for (Conta cnt : this.contas.values()){
            if (cnt.getCorrentista().equals(correntista)){
            throw new RuntimeException("Correntista já tem conta cadastrada");
            }

            
    }
        numeroContaLivre = geradorID();
        Conta c1 = new Conta(correntista, numeroContaLivre, this);
        
            
            this.contas.put(gerarNumeroConta(), c1);
       
            return c1;
        }
        
    public Conta getConta(int conta) {
       
            return contas.get(conta);
        
    
        
       }

    public Conta getConta(Correntista titular) {
        for (Conta cnt : this.contas.values()){
            if (cnt.getCorrentista().equals(titular)){
                return cnt;
        }
     }  return null;
      }
    

public Correntista getCorrentista(String cpf) {
        if(correntistas.containsKey(cpf)){
            return correntistas.get(cpf);
        } else{
            throw new RuntimeException("Não existe correntista com cpf:"+cpf);
        }    

    }

    private int gerarNumeroConta() {
        int num = this.numeroContaLivre;
        this.setNumeroContaLivre(this.contas.size()+1);
        return num;
        
    }

    
    public void setNumeroContaLivre(int numeroContaLivre) {
        this.numeroContaLivre = numeroContaLivre;
    }
    public int geradorID(){
        Random numeroRandomico = new Random();
        int id = numeroRandomico.nextInt(99999);
        return id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

}




