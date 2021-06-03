package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.TipoServico;
import io.github.jn.clientes.model.repository.TipoServicoRepository;
import io.github.jn.clientes.rest.dto.TipoServicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tiposervico")
@RequiredArgsConstructor
public class TipoServicoController {

    private final TipoServicoRepository tipoServicoRepository;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public  TipoServico salvarTipoServico (@RequestBody TipoServicoDTO dto){

        TipoServico tipoServico = new TipoServico();
        tipoServico.setNome(dto.getNome());

        return tipoServicoRepository.save(tipoServico);
    }

    @GetMapping
    public List<TipoServico> buscarTipoServico (){

        return tipoServicoRepository.findAll();
    }
}
