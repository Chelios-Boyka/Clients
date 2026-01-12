package org.hsbc.Clients.repository;


import org.hsbc.Clients.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
