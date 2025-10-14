package com.br.pdvpostocombustivel.api.estoque;

import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueRequest;
import com.br.pdvpostocombustivel.api.estoque.dto.EstoqueResponse;
import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.enums.TipoEstoque;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("estoqueApiService")
public class EstoqueService {

    private final com.br.pdvpostocombustivel.domain.service.EstoqueService domainService;

    public EstoqueService(@Qualifier("estoqueService") com.br.pdvpostocombustivel.domain.service.EstoqueService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<EstoqueResponse> findAll() {
        return domainService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EstoqueResponse findById(Long id) {
        return toResponse(domainService.findById(id));
    }

    @Transactional
    public EstoqueResponse create(EstoqueRequest request) {
        Estoque estoque = toEntity(request);
        Estoque novoEstoque = domainService.save(estoque);
        return toResponse(novoEstoque);
    }

    @Transactional
    public EstoqueResponse update(Long id, EstoqueRequest request) {
        Estoque estoqueAtualizado = toEntity(request);
        Estoque estoqueSalvo = domainService.update(id, estoqueAtualizado);
        return toResponse(estoqueSalvo);
    }

    @Transactional
    public EstoqueResponse updatePartial(Long id, Map<String, Object> fields) {
        Estoque estoqueExistente = domainService.findById(id);

        fields.forEach((key, value) -> {
            switch (key) {
                case "tipoEstoque":
                    estoqueExistente.setTipoEstoque(TipoEstoque.valueOf((String) value));
                    break;
                case "nomeProduto":
                    estoqueExistente.setNomeProduto((String) value);
                    break;
                case "quantidade":
                    estoqueExistente.setQuantidade(new BigDecimal(value.toString()));
                    break;
                case "fornecedor":
                    estoqueExistente.setFornecedor((String) value);
                    break;
                case "dataEntrada":
                    estoqueExistente.setDataEntrada(LocalDate.parse(value.toString()));
                    break;
            }
        });

        Estoque estoqueSalvo = domainService.save(estoqueExistente);
        return toResponse(estoqueSalvo);
    }

    @Transactional
    public void delete(Long id) {
        domainService.delete(id);
    }

    private Estoque toEntity(EstoqueRequest request) {
        return new Estoque(
                request.tipoEstoque(),
                request.nomeProduto(),
                request.quantidade(),
                request.fornecedor(),
                request.dataEntrada()
        );
    }

    private EstoqueResponse toResponse(Estoque estoque) {
        return new EstoqueResponse(
                estoque.getId(),
                estoque.getTipoEstoque(),
                estoque.getNomeProduto(),
                estoque.getQuantidade(),
                estoque.getFornecedor(),
                estoque.getDataEntrada()
        );
    }
}
