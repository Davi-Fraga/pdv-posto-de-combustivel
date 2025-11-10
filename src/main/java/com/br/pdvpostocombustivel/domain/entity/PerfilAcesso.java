package com.br.pdvpostocombustivel.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Entity
@Table(name = "perfil_acesso")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PerfilAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String status;

    @ElementCollection
    @CollectionTable(name = "perfil_acesso_permissoes", joinColumns = @JoinColumn(name = "perfil_acesso_id"))
    @MapKeyColumn(name = "permissao_chave")
    @Column(name = "permissao_valor")
    private Map<String, Boolean> permissoes;
}
