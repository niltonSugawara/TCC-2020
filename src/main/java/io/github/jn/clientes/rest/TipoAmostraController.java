package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.TipoAmostra;
import io.github.jn.clientes.model.repository.TipoAmostraRepository;
import io.github.jn.clientes.rest.dto.TipoAmostraDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
