package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.NormaTecnica;
import io.github.jn.clientes.model.repository.NormaTecnicaRepository;
import io.github.jn.clientes.rest.dto.NormaTecnicaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/normatecnica")
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
public class NormaTecnicaController {

    private final NormaTecnicaRepository normaTecnicaRepository;

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public NormaTecnica salvarNormaTecnica (@RequestBody NormaTecnicaDTO dto){

        NormaTecnica normaTecnica = new NormaTecnica();
        normaTecnica.setNome(dto.getNome());
        normaTecnica.setDescricao(dto.getDescricao());

        return normaTecnicaRepository.save(normaTecnica);

    }

    @GetMapping
    public List<NormaTecnica> buscarNormaTecnica (){

        return normaTecnicaRepository.findAll();
    }

    @GetMapping("{id}")
    public NormaTecnica buscarNormaTenicaPoId(@PathVariable Integer id){
        return  normaTecnicaRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Norma Técnica não encontrada"));
    }

    @PutMapping("{id}")
    public void atualizarNormaTecnica (@PathVariable Integer id, @RequestBody @Valid
                                       NormaTecnica normaTecnicaAtualizada ){
        normaTecnicaRepository
                .findById(id)
                .map(normaTecnica ->{
                    normaTecnica.setNome(normaTecnicaAtualizada.getNome());
                    normaTecnica.setDescricao(normaTecnicaAtualizada.getDescricao());
                    normaTecnica.setOrdemServico(normaTecnicaAtualizada.getOrdemServico());

                    return normaTecnicaRepository.save(normaTecnicaAtualizada);
                })
                .orElseThrow(
                        ()-> new ResponseStatusException(HttpStatus.NO_CONTENT,
                                "Norma Técnica não encontrada")
                );
    }

}
