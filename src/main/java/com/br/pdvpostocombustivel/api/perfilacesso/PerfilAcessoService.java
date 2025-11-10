package com.br.pdvpostocombustivel.api.perfilacesso;

import com.br.pdvpostocombustivel.api.perfilacesso.dto.PerfilAcessoResponse;

import java.util.List;

public interface PerfilAcessoService {
    List<PerfilAcessoResponse> findAll();
}
