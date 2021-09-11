package br.ufpb.dcx.aps.atividades.atv03;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;

public class Conta {

    private Correntista correntista;
    private int numero;
    private List<Transacao> transacoes = new LinkedList<Transacao>();
    private Banco banco;
    private List <String> movimentacao = new ArrayList<>();

    // Construtores.

    public Conta(Correntista correntista, int numero, Banco banco) {
        this.correntista = correntista;
        this.numero = numero;
        this.banco = banco;
        
    }

    public Conta() {
        this.numero = 0;
        
    }

    // Metódos.
    public String extrato() {
        String retorno = "";
        retorno += ">> " + banco.getNome() + "\n";
        retorno += ">> Correntista: \n";
        retorno += " CPF: " + correntista.getCpf()  + "\n";
        retorno += " " + correntista.getNome()  + "\n";
        retorno += "> EXTRATO\n";
        retorno += "------------------------------------\n";
        for (String s : this.movimentacao) retorno += s + "\n";
        retorno += "------------------------------------\n";
        retorno += "SALDO:\tR$ " + (int) this.saldo() + ",00";
        return retorno;
    }

    public Transacao depositar(double valor) {
        if (valor > 0) {
            Transacao transacao = new Transacao(geradorID(), valor);
            transacoes.add(transacao);
            this.movimentacao.add("CRÉDITO\tR$ " + (int) valor + ",00");
            
            return transacao;
        } else {
            throw new RuntimeException("Valor de depósito inválido. Tente um valor maior que 0");
        }
    }

    public Transacao sacar(double valor) throws ContaException  {
        if (valor <= this.saldo() && valor > 0) {
        Transacao transacao = new Transacao(geradorID(), -valor);
        
            transacoes.add(transacao);
            this.movimentacao.add("DÉBITO\t-R$ " + (int) valor + ",00");

            return transacao;
    } else {
        throw new ContaException("Saldo insuficiente. Saldo:"+saldo()+" - valor do saque:"+valor);
    }
      
        }

    public double saldo() {
        double saldoTotal = 0.0;
        for (Transacao t : transacoes){
        saldoTotal += t.getValor();
       }
       return saldoTotal;
        
    }

    /**
     * @return Correntista return the correntista
     */
    public Correntista getCorrentista() {
        return correntista;
    }

    /**
     * @param correntista the correntista to set
     */
    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    /**
     * @return int return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return List<Transacao> return the transacoes
     */
    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    /**
     * @param transacoes the transacoes to set
     */
    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    /**
     * @return Banco return the banco
     */
    public Banco getBanco() {
        return banco;
    }


    /**
     * @param banco the banco to set
     */
    public void setBanco(Banco banco) {
        this.banco = banco;
    }
    public int geradorID(){
        Random numeroRandomico = new Random();
        int id = numeroRandomico.nextInt(99999);
        return id;
    }
}
