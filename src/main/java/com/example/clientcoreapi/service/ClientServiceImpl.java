package com.example.clientcoreapi.service;

import com.example.clientcoreapi.controller.ClientController;
import com.example.clientcoreapi.entity.ClientEntity;
import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setClientId(UUID.randomUUID().toString());
        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);
        clientRepository.save(clientEntity);
    }

    @Override
    public List<ClientModel> getAllClients() {
        List<ClientModel> clientModels = new ArrayList<>();
        clientRepository.findAll().forEach(clientEntity -> {
            clientModels.add(modelMapper.map(clientEntity, ClientModel.class));
        });
        return clientModels;
    }

    @Override
    public ClientModel getClientById(String clientId) {
        ClientEntity clientEntity = clientRepository.findById(clientId).get();
        return modelMapper.map(clientEntity, ClientModel.class);
    }

    @Override
    public void updateClientById(String clientId, ClientModel clientModel) {
        clientModel.setClientId(clientId);
        ClientEntity clientEntity = modelMapper.map(clientModel, ClientEntity.class);
        clientRepository.save(clientEntity);
    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepository.deleteById(clientId);
    }
}
