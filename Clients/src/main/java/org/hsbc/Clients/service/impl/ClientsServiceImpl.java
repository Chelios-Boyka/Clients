package org.hsbc.Clients.service.impl;

import org.hsbc.Clients.dto.ClientsDto;
import org.hsbc.Clients.entity.Clients;
import org.hsbc.Clients.mapper.ClientsMapper;
import org.hsbc.Clients.repository.ClientsRepository;
import org.hsbc.Clients.service.ClientsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsServiceImpl implements ClientsService {

    ClientsRepository clientsRepository;

    public ClientsServiceImpl(ClientsRepository clientsRepository) {

        this.clientsRepository = clientsRepository;
    }

    @Override
    public ClientsDto addClient(ClientsDto clientsDto) {
        Clients clients = ClientsMapper.mapToClient(clientsDto);
        Clients savedClient = clientsRepository.save(clients);

        return ClientsMapper.mapToClientsDto(savedClient);
    }

    @Override
    public ClientsDto getClient(Long id) {
        Clients clients = clientsRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Client with id: " + id + " not found")
                );
        return ClientsMapper.mapToClientsDto(clients);
    }

    @Override
    public ClientsDto deposit(Long id, double amount) {
        Clients clients = clientsRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Client with id: " + id + " not found")
                );
        double total = clients.getBalance() + amount;
        clients.setBalance(total);
        Clients savedClient = clientsRepository.save(clients);

        return ClientsMapper.mapToClientsDto(savedClient);
    }

    @Override
    public ClientsDto withdraw(Long id, double amount) {
        Clients clients = clientsRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Client with id: " + id + " not found")
        );

        if(clients.getBalance()< amount){
            throw new RuntimeException("Insufficient balance... wey");
        }

        double total = clients.getBalance() - amount;
        clients.setBalance(total);

        return ClientsMapper.mapToClientsDto(clients);
    }

    @Override
    public List<ClientsDto> getAllClients() {

        List<Clients> clients = clientsRepository.findAll();

        return clients.stream()
                .map(client -> ClientsMapper.mapToClientsDto(client))
                .collect(Collectors.toList());


                    }


}
