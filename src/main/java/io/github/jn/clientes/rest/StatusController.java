package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Status;
import io.github.jn.clientes.model.repository.StatusRepository;
import io.github.jn.clientes.rest.dto.StatusDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status")
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

}
