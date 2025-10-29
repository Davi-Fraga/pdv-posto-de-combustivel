package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    /**
     * Encontra um produto pela sua referência.
     * @param referencia A referência a ser buscada.
     * @return Um Optional contendo o Produto se encontrado, ou vazio caso contrário.
     */
    Optional<Produto> findByReferencia(String referencia);

    /**
     * Verifica se já existe um produto com a referência fornecida.
     * @param referencia A referência a ser verificada.
     * @return true se o produto existir, false caso contrário.
     */
    boolean existsByReferencia(String referencia);
}
