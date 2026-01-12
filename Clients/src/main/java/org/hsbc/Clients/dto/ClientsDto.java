package org.hsbc.Clients.dto;

public record ClientsDto(
        Long id,
        String accountHolderName,
        String email,
        Double balance,
        String password) {
}
