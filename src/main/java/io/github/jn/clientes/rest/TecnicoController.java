package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Tecnico;
import io.github.jn.clientes.model.repository.TecnicoRepository;
import io.github.jn.clientes.rest.dto.TecnicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tecnico")
@CrossOrigin("http://localhost:4200")
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

    @GetMapping("{id}")
    public Tecnico buscarTecnicoPorId (@PathVariable Integer id) {
        return tecnicoRepository
                .findById(id)
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Técnico não encontrado.")
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTecnicoPorId (@PathVariable Integer id) {
        tecnicoRepository
                .findById(id)
                .map(tecnico -> {
                    tecnicoRepository.delete(tecnico);
                    return Void.TYPE;
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Técnico não encontrado")
                );
    }

    @PutMapping("{id}")
    public void atualizarTecnico (@PathVariable Integer id, @RequestBody @Valid
                                  Tecnico tecnicoAtualizado){
        tecnicoRepository
                .findById(id)
                .map(tecnico -> {
                    tecnico.setNome(tecnicoAtualizado.getNome());
                    tecnico.setCrq(tecnicoAtualizado.getCrq());
                    return tecnicoRepository.save(tecnicoAtualizado);
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Técnico não encontrado")
                );
    }


}
