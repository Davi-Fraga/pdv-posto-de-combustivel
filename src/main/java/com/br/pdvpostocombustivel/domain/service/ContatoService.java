package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Contato;
import com.br.pdvpostocombustivel.domain.repository.ContatoRepository;
import com.br.pdvpostocombustivel.exception.ContatoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("contatoService")
public class ContatoService {

    private final ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }

    @Transactional(readOnly = true)
    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Contato findById(Long contatoId) {
        return contatoRepository.findById(contatoId)
                .orElseThrow(() -> new ContatoException("Contato com ID " + contatoId + " não encontrado."));
    }

    @Transactional
    public Contato save(Contato contato) {
        return contatoRepository.save(contato);
    }

    @Transactional
    public Contato update(Long contatoId, Contato contatoAtualizado) {
        Contato contatoExistente = findById(contatoId);

        contatoExistente.setTelefone(contatoAtualizado.getTelefone());
        contatoExistente.setEmail(contatoAtualizado.getEmail());
        contatoExistente.setEndereco(contatoAtualizado.getEndereco());
        contatoExistente.setTipoContato(contatoAtualizado.getTipoContato());

        return contatoRepository.save(contatoExistente);
    }

    @Transactional
    public Contato patch(Long id, Contato contatoAtualizado, Object o) {
        Contato contatoExistente = findById(id);
        if (StringUtils.hasText(contatoAtualizado.getTelefone())) {
            contatoExistente.setTelefone(contatoAtualizado.getTelefone());
        }
        if (StringUtils.hasText(contatoAtualizado.getEmail())) {
            contatoExistente.setEmail(contatoAtualizado.getEmail());
        }
        if (StringUtils.hasText(contatoAtualizado.getEndereco())) {
            contatoExistente.setEndereco(contatoAtualizado.getEndereco());
        }
        if (contatoAtualizado.getTipoContato() != null) {
            contatoExistente.setTipoContato(contatoAtualizado.getTipoContato());
        }
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
