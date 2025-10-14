package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContatoController {

    private final ContatoService contatoService;

    public ContatoController(@Qualifier("contatoApiService") ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    // --- Endpoints aninhados sob Pessoa --- //

    @GetMapping("/pessoas/{pessoaId}/contatos")
    public ResponseEntity<List<ContatoResponse>> listarContatosPorPessoa(@PathVariable Long pessoaId) {
        List<ContatoResponse> contatos = contatoService.findAllByPessoa(pessoaId);
        return ResponseEntity.ok(contatos);
    }

    @PostMapping("/pessoas/{pessoaId}/contatos")
    @ResponseStatus(HttpStatus.CREATED)
    public ContatoResponse criarContatoParaPessoa(
            @PathVariable Long pessoaId,
            @Valid @RequestBody ContatoRequest request
    ) {
        return contatoService.create(pessoaId, request);
    }

    // --- Endpoints diretos para Contato --- //

    @GetMapping("/contatos/{contatoId}")
    public ResponseEntity<ContatoResponse> buscarContatoPorId(@PathVariable Long contatoId) {
        ContatoResponse contato = contatoService.findById(contatoId);
        return ResponseEntity.ok(contato);
    }

    @PutMapping("/contatos/{contatoId}")
    public ResponseEntity<ContatoResponse> atualizarContato(
            @PathVariable Long contatoId,
            @Valid @RequestBody ContatoRequest request
    ) {
        ContatoResponse atualizado = contatoService.update(contatoId, request);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/contatos/{contatoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContato(@PathVariable Long contatoId) {
        contatoService.delete(contatoId);
    }
}
