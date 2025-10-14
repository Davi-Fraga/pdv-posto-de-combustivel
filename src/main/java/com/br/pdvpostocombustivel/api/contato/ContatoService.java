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
    public List<ContatoResponse> findAllByPessoa(Long pessoaId) {
        return domainService.findAllByPessoa(pessoaId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContatoResponse findById(Long contatoId) {
        return toResponse(domainService.findById(contatoId));
    }

    @Transactional
    public ContatoResponse create(Long pessoaId, ContatoRequest request) {
        Contato contato = toEntity(request);
        Contato novoContato = domainService.save(pessoaId, contato);
        return toResponse(novoContato);
    }

    @Transactional
    public ContatoResponse update(Long contatoId, ContatoRequest request) {
        Contato contatoAtualizado = toEntity(request);
        Contato contatoSalvo = domainService.update(contatoId, contatoAtualizado);
        return toResponse(contatoSalvo);
    }

    @Transactional
    public void delete(Long contatoId) {
        domainService.delete(contatoId);
    }

    private Contato toEntity(ContatoRequest request) {
        // A pessoa é nula aqui, pois será definida no serviço de domínio.
        return new Contato(request.tipoContato(), request.valor(), null);
    }

    private ContatoResponse toResponse(Contato contato) {
        return new ContatoResponse(
                contato.getId(),
                contato.getTipoContato(),
                contato.getValor(),
                contato.getPessoa() != null ? contato.getPessoa().getId() : null
        );
    }
}
