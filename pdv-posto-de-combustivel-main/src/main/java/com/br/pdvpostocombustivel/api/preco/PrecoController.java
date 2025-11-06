package com.br.pdvpostocombustivel.api.preco;

import com.br.pdvpostocombustivel.api.preco.dto.PrecoRequest;
import com.br.pdvpostocombustivel.api.preco.dto.PrecoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/precos")
public class PrecoController {

    private final PrecoService precoService;

    public PrecoController(@Qualifier("precoApiService") PrecoService precoService) {
        this.precoService = precoService;
    }

    @GetMapping
    public ResponseEntity<List<PrecoResponse>> listarPrecos() {
        List<PrecoResponse> precos = precoService.findAll();
        return ResponseEntity.ok(precos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PrecoResponse criarPreco(@Valid @RequestBody PrecoRequest request) {
        return precoService.create(request);
    }

    @GetMapping("/{precoId}")
    public ResponseEntity<PrecoResponse> buscarPrecoPorId(@PathVariable Long precoId) {
        PrecoResponse preco = precoService.findById(precoId);
        return ResponseEntity.ok(preco);
    }

    @PutMapping("/{precoId}")
    public ResponseEntity<PrecoResponse> atualizarPreco(
            @PathVariable Long precoId,
            @Valid @RequestBody PrecoRequest request
    ) {
        PrecoResponse atualizado = precoService.update(precoId, request);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{precoId}")
    public ResponseEntity<PrecoResponse> atualizarPrecoParcialmente(
            @PathVariable Long precoId,
            @RequestBody Map<String, Object> campos
    ) {
        PrecoResponse atualizado = precoService.updatePartial(precoId, campos);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{precoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPreco(@PathVariable Long precoId) {
        precoService.delete(precoId);
    }
}
