package com.allstate;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by localadmin on 7/28/16.
 */
public class Bank {
    private String id;
    private String name;
    private ArrayList<Client> clients;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public Bank(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
        this.clients = new ArrayList<>();

    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void removeClient(String clientId) {
        Client foundClient = this.clients.stream().filter(c -> c.getId() == clientId).findFirst().get();
        foundClient.getAccounts().stream().map(a -> foundClient.closeAccount(a.getId()));
    }
}
