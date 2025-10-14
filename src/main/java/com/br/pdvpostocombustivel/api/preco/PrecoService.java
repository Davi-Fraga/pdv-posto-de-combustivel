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
    public List<PrecoResponse> findAllByEstoque(Long estoqueId) {
        return domainService.findAllByEstoque(estoqueId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PrecoResponse findById(Long precoId) {
        return toResponse(domainService.findById(precoId));
    }

    @Transactional
    public PrecoResponse create(Long estoqueId, PrecoRequest request) {
        Preco preco = toEntity(request);
        Preco novoPreco = domainService.save(estoqueId, preco);
        return toResponse(novoPreco);
    }

    @Transactional
    public PrecoResponse update(Long precoId, PrecoRequest request) {
        Preco precoAtualizado = toEntity(request);
        Preco precoSalvo = domainService.update(precoId, precoAtualizado);
        return toResponse(precoSalvo);
    }

    @Transactional
    public PrecoResponse updatePartial(Long precoId, Map<String, Object> fields) {
        Preco precoExistente = domainService.findById(precoId);

        fields.forEach((key, value) -> {
            switch (key) {
                case "valor":
                    precoExistente.setValor(new BigDecimal(value.toString()));
                    break;
                case "dataVigencia":
                    precoExistente.setDataVigencia(LocalDate.parse(value.toString()));
                    break;
                case "tipoPreco":
                    precoExistente.setTipoPreco(TipoPreco.valueOf((String) value));
                    break;
            }
        });

        // O save aqui é do domainService, mas como o objeto já está carregado, o update funcionaria.
        // No entanto, para manter o padrão, chamamos o update do domain service.
        Preco precoSalvo = domainService.update(precoId, precoExistente);
        return toResponse(precoSalvo);
    }

    @Transactional
    public void delete(Long precoId) {
        domainService.delete(precoId);
    }

    private Preco toEntity(PrecoRequest request) {
        // O estoque é nulo aqui, pois será definido no serviço de domínio.
        return new Preco(
                request.valor(),
                request.dataVigencia(),
                request.tipoPreco(),
                null
        );
    }

    private PrecoResponse toResponse(Preco preco) {
        return new PrecoResponse(
                preco.getId(),
                preco.getValor(),
                preco.getDataVigencia(),
                preco.getTipoPreco(),
                preco.getEstoque() != null ? preco.getEstoque().getId() : null
        );
    }
}
