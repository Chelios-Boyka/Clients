package org.hsbc.Clients.mapper;

import org.hsbc.Clients.dto.ClientsDto;
import org.hsbc.Clients.entity.Clients;

public class ClientsMapper {

    public static Clients mapToClient(ClientsDto clientsDto) {
        return new Clients(clientsDto.id(),
                clientsDto.accountHolderName(),
                clientsDto.email(),
                clientsDto.balance(),
                clientsDto.password());
    }

    public static ClientsDto mapToClientsDto(Clients clients) {
        return new ClientsDto(clients.getId(),
                              clients.getAccountHolderName(),
                              clients.getEmail(),
                              clients.getBalance(),
                              clients.getPassword());
    }
}
