package com.allstate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by localadmin on 7/28/16.
 */
public class TransactionTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstuctorWithAmountAndType() throws Exception {
        Transaction t = new Transaction(50f, TransactionType.DEPOSIT);
        assertNotNull(t.getID());
        assertNotNull(t.getDate());
        assertEquals(50f, t.getAmount(), 0.1);
        assertEquals(TransactionType.DEPOSIT, t.getTransactionType());
    }

    @Test
    public void testToStringOverride() throws Exception {
        Transaction t = new Transaction(50f, TransactionType.FEE);
        assertNotNull(t.getID());
        assertNotNull(t.getDate());
        assertEquals(t.toString(), "Transaction Type: FEE, Amount: 50.0");
        assertEquals(TransactionType.FEE, t.getTransactionType());
    }
}
