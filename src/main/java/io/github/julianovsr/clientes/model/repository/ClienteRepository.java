package io.github.julianovsr.clientes.model.repository;

import io.github.julianovsr.clientes.model.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {

}
