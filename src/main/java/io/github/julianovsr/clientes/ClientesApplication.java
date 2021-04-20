package io.github.julianovsr.clientes;

import ch.qos.logback.core.net.server.Client;
import io.github.julianovsr.clientes.model.entity.Cliente;
import io.github.julianovsr.clientes.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientesApplication {

    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository){
        return args -> {

            Cliente cliente = Cliente.builder().cpf("00000000000").nome("Juliano Ramos").build();

            repository.save(cliente);
        };
    }


    public static void main(String[] args) {

        SpringApplication.run(ClientesApplication.class,args);

    }
}
