package com.br.pdvpostocombustivel.api.produto;

import com.br.pdvpostocombustivel.api.produto.dto.ProdutoRequest;
import com.br.pdvpostocombustivel.api.produto.dto.ProdutoResponse;
import com.br.pdvpostocombustivel.domain.entity.Produto;
import com.br.pdvpostocombustivel.enums.TipoProduto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service("produtoApiService")
public class ProdutoService {

    private final com.br.pdvpostocombustivel.domain.service.ProdutoService domainService;

    public ProdutoService(@Qualifier("produtoService") com.br.pdvpostocombustivel.domain.service.ProdutoService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<ProdutoResponse> findAll() {
        return domainService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProdutoResponse findById(Long id) {
        return toResponse(domainService.findById(id));
    }

    @Transactional
    public ProdutoResponse create(ProdutoRequest request) {
        Produto produto = toEntity(request);
        Produto novoProduto = domainService.save(produto);
        return toResponse(novoProduto);
    }

    @Transactional
    public ProdutoResponse update(Long id, ProdutoRequest request) {
        Produto produtoAtualizado = toEntity(request);
        Produto produtoSalvo = domainService.update(id, produtoAtualizado);
        return toResponse(produtoSalvo);
    }

    @Transactional
    public ProdutoResponse updatePartial(Long id, Map<String, Object> fields) {
        Produto produtoExistente = domainService.findById(id);

        fields.forEach((key, value) -> {
            switch (key) {
                case "nome":
                    produtoExistente.setNome((String) value);
                    break;
                case "descricao":
                    produtoExistente.setDescricao((String) value);
                    break;
                case "codigoBarras":
                    produtoExistente.setCodigoBarras((String) value);
                    break;
                case "valorUnitario":
                    produtoExistente.setValorUnitario(new BigDecimal(value.toString()));
                    break;
                case "tipoProduto":
                    produtoExistente.setTipoProduto(TipoProduto.valueOf((String) value));
                    break;
            }
        });

        Produto produtoSalvo = domainService.update(id, produtoExistente);
        return toResponse(produtoSalvo);
    }

    @Transactional
    public void delete(Long id) {
        domainService.delete(id);
    }

    private Produto toEntity(ProdutoRequest request) {
        return new Produto(
                request.nome(),
                request.descricao(),
                request.codigoBarras(),
                request.valorUnitario(),
                request.tipoProduto()
        );
    }

    private ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getCodigoBarras(),
                produto.getValorUnitario(),
                produto.getTipoProduto()
        );
    }
}
