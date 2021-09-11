package br.ufpb.dcx.aps.atividades.atv03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransacaoTest {
    Transacao transacaoNotNul;
    Transacao transacaoAssertEquals;

    @BeforeEach
    void setUp() {
        transacaoNotNul = new Transacao();
        transacaoAssertEquals = new Transacao(1, 1.1);
    }

    @Test
    void testTransacao(){                        
        assertNotNull(transacaoNotNul);
        assertEquals(1, transacaoAssertEquals.getId());
        assertEquals(1.1, transacaoAssertEquals.getValor());
        assertEquals("ID: 1; Valor: 1.1", transacaoAssertEquals.toString());
    }
}
