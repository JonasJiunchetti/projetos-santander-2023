package one.digitalinnovation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.spring.entities.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, String>{
    
}
