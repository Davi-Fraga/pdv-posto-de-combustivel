package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Acesso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcessoRepository extends JpaRepository<Acesso, Long> {

    /**
     * Encontra um acesso pelo nome de usuário.
     * @param usuario O nome de usuário a ser buscado.
     * @return Um Optional contendo o Acesso se encontrado, ou vazio caso contrário.
     */
    Optional<Acesso> findByUsuario(String usuario);

    /**
     * Verifica se já existe um acesso com o nome de usuário fornecido.
     * @param usuario O nome de usuário a ser verificado.
     * @return true se o usuário existir, false caso contrário.
     */
    boolean existsByUsuario(String usuario);
}
