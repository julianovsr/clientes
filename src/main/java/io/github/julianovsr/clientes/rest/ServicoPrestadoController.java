package io.github.julianovsr.clientes.rest;


import io.github.julianovsr.clientes.model.entity.Cliente;
import io.github.julianovsr.clientes.model.entity.ServicoPrestado;
import io.github.julianovsr.clientes.model.repository.ClienteRepository;
import io.github.julianovsr.clientes.model.repository.ServicoPrestadoRepository;
import io.github.julianovsr.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.julianovsr.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository servicoPrestadoRepository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto){
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository.findById(idCliente)
                                            .orElseThrow( () -> new ResponseStatusException(
                                                            HttpStatus.BAD_REQUEST,"Cliente não encontrado"));



        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( bigDecimalConverter.converter(dto.getPreco()) );

        return servicoPrestadoRepository.save(servicoPrestado);

    }

}
