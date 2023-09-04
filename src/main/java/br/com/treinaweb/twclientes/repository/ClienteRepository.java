package br.com.treinaweb.twclientes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.treinaweb.twclientes.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    @EntityGraph(attributePaths = "endereco")
    List<Cliente> findAll();
}
