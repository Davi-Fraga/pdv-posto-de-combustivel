package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contatos")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(@Qualifier("contatoApiService") ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping
    public List<ContatoResponse> listarContatos() {
        return contatoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoResponse criarContato(
            @Valid @RequestBody ContatoRequest request
    ) {
        return contatoService.create(request);
    }

    @GetMapping("/{id}")
    public ContatoResponse buscarContatoPorId(@PathVariable Long id) {
        return contatoService.findById(id);
    }

    @PutMapping("/{id}")
    public ContatoResponse atualizarContato(
            @PathVariable Long id,
            @Valid @RequestBody ContatoRequest request
    ) {
        return contatoService.update(id, request);
    }

    @PatchMapping("/{id}")
    public ContatoResponse patch(@PathVariable Long id, @Valid @RequestBody ContatoRequest req) {
        return contatoService.patch(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContato(@PathVariable Long id) {
        contatoService.delete(id);
    }
}
