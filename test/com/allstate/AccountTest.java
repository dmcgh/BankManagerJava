package com.allstate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by localadmin on 7/28/16.
 */
public class AccountTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstuctorWithIdAndBalanceAndType() throws Exception {
        Account account = new Account(AccountType.CHECKING);
        assertNotNull(account.getId());
        assertNotNull(account.getBalance());
        assertEquals(AccountType.CHECKING, account.getAccountType());
    }

    @Test
    public void testDepositingMoney() throws Exception {
        Account account = new Account(AccountType.CHECKING);
        account.deposit(1000000);
        assertEquals(1000000f, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawingMoney() throws Exception {
        Account account = new Account(AccountType.CHECKING);
        account.deposit(100);
        account.withdraw(90);
        assertEquals(10f, account.getBalance(), 0.001);
    }

    @Test
    public void testIncrementOverDraftCount() throws Exception {
        Account account = new Account(AccountType.CHECKING);
        account.deposit(100);
        account.withdraw(90); //should be 10
        account.withdraw(90); //should be -40
        account.withdraw(90); //should be -90

        //Overdraft count should be 2 - Account not closed
        assertTrue(!account.isClosed());

        account.withdraw(90); //should be -140

        assertTrue(account.isClosed());

        assertEquals(-140f, account.getBalance(), 0.001);

    }

}
