package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrecoRepository extends JpaRepository<Preco, Long> {

    /**
     * Encontra todos os preços associados a um ID de item de estoque específico.
     * @param estoqueId O ID do item de estoque.
     * @return Uma lista de preços pertencentes ao item de estoque.
     */
    List<Preco> findByEstoqueId(Long estoqueId);
}
