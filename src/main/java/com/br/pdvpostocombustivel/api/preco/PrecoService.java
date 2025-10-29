package com.br.pdvpostocombustivel.api.preco;

import com.br.pdvpostocombustivel.api.preco.dto.PrecoRequest;
import com.br.pdvpostocombustivel.api.preco.dto.PrecoResponse;
import com.br.pdvpostocombustivel.domain.entity.Preco;
import com.br.pdvpostocombustivel.enums.TipoPreco;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("precoApiService")
public class PrecoService {

    private final com.br.pdvpostocombustivel.domain.service.PrecoService domainService;

    public PrecoService(@Qualifier("precoService") com.br.pdvpostocombustivel.domain.service.PrecoService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<PrecoResponse> findAll() {
        return domainService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PrecoResponse findById(Long id) {
        return toResponse(domainService.findById(id));
    }

    @Transactional
    public PrecoResponse create(PrecoRequest request) {
        Preco preco = toEntity(request);
        Preco novoPreco = domainService.save(preco);
        return toResponse(novoPreco);
    }

    @Transactional
    public PrecoResponse update(Long id, PrecoRequest request) {
        Preco precoAtualizado = toEntity(request);
        Preco precoSalvo = domainService.update(id, precoAtualizado);
        return toResponse(precoSalvo);
    }

    @Transactional
    public PrecoResponse updatePartial(Long id, Map<String, Object> fields) {
        Preco precoExistente = domainService.findById(id);

        fields.forEach((key, value) -> {
            switch (key) {
                case "dataAlteracao":
                    precoExistente.setDataAlteracao(LocalDate.parse(value.toString()));
                    break;
                case "horaAlteracao":
                    precoExistente.setHoraAlteracao(LocalTime.parse(value.toString()));
                    break;
                case "valor":
                    precoExistente.setValor(new BigDecimal(value.toString()));
                    break;
                case "tipoPreco":
                    precoExistente.setTipoPreco(TipoPreco.valueOf((String) value));
                    break;
            }
        });

        Preco precoSalvo = domainService.update(id, precoExistente);
        return toResponse(precoSalvo);
    }

    @Transactional
    public void delete(Long id) {
        domainService.delete(id);
    }

    private Preco toEntity(PrecoRequest request) {
        return new Preco(
                request.dataAlteracao(),
                request.horaAlteracao(),
                request.valor(),
                request.tipoPreco()
        );
    }

    private PrecoResponse toResponse(Preco preco) {
        return new PrecoResponse(
                preco.getId(),
                preco.getDataAlteracao(),
                preco.getHoraAlteracao(),
                preco.getValor(),
                preco.getTipoPreco()
        );
    }
}
