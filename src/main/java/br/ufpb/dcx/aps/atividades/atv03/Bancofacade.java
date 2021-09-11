package br.ufpb.dcx.aps.atividades.atv03;


import java.util.List;

public class Bancofacade {
    
    private Banco banco;

    public Bancofacade(String bancoNome) {
        this.banco = new Banco(bancoNome);
    }
    
    
        public void cadastrarCorrentista(String cpf, String nome) throws BancoException {
            Correntista correntista1 = new Correntista(cpf, nome);
            banco.addCorrentista(correntista1);
            
                
            
                
            
        }
        public Conta getConta(int numero){
            return banco.getConta(numero);

        } 
        public Conta criarContaPF(String cpf){
         Correntista corrent = banco.getCorrentista(cpf);
        return banco.criarConta(corrent);
        }        
                
        public void depositar(double valor, int conta){
            Conta conta1 = banco.getConta(conta);
            conta1.depositar(valor);

        }
        public double sacar(double valor, int conta) throws ContaException {
            Conta conta1 = banco.getConta(conta);
            conta1.sacar(valor);
            return conta1.saldo();

        }
        public double saldo(int conta){
            Conta conta1 = banco.getConta(conta);
            return conta1.saldo();

        }
        public String extrato(int conta){
            Conta conta1 = banco.getConta(conta);
            return conta1.extrato();

        }
        public List<Transacao> getTransacoes(int conta){
            Conta conta1 = banco.getConta(conta);
            return conta1.getTransacoes();

        }



    }
    


    

