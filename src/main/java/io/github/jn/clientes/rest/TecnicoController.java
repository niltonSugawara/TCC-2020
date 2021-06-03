package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Tecnico;
import io.github.jn.clientes.model.repository.TecnicoRepository;
import io.github.jn.clientes.rest.dto.TecnicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tecnico")
@RequiredArgsConstructor
public class TecnicoController {

    private final TecnicoRepository tecnicoRepository;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED )
    public Tecnico salvarTecnico (@RequestBody TecnicoDTO dto){

        Tecnico tecnico = new Tecnico();
        tecnico.setNome(dto.getNome());
        tecnico.setCrq(dto.getCrq());

        return tecnicoRepository.save(tecnico);
    }

    @GetMapping
    public List<Tecnico> buscarTecnico(){
                return tecnicoRepository.findAll();
    }
}
