package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Acesso;
import com.br.pdvpostocombustivel.domain.repository.AcessoRepository;
import com.br.pdvpostocombustivel.exception.AcessoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AcessoService {

    private final AcessoRepository acessoRepository;

    public AcessoService(AcessoRepository acessoRepository) {
        this.acessoRepository = acessoRepository;
    }

    @Transactional(readOnly = true)
    public List<Acesso> findAll() {
        return acessoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Acesso findById(Long id) {
        return acessoRepository.findById(id)
                .orElseThrow(() -> new AcessoException("Acesso com ID " + id + " não encontrado."));
    }

    @Transactional
    public Acesso save(Acesso acesso) {
        if (acessoRepository.existsByUsuario(acesso.getUsuario())) {
            throw new AcessoException("Nome de usuário já existe: " + acesso.getUsuario());
        }
        return acessoRepository.save(acesso);
    }

    @Transactional
    public Acesso update(Long id, Acesso acessoAtualizado) {
        Acesso acessoExistente = findById(id);

        acessoRepository.findByUsuario(acessoAtualizado.getUsuario()).ifPresent(acesso -> {
            if (!acesso.getId().equals(id)) {
                throw new AcessoException("O nome de usuário " + acessoAtualizado.getUsuario() + " já está em uso.");
            }
        });

        acessoExistente.setUsuario(acessoAtualizado.getUsuario());
        acessoExistente.setSenha(acessoAtualizado.getSenha());
        acessoExistente.setTipoAcesso(acessoAtualizado.getTipoAcesso());

        return acessoRepository.save(acessoExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!acessoRepository.existsById(id)) {
            throw new AcessoException("Acesso com ID " + id + " não encontrado para exclusão.");
        }
        acessoRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Acesso login(String usuario, String senha) {
        Acesso acesso = acessoRepository.findByUsuario(usuario)
                .orElseThrow(() -> new AcessoException("Usuário ou senha inválidos."));

        if (!acesso.getSenha().equals(senha)) {
            throw new AcessoException("Usuário ou senha inválidos.");
        }

        return acesso;
    }
}
