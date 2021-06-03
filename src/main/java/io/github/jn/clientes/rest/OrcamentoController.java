package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Cliente;
import io.github.jn.clientes.model.entity.Orcamento;
import io.github.jn.clientes.model.repository.ClienteRepository;
import io.github.jn.clientes.model.repository.OrcamentoRepository;
import io.github.jn.clientes.rest.dto.OrcamentoDTO;
import io.github.jn.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/orcamento")
@RequiredArgsConstructor
public class OrcamentoController {

    private final ClienteRepository clienteRepository;
    private final OrcamentoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orcamento salvar (@RequestBody OrcamentoDTO dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer id_cliente = dto.getId_cliente();

        Cliente cliente = clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Cliente existente."));

        Orcamento orcamento = new Orcamento();
        orcamento.setDescricao(dto.getDescricao());
        orcamento.setNome(dto.getNome());
        orcamento.setData(data);
        orcamento.setCliente(cliente);
        orcamento.setValor(bigDecimalConverter.converter(dto.getValor()));

        return repository.save(orcamento);
    }

    @GetMapping
    public List<Orcamento> buscarOrcamento (
        @RequestParam(value = "nome", required = false, defaultValue = "") String nome
    ) {

    return repository.findAllByNomeClienteAndMes( "%" + nome + "%");

    }
}
