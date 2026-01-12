package org.hsbc.Clients.controller;


import org.hsbc.Clients.dto.ClientsDto;
import org.hsbc.Clients.service.ClientsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/clients")
public class ClientsController {

    ClientsService clientsService;

    public ClientsController(ClientsService clientsService) {
        this.clientsService = clientsService;
    }

    //Add Client REST API
    @PostMapping
    public ResponseEntity<ClientsDto> addClient(@RequestBody ClientsDto clientsDto) {
        return new
                ResponseEntity<>(clientsService.addClient(clientsDto),
                HttpStatus.CREATED);
    }

    //Deposit client REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<ClientsDto> depositClient(@PathVariable Long id,
                                                Map<String, Double> request) {
        Double amount = request.get("amount");
        ClientsDto clientsDto = clientsService.deposit(id, amount);
        return ResponseEntity.ok(clientsDto);
    }

    //Get client REST API
    @GetMapping("/{id}")
    public ResponseEntity<ClientsDto> getClient(@PathVariable Long id){
        ClientsDto clientsDto = clientsService.getClient(id);
        return ResponseEntity.ok(clientsDto);
    }

    //Withdraw REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<ClientsDto> withdraw(@PathVariable Long id,
                                               @RequestBody Map<String, Double> request) {

        double amount = request.get("amount");
        ClientsDto clientsDto = clientsService.withdraw(id, amount);

        return ResponseEntity.ok(clientsDto);

    }

}
