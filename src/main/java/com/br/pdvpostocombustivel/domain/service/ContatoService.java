package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.entity.Pessoa;
import com.br.pdvpostocombustivel.domain.repository.ContatoRepository;
import com.br.pdvpostocombustivel.domain.repository.PessoaRepository;
import com.br.pdvpostocombustivel.exception.ContatoException;
import com.br.pdvpostocombustivel.exception.PessoaException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ContatoService {

    private final ContatoRepository contatoRepository;
    private final PessoaRepository pessoaRepository;

    public ContatoService(ContatoRepository contatoRepository, PessoaRepository pessoaRepository) {
        this.contatoRepository = contatoRepository;
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional(readOnly = true)
    public List<Contato> findAllByPessoa(Long pessoaId) {
        if (!pessoaRepository.existsById(pessoaId)) {
            throw new PessoaException("Pessoa com ID " + pessoaId + " não encontrada.");
        }
        return contatoRepository.findByPessoaId(pessoaId);
    }

    @Transactional(readOnly = true)
    public Contato findById(Long contatoId) {
        return contatoRepository.findById(contatoId)
                .orElseThrow(() -> new ContatoException("Contato com ID " + contatoId + " não encontrado."));
    }

    @Transactional
    public Contato save(Long pessoaId, Contato contato) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new PessoaException("Não é possível adicionar contato a uma pessoa inexistente. ID: " + pessoaId));
        contato.setPessoa(pessoa);
        return contatoRepository.save(contato);
    }

    @Transactional
    public Contato update(Long contatoId, Contato contatoAtualizado) {
        Contato contatoExistente = findById(contatoId);

        contatoExistente.setTipoContato(contatoAtualizado.getTipoContato());
        contatoExistente.setValor(contatoAtualizado.getValor());
        // A pessoa associada ao contato não deve ser alterada em uma atualização de contato.

        return contatoRepository.save(contatoExistente);
    }

    @Transactional
    public void delete(Long contatoId) {
        if (!contatoRepository.existsById(contatoId)) {
            throw new ContatoException("Contato com ID " + contatoId + " não encontrado para exclusão.");
        }
        contatoRepository.deleteById(contatoId);
    }
}
