package one.digitalinnovation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.spring.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
