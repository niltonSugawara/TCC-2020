package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Tecnico;
import io.github.jn.clientes.model.entity.TipoAmostra;
import io.github.jn.clientes.model.repository.TipoAmostraRepository;
import io.github.jn.clientes.rest.dto.TipoAmostraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tipoamostra")
@RequiredArgsConstructor
public class TipoAmostraController {

    private final TipoAmostraRepository tipoAmostraRepository;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public TipoAmostra salvarTipoAmostra(@RequestBody TipoAmostraDTO dto){

        TipoAmostra tipoAmostra = new TipoAmostra();
        tipoAmostra.setTipoAmostra(dto.getTipoAmostra());

        return tipoAmostraRepository.save(tipoAmostra);
    }

    @GetMapping
    public List<TipoAmostra> buscaTipoAmostra(){
        return tipoAmostraRepository.findAll();
    }

    @GetMapping("{id}")
    public TipoAmostra buscarTipoAmostraPorId (@PathVariable Integer id){
            return  tipoAmostraRepository
                    .findById(id)
                    .orElseThrow(
                            ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                    "Tipo Amostra não encontrado")
                    );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTipoAmostraPorId (@PathVariable Integer id) {
        tipoAmostraRepository
                .findById(id)
                .map(tipoAmostra -> {
                    tipoAmostraRepository.delete(tipoAmostra);
                    return Void.TYPE;
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Tipo Amostra não encontrado")
                );
    }

    @PutMapping("{id}")
    public void atualizarTipoAmostra (@PathVariable Integer id, @RequestBody @Valid
            TipoAmostra tipoAmostraAtualizado){
        tipoAmostraRepository
                .findById(id)
                .map(tipoAmostra -> {
                    tipoAmostra.setTipoAmostra(tipoAmostraAtualizado.getTipoAmostra());
                    return tipoAmostraRepository.save(tipoAmostraAtualizado);
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Tipo Amostra não encontrado")
                );
    }

}
