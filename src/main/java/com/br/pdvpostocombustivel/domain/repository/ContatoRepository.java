package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

    /**
     * Encontra todos os contatos associados a um ID de pessoa específico.
     * @param pessoaId O ID da pessoa.
     * @return Uma lista de contatos pertencentes à pessoa.
     */
    List<Contato> findByPessoaId(Long pessoaId);
}
