package br.ufpb.dcx.aps.atividades.atv03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ContaTest {

    Correntista correntista;
    Banco banco;
    Conta conta;

    @BeforeEach
    void setUp() {
        correntista = new Correntista();
        banco = new Banco();
        conta = new Conta(correntista, 1, banco);
    }

    @Test
    void contaTest() throws ContaException{
        assertNotNull(conta);
        assertEquals(0.0, conta.saldo());

        conta = new Conta();
        assertNotNull(conta);

        conta = new Conta(correntista, 1, banco);
        conta.depositar(100.0);
        assertEquals(">> " + "" + "\n"+
         ">> Correntista: \n"+
         " CPF: " + ""  + "\n"+
         " " + ""  + "\n"+
         "> EXTRATO\n"+
         "------------------------------------\n"+
         "CRÉDITO\tR$ 100,00\n"+
         "------------------------------------\n"+
         "SALDO:\tR$ " + 100 + ",00", conta.extrato());

        assertEquals(100, conta.saldo());

        conta.sacar(50.0);
        assertEquals(50, conta.saldo());

        Exception exception = assertThrows(ContaException.class, () -> conta.sacar(1000000.0));

        assertEquals("Saldo insuficiente. Saldo:50.0 - valor do saque:1000000.0", exception.getMessage());
    }
}
