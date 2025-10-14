package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Encontra um produto pelo seu código de barras.
     * @param codigoBarras O código de barras a ser buscado.
     * @return Um Optional contendo o Produto se encontrado, ou vazio caso contrário.
     */
    Optional<Produto> findByCodigoBarras(String codigoBarras);

    /**
     * Verifica se já existe um produto com o código de barras fornecido.
     * @param codigoBarras O código de barras a ser verificado.
     * @return true se o produto existir, false caso contrário.
     */
    boolean existsByCodigoBarras(String codigoBarras);
}
