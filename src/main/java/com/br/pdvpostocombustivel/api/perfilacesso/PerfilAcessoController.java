package com.br.pdvpostocombustivel.api.perfilacesso;

import com.br.pdvpostocombustivel.api.perfilacesso.dto.PerfilAcessoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/perfil-acessos")
@RequiredArgsConstructor
public class PerfilAcessoController {

    private final PerfilAcessoService perfilAcessoService;

    @GetMapping
    public ResponseEntity<List<PerfilAcessoResponse>> listarTodos() {
        List<PerfilAcessoResponse> perfis = perfilAcessoService.findAll();
        return ResponseEntity.ok(perfis);
    }
}
