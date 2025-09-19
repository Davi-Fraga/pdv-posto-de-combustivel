package com.br.pdvpostocombustivel.api.pessoa.dto;

import java.util.Date;

public record CustoResponce(
        Long id,
        Double imposto,
        Double custoVariavel,
        Double custoFixo,
        Double margemLucro,
        Date dataProcessamento

) {
}
