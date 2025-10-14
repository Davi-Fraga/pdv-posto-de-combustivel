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
@RequestMapping("/api/v1")
public class PrecoController {

    private final PrecoService precoService;

    public PrecoController(@Qualifier("precoApiService") PrecoService precoService) {
        this.precoService = precoService;
    }

    // --- Endpoints aninhados sob Estoque --- //

    @GetMapping("/estoques/{estoqueId}/precos")
    public ResponseEntity<List<PrecoResponse>> listarPrecosPorEstoque(@PathVariable Long estoqueId) {
        List<PrecoResponse> precos = precoService.findAllByEstoque(estoqueId);
        return ResponseEntity.ok(precos);
    }

    @PostMapping("/estoques/{estoqueId}/precos")
    @ResponseStatus(HttpStatus.CREATED)
    public PrecoResponse criarPrecoParaEstoque(
            @PathVariable Long estoqueId,
            @Valid @RequestBody PrecoRequest request
    ) {
        return precoService.create(estoqueId, request);
    }

    // --- Endpoints diretos para Preco --- //

    @GetMapping("/precos/{precoId}")
    public ResponseEntity<PrecoResponse> buscarPrecoPorId(@PathVariable Long precoId) {
        PrecoResponse preco = precoService.findById(precoId);
        return ResponseEntity.ok(preco);
    }

    @PutMapping("/precos/{precoId}")
    public ResponseEntity<PrecoResponse> atualizarPreco(
            @PathVariable Long precoId,
            @Valid @RequestBody PrecoRequest request
    ) {
        PrecoResponse atualizado = precoService.update(precoId, request);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/precos/{precoId}")
    public ResponseEntity<PrecoResponse> atualizarPrecoParcialmente(
            @PathVariable Long precoId,
            @RequestBody Map<String, Object> campos
    ) {
        PrecoResponse atualizado = precoService.updatePartial(precoId, campos);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/precos/{precoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPreco(@PathVariable Long precoId) {
        precoService.delete(precoId);
    }
}
