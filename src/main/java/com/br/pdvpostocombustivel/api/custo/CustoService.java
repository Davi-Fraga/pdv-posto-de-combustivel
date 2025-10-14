package com.br.pdvpostocombustivel.api.custo;

import com.br.pdvpostocombustivel.api.custo.dto.CustoRequest;
import com.br.pdvpostocombustivel.api.custo.dto.CustoResponse;
import com.br.pdvpostocombustivel.domain.entity.Custo;
import com.br.pdvpostocombustivel.enums.TipoCusto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("custoApiService")
public class CustoService {

    private final com.br.pdvpostocombustivel.domain.service.CustoService domainService;

    public CustoService(@Qualifier("custoService") com.br.pdvpostocombustivel.domain.service.CustoService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<CustoResponse> findAll() {
        return domainService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CustoResponse findById(Long id) {
        return toResponse(domainService.findById(id));
    }

    @Transactional
    public CustoResponse create(CustoRequest request) {
        Custo custo = toEntity(request);
        Custo novoCusto = domainService.save(custo);
        return toResponse(novoCusto);
    }

    @Transactional
    public CustoResponse update(Long id, CustoRequest request) {
        Custo custoAtualizado = toEntity(request);
        Custo custoSalvo = domainService.update(id, custoAtualizado);
        return toResponse(custoSalvo);
    }

    @Transactional
    public CustoResponse updatePartial(Long id, Map<String, Object> fields) {
        Custo custoExistente = domainService.findById(id);

        fields.forEach((key, value) -> {
            switch (key) {
                case "descricao":
                    custoExistente.setDescricao((String) value);
                    break;
                case "valor":
                    custoExistente.setValor(new BigDecimal(value.toString()));
                    break;
                case "dataVencimento":
                    custoExistente.setDataVencimento(LocalDate.parse(value.toString()));
                    break;
                case "tipoCusto":
                    custoExistente.setTipoCusto(TipoCusto.valueOf((String) value));
                    break;
            }
        });

        Custo custoSalvo = domainService.save(custoExistente);
        return toResponse(custoSalvo);
    }

    @Transactional
    public void delete(Long id) {
        domainService.delete(id);
    }

    private Custo toEntity(CustoRequest request) {
        return new Custo(
                request.descricao(),
                request.valor(),
                request.dataVencimento(),
                request.tipoCusto()
        );
    }

    private CustoResponse toResponse(Custo custo) {
        return new CustoResponse(
                custo.getId(),
                custo.getDescricao(),
                custo.getValor(),
                custo.getDataVencimento(),
                custo.getTipoCusto()
        );
    }
}
