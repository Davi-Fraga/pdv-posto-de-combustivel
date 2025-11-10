package com.br.pdvpostocombustivel.api.perfilacesso.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class PerfilAcessoResponse {
    private Long idPerfil;
    private String nomePerfil;
    private String status;
    private Map<String, Boolean> permissoes;
}
