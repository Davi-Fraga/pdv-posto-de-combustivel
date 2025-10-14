package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.entity.Preco;
import com.br.pdvpostocombustivel.domain.repository.EstoqueRepository;
import com.br.pdvpostocombustivel.domain.repository.PrecoRepository;
import com.br.pdvpostocombustivel.exception.EstoqueException;
import com.br.pdvpostocombustivel.exception.PrecoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrecoService {

    private final PrecoRepository precoRepository;
    private final EstoqueRepository estoqueRepository;

    public PrecoService(PrecoRepository precoRepository, EstoqueRepository estoqueRepository) {
        this.precoRepository = precoRepository;
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional(readOnly = true)
    public List<Preco> findAllByEstoque(Long estoqueId) {
        if (!estoqueRepository.existsById(estoqueId)) {
            throw new EstoqueException("Item de estoque com ID " + estoqueId + " não encontrado.");
        }
        return precoRepository.findByEstoqueId(estoqueId);
    }

    @Transactional(readOnly = true)
    public Preco findById(Long precoId) {
        return precoRepository.findById(precoId)
                .orElseThrow(() -> new PrecoException("Preço com ID " + precoId + " não encontrado."));
    }

    @Transactional
    public Preco save(Long estoqueId, Preco preco) {
        Estoque estoque = estoqueRepository.findById(estoqueId)
                .orElseThrow(() -> new EstoqueException("Não é possível adicionar preço a um item de estoque inexistente. ID: " + estoqueId));
        preco.setEstoque(estoque);
        return precoRepository.save(preco);
    }

    @Transactional
    public Preco update(Long precoId, Preco precoAtualizado) {
        Preco precoExistente = findById(precoId);

        precoExistente.setValor(precoAtualizado.getValor());
        precoExistente.setDataVigencia(precoAtualizado.getDataVigencia());
        precoExistente.setTipoPreco(precoAtualizado.getTipoPreco());
        // O item de estoque associado não deve ser alterado em uma atualização de preço.

        return precoRepository.save(precoExistente);
    }

    @Transactional
    public void delete(Long precoId) {
        if (!precoRepository.existsById(precoId)) {
            throw new PrecoException("Preço com ID " + precoId + " não encontrado para exclusão.");
        }
        precoRepository.deleteById(precoId);
    }
}
