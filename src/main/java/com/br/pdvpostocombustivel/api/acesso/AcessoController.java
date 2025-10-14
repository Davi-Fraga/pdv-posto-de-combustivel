package com.br.pdvpostocombustivel.api.acesso;

import com.br.pdvpostocombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostocombustivel.api.acesso.dto.AcessoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/acessos")
public class AcessoController {

    private final AcessoService acessoService;

    public AcessoController(@Qualifier("acessoApiService") AcessoService acessoService) {
        this.acessoService = acessoService;
    }

    @PostMapping("/login")
    public ResponseEntity<AcessoResponse> login(@Valid @RequestBody AcessoRequest request) {
        AcessoResponse response = acessoService.login(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AcessoResponse>> listarTodos() {
        List<AcessoResponse> acessos = acessoService.findAll();
        return ResponseEntity.ok(acessos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AcessoResponse> buscarPorId(@PathVariable Long id) {
        AcessoResponse acesso = acessoService.findById(id);
        return ResponseEntity.ok(acesso);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcessoResponse criar(@Valid @RequestBody AcessoRequest request) {
        return acessoService.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AcessoResponse> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody AcessoRequest request
    ) {
        AcessoResponse atualizado = acessoService.update(id, request);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        acessoService.delete(id);
    }
}
