package io.github.julianovsr.clientes.model.repository;

import io.github.julianovsr.clientes.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



}
