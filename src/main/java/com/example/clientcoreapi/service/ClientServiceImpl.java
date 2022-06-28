package com.example.clientcoreapi.service;

import com.example.clientcoreapi.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    private static final HashMap<String, ClientModel> clientMap = new HashMap<>();

    static {
        ClientModel c1 = new ClientModel(
                UUID.randomUUID().toString()
        );
        clientMap.put(c1.getClientId(), c1);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getClientId(), clientModel);
    }

    @Override
    public List<ClientModel> getAllClients() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String clientId) {
        return clientMap.get(clientId);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        clientMap.put(clientId, clientModel);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientMap.remove(clientId);
    }
}
