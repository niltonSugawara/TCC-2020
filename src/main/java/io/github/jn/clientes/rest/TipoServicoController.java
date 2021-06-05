package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Tecnico;
import io.github.jn.clientes.model.entity.TipoServico;
import io.github.jn.clientes.model.repository.TipoServicoRepository;
import io.github.jn.clientes.rest.dto.TipoServicoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tiposervico")
@CrossOrigin("http://localhost:4200")
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

    @GetMapping("{id}")
    public TipoServico buscarTipoServicoPorId (@PathVariable Integer id) {
        return tipoServicoRepository
                .findById(id)
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Tipo Servico não encontrado.")
                );
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarTipoServicoPorId (@PathVariable Integer id) {
        tipoServicoRepository
                .findById(id)
                .map(tipoServico -> {
                    tipoServicoRepository.delete(tipoServico);
                    return Void.TYPE;
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Tipo Servico não encontrado.")
                );
    }

    @PutMapping("{id}")
    public void atualizarTipoServico (@PathVariable Integer id, @RequestBody @Valid
            TipoServico tipoServicoAtualizado){
        tipoServicoRepository
                .findById(id)
                .map(tipoServico -> {
                    tipoServico.setNome(tipoServicoAtualizado.getNome());
                    return tipoServicoRepository.save(tipoServicoAtualizado);
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Tipo Servico não encontrado.")
                );
    }
}
