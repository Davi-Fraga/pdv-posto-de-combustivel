package com.br.pdvpostocombustivel.api.contato;

import com.br.pdvpostocombustivel.api.contato.dto.ContatoRequest;
import com.br.pdvpostocombustivel.api.contato.dto.ContatoResponse;
import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import com.br.pdvpostocombustivel.domain.repository.PessoaRepository;
import com.br.pdvpostocombustivel.domain.entity.Contato;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service("contatoApiService")
public class ContatoService {

    private final com.br.pdvpostocombustivel.domain.service.ContatoService domainService;
    private final PessoaRepository pessoaRepository;

    public ContatoService(@Qualifier("contatoService") com.br.pdvpostocombustivel.domain.service.ContatoService domainService, PessoaRepository pessoaRepository) {
        this.domainService = domainService;
        this.pessoaRepository = pessoaRepository;
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
        Contato contato = toEntity(request, request.pessoaId());
        Contato novoContato = domainService.save(contato);
        return toResponse(novoContato);
    }

    @Transactional
    public ContatoResponse update(Long contatoId, ContatoRequest request) {
        Contato contatoAtualizado = toEntity(request, request.pessoaId());
        Contato contatoSalvo = domainService.update(contatoId, contatoAtualizado);
        return toResponse(contatoSalvo);
    }

    @Transactional
    public ContatoResponse patch(Long id, ContatoRequest req) {
        // O patch não deveria alterar a pessoa associada, então passamos null.
        Contato contatoAtualizado = domainService.patch(id, toEntity(req, req.pessoaId()), null);
        return toResponse(contatoAtualizado);
    }

    @Transactional
    public void delete(Long contatoId) {
        domainService.delete(contatoId);
    }

    private Contato toEntity(ContatoRequest request, Long pessoaId) {
        Contato contato = new Contato(request.telefone(), request.email(), request.endereco(), request.tipoContato());
        if (pessoaId != null) {
            Pessoa pessoa = pessoaRepository.findById(pessoaId).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada com o ID: " + pessoaId));
            contato.setPessoa(pessoa);
        }
        return contato;
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
