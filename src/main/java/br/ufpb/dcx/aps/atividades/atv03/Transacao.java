package br.ufpb.dcx.aps.atividades.atv03;

import java.util.Calendar;

//import java.util.Calendar;

public class Transacao {
    private int id;
    private Calendar data;
    private double valor;

    public Transacao (int id, double valor) {
        this.id = id;
        this.valor = valor;
        
    }

    public Transacao () {
        this.id = 0;
        this.valor = 0.0;
        
    }

    public int getId() throws RuntimeException {
        if (this.id < 0){
            throw new RuntimeException("tente um id positivo");

        }
        return id;
    }

    public double getValor() {
        return valor;
    }

    
    
    public String toString() {
        return String.format("ID: "+this.getId()+"; Valor: "+this.getValor());
    }

    /**
     * @return Calendar return the data
     */
    public Calendar getDataTransacao() {
        return data;
    }

    

}
