package com.br.pdvpostocombustivel.domain.repository;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;


public interface PrecoRepository extends JpaRepository<Preco, Long> {

  /*  Optional<Preco> findByValor(BigDecimal valor);

    Optional<Preco> findByDataAlteracao(String dataAlteracao);

    Optional<Preco> findByHoraAlteracao(Date horaAlteracao);

    boolean existsByValor(BigDecimal valor);

    boolean existsByDataAlteracao(String dataAlteracao);

    boolean existsByHoraAlteracao(Date horaAlteracao);*/


}