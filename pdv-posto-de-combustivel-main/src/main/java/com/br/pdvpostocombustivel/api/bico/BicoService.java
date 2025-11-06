package com.br.pdvpostocombustivel.api.bico;

import com.br.pdvpostocombustivel.api.bico.dto.BicoRequest;
import com.br.pdvpostocombustivel.api.bico.dto.BicoResponse;
import com.br.pdvpostocombustivel.api.produto.dto.ProdutoResponse;
import com.br.pdvpostocombustivel.domain.entity.Bico;
import com.br.pdvpostocombustivel.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("bicoApiService")
public class BicoService {

    private final com.br.pdvpostocombustivel.domain.service.BicoService domainService;

    public BicoService(@Qualifier("bicoDomainService") com.br.pdvpostocombustivel.domain.service.BicoService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<BicoResponse> findAll() {
        return domainService.findAll().stream().map(this::toResponse).collect(Collectors.toList());
    }

    @Transactional
    public BicoResponse create(BicoRequest request) {
        Bico bico = new Bico(request.nome(), request.status(), null);
        Bico novoBico = domainService.save(bico, request.produtoId());
        return toResponse(novoBico);
    }

    @Transactional
    public BicoResponse update(Long id, BicoRequest request) {
        Bico bico = new Bico(request.nome(), request.status(), null);
        Bico bicoAtualizado = domainService.update(id, bico, request.produtoId());
        return toResponse(bicoAtualizado);
    }

    @Transactional
    public void delete(Long id) {
        domainService.delete(id);
    }

    private BicoResponse toResponse(Bico bico) {
        Produto p = bico.getProduto();
        ProdutoResponse produtoResponse = new ProdutoResponse(
                p.getId(), p.getNome(), p.getReferencia(), p.getFornecedor(),
                p.getMarca(), p.getCategoria(), p.getTipoProduto(), p.getPrecoVenda()
        );

        return new BicoResponse(
                bico.getId(), bico.getNome(), bico.getStatus(), produtoResponse
        );
    }
}