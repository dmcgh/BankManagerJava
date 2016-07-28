package com.allstate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by localadmin on 7/28/16.
 */
public class BankTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testConstuctorWithName() throws Exception {
        Bank bank1 = new Bank("Chase");
        assertNotNull(bank1.getId());
        assertNotNull(bank1.getClients());
    }

    @Test
    public void testAddClients() throws Exception {
        Bank bank1 = new Bank("BOA");
        Client client1 = new Client("Tommy");
        Client client2 = new Client("Jimmy");

        bank1.addClient(client1);
        bank1.addClient(client2);

        assertNotNull(bank1.getId());
        assertTrue(bank1.getClients().size() == 2);
    }

    @Test
    public void testRemoveClient() throws Exception {
        Bank bank1 = new Bank("Fifth");
        Client client1 = new Client("Tommy");
        Client client2 = new Client("Jimmy");

        bank1.addClient(client1);
        Account account1 = new Account(AccountType.CHECKING);
        account1.deposit(100);
        Account account2 = new Account(AccountType.CHECKING);
        account2.deposit(500);

        bank1.getClients().get(0).addAccount(account1);

        bank1.addClient(client2);
        bank1.getClients().get(0).addAccount(account2);

        bank1.removeClient(client2.getId());

        assertTrue(bank1.getClients().size() == 2);
        assertFalse(bank1.getClients().stream().filter(c -> c == client2).findFirst().get().isActive());
        assertTrue(bank1.getClients().stream().filter(c -> c == client1).findFirst().get().isActive());
    }
}
