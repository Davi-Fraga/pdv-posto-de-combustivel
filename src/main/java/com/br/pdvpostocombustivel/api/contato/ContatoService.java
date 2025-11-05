package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import com.br.pdvpostocombustivel.domain.entity.Contato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("contatoApiService")
public class ContatoService {

    private final com.br.pdvpostocombustivel.domain.service.ContatoService domainService;

    public ContatoService(@Qualifier("contatoService") com.br.pdvpostocombustivel.domain.service.ContatoService domainService) {
        this.domainService = domainService;
    }

    @Transactional(readOnly = true)
    public List<ContatoResponse> findAll() {
        return domainService.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContatoResponse findById(Long contatoId) {
        return toResponse(domainService.findById(contatoId));
    }

    @Transactional
    public ContatoResponse create(ContatoRequest request) {
        Contato contato = toEntity(request);
        Contato novoContato = domainService.save(contato);
        return toResponse(novoContato);
    }

    @Transactional
    public ContatoResponse update(Long contatoId, ContatoRequest request) {
        Contato contatoAtualizado = toEntity(request);
        Contato contatoSalvo = domainService.update(contatoId, contatoAtualizado);
        return toResponse(contatoSalvo);
    }

    @Transactional
    public ContatoResponse patch(Long id, ContatoRequest req) {
        Contato contato = toEntity(req);
        Contato contatoAtualizado = domainService.patch(id, contato);
        return toResponse(contatoAtualizado);
    }

    @Transactional
    public void delete(Long contatoId) {
        domainService.delete(contatoId);
    }

    private Contato toEntity(ContatoRequest request) {
        return new Contato(request.telefone(), request.email(), request.endereco(), request.tipoContato());
    }

    private ContatoResponse toResponse(Contato contato) {
        return new ContatoResponse(
                contato.getId(),
                contato.getTelefone(),
                contato.getEmail(),
                contato.getEndereco(),
                contato.getTipoContato()
        );
    }
}
