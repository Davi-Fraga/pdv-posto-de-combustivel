package com.br.pdvpostocombustivel.api.bico;

import com.br.pdvpostocombustivel.api.bico.dto.BicoRequest;
import com.br.pdvpostocombustivel.api.bico.dto.BicoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bicos")
public class BicoController {

    private final BicoService bicoService;

    public BicoController(@Qualifier("bicoApiService") BicoService bicoService) {
        this.bicoService = bicoService;
    }

    @GetMapping
    public ResponseEntity<List<BicoResponse>> listarTodos() {
        List<BicoResponse> bicos = bicoService.findAll();
        return ResponseEntity.ok(bicos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BicoResponse criar(@Valid @RequestBody BicoRequest request) {
        return bicoService.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BicoResponse> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody BicoRequest request
    ) {
        BicoResponse atualizado = bicoService.update(id, request);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        bicoService.delete(id);
    }
}