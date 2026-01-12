package org.hsbc.Clients.service;

import org.hsbc.Clients.dto.ClientsDto;

import java.util.List;

public interface ClientsService {

    ClientsDto addClient(ClientsDto clientsDto);

    ClientsDto getClient(Long id);

    ClientsDto deposit(Long id, double amount);

    ClientsDto withdraw(Long id, double amount);

    List<ClientsDto> getAllClients();

}
