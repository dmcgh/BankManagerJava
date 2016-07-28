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
public class ClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstuctorWithName() throws Exception {
        Client client = new Client("Bob");
        assertNotNull(client.getId());
        assertNotNull(client.getAccounts());
        assertTrue(client.isActive());
    }

    @Test
    public void testOpenAccount() throws Exception {
        Client client = new Client("Billy Bob");
        Account a1 = new Account(AccountType.CHECKING);
        client.addAccount(a1);

        assertTrue(client.getAccounts().size() == 1);
        assertTrue(client.getAccounts().get(0).getBalance() == 0.0f);

    }

    @Test
    public void testCloseAccount() throws Exception {
        Client client = new Client("Sammy Bob");
        Account a1 = new Account(AccountType.SAVINGS);
        Account a2 = new Account(AccountType.CHECKING);
        client.addAccount(a1);
        client.addAccount(a2);
        client.getAccounts().get(0).deposit(1000);
        client.getAccounts().get(1).deposit(5000);
        client.closeAccount(a1.getId());


        assertTrue(client.getAccounts().get(0).getBalance() == 0.0f);


    }
}
