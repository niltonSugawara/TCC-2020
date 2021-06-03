package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.NormaTecnica;
import io.github.jn.clientes.model.repository.NormaTecnicaRepository;
import io.github.jn.clientes.rest.dto.NormaTecnicaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/normatecnica")
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
}
