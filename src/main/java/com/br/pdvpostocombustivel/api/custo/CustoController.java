package com.br.pdvpostocombustivel.api.custo;

import com.br.pdvpostocombustivel.api.custo.dto.CustoRequest;
import com.br.pdvpostocombustivel.api.custo.dto.CustoResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/custos")
public class CustoController {

    private final CustoService custoService;

    public CustoController(@Qualifier("custoApiService") CustoService custoService) {
        this.custoService = custoService;
    }

    @GetMapping
    public ResponseEntity<List<CustoResponse>> listarTodos() {
        List<CustoResponse> custos = custoService.findAll();
        return ResponseEntity.ok(custos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustoResponse> buscarPorId(@PathVariable Long id) {
        CustoResponse custo = custoService.findById(id);
        return ResponseEntity.ok(custo);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustoResponse criar(@Valid @RequestBody CustoRequest request) {
        return custoService.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustoResponse> atualizar(
            @PathVariable Long id,
            @Valid @RequestBody CustoRequest request
    ) {
        CustoResponse atualizado = custoService.update(id, request);
        return ResponseEntity.ok(atualizado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustoResponse> atualizarParcialmente(
            @PathVariable Long id,
            @RequestBody Map<String, Object> campos
    ) {
        CustoResponse atualizado = custoService.updatePartial(id, campos);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        custoService.delete(id);
    }
}
