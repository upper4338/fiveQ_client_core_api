package com.example.clientcoreapi.repository;

import com.example.clientcoreapi.entity.ClientEntity;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientEntity, String> {
}
