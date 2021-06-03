package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Amostra;
import io.github.jn.clientes.model.repository.AmostraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/amostra")
@CrossOrigin("http://localhost:4200")
public class AmostraController {

    private final AmostraRepository amostraRepository;

    @Autowired
    public AmostraController(AmostraRepository amostraRepository) {
        this.amostraRepository = amostraRepository;
    }

    @GetMapping
    public List<Amostra> buscarAmostra (){
        return amostraRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Amostra salvarAmostra (@RequestBody @Valid Amostra amostra) {
        return  amostraRepository.save(amostra);
    }

    @GetMapping("{id}")
    public Amostra buscarAmostraPorId (@PathVariable Integer id){
        return amostraRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Amostra não encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAmostra (@PathVariable Integer id) {
        amostraRepository
                .findById(id)
                .map(amostra -> {
                    amostraRepository.delete(amostra);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Amostra não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarAmostra (@PathVariable Integer id, @RequestBody @Valid
                                  Amostra amostraAtualizada){
        amostraRepository
                .findById(id)
                .map(amostra -> {
                    amostra.setNome(amostraAtualizada.getNome());
                    amostra.setDescricao(amostraAtualizada.getDescricao());
                    amostra.setTipoAmostra(amostraAtualizada.getTipoAmostra());
                    amostra.setStatus(amostraAtualizada.getStatus());
                    amostra.setCliente(amostraAtualizada.getCliente());
                    return amostraRepository.save(amostraAtualizada);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Amostra não encontrada"));
    }
}
