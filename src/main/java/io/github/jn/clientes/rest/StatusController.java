package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Orcamento;
import io.github.jn.clientes.model.entity.Status;
import io.github.jn.clientes.model.repository.StatusRepository;
import io.github.jn.clientes.rest.dto.StatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/status")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class StatusController {

    private final StatusRepository statusRepository;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Status salvarStatus(@RequestBody StatusDTO dto){
        Status status = new Status();
        status.setNome(dto.getNome());

        return statusRepository.save(status);

    }

    @GetMapping
    public List<Status> buscaStatus(){
        return statusRepository.findAll();
    }

    @GetMapping("{id}")
    public Status buscarStatusPorId (@PathVariable Integer id){
        return statusRepository
                .findById(id)
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Status não encontrado")
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarStatusPorId (@PathVariable Integer id){
        statusRepository
                .findById(id)
                .map(status -> {
                    statusRepository.delete(status);
                    return Void.TYPE;
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Orçamento não encontrado")
                );
    }

    @PutMapping("{id}")
    public void atualizarOrcamento (@PathVariable Integer id, @RequestBody @Valid
            Status statusAtualizado){
        statusRepository
                .findById(id)
                .map(orcamento -> {
                    orcamento.setNome(statusAtualizado.getNome());

                    return statusRepository.save(statusAtualizado);
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Status não encontrado")
                );
    }

}
