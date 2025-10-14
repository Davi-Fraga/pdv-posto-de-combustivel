package com.br.pdvpostocombustivel.api.acesso;

import com.br.pdvpostocombustivel.api.acesso.dto.AcessoRequest;
import com.br.pdvpostocombustivel.api.acesso.dto.AcessoResponse;
import com.br.pdvpostocombustivel.domain.entity.Acesso;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("acessoApiService")
public class AcessoService {

    private final com.br.pdvpostocombustivel.domain.service.AcessoService domainService;

    public AcessoService(@Qualifier("acessoService") com.br.pdvpostocombustivel.domain.service.AcessoService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<AcessoResponse> findAll() {
        return domainService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AcessoResponse findById(Long id) {
        return toResponse(domainService.findById(id));
    }

    @Transactional
    public AcessoResponse create(AcessoRequest request) {
        Acesso acesso = toEntity(request);
        Acesso novoAcesso = domainService.save(acesso);
        return toResponse(novoAcesso);
    }

    @Transactional
    public AcessoResponse update(Long id, AcessoRequest request) {
        Acesso acessoAtualizado = toEntity(request);
        Acesso acessoSalvo = domainService.update(id, acessoAtualizado);
        return toResponse(acessoSalvo);
    }

    @Transactional
    public void delete(Long id) {
        domainService.delete(id);
    }

    @Transactional(readOnly = true)
    public AcessoResponse login(AcessoRequest request) {
        Acesso acesso = domainService.login(request.usuario(), request.senha());
        return toResponse(acesso);
    }

    private Acesso toEntity(AcessoRequest request) {
        return new Acesso(
                request.usuario(),
                request.senha(),
                request.tipoAcesso()
        );
    }

    private AcessoResponse toResponse(Acesso acesso) {
        return new AcessoResponse(
                acesso.getId(),
                acesso.getUsuario(),
                acesso.getTipoAcesso()
        );
    }
}
