package com.example.clientcoreapi.controller;

import com.example.clientcoreapi.model.ClientModel;
import com.example.clientcoreapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel) {
        clientService.createClient(clientModel);
        return new ResponseEntity<>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ClientModel getClientById(@PathVariable String clientId) {
        return clientService.getClientById(clientId);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<String> updateClientById(
            @PathVariable String clientId,
            @Valid @RequestBody ClientModel clientModel
    ) {
        clientService.updateClientById(clientId, clientModel);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteClientById(
            @PathVariable String clientId
    ) {
        clientService.deleteClientById(clientId);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }

    @GetMapping("/check")
    public String checkClient() {
        return "client-core-api is working";
    }

}
