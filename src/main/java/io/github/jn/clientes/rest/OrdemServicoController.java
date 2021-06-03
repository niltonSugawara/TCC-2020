package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.OrdemServico;
import io.github.jn.clientes.model.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ordemservico")
@CrossOrigin("http://localhost:4200")
public class OrdemServicoController {

    private final OrdemServicoRepository ordemServicoRepository;

    @Autowired
    public OrdemServicoController(OrdemServicoRepository ordemServicoRepository) {
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @GetMapping
    public List<OrdemServico> buscarOrdemServico () {
        return ordemServicoRepository.findAll();
    }

    @GetMapping("{id}")
    public OrdemServico buscarOrdemServicoPorId (@PathVariable Integer id) {
        return ordemServicoRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Ordem de Servico não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico salvarOrdemServico (@RequestBody @Valid OrdemServico ordemServico) {
        return  ordemServicoRepository.save(ordemServico);
    }
}
