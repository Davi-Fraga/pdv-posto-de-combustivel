package com.br.pdvpostocombustivel.api.estoque;

import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/estoques")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(@Qualifier("estoqueApiService") EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @GetMapping
    public ResponseEntity<List<EstoqueResponse>> listarTodos() {
        List<EstoqueResponse> estoques = estoqueService.findAll();
        return ResponseEntity.ok(estoques);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueResponse> buscarPorId(@PathVariable Long id) {
        EstoqueResponse estoque = estoqueService.findById(id);
        return ResponseEntity.ok(estoque);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EstoqueResponse criar(@Valid @RequestBody EstoqueRequest request) {
        return estoqueService.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstoqueResponse> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody EstoqueRequest request
    ) {
        EstoqueResponse atualizado = estoqueService.update(id, request);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EstoqueResponse> atualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> campos
    ) {
        EstoqueResponse atualizado = estoqueService.updatePartial(id, campos);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        estoqueService.delete(id);
    }
}
