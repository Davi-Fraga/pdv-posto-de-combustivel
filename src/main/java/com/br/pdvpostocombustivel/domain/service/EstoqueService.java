package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Estoque;
import com.br.pdvpostocombustivel.domain.repository.EstoqueRepository;
import com.br.pdvpostocombustivel.exception.EstoqueException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueService(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Transactional(readOnly = true)
    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Estoque findById(Long id) {
        return estoqueRepository.findById(id)
                .orElseThrow(() -> new EstoqueException("Item de estoque com ID " + id + " não encontrado."));
    }

    @Transactional
    public Estoque save(Estoque estoque) {
        // Validações de negócio podem ser adicionadas aqui, se necessário.
        return estoqueRepository.save(estoque);
    }

    @Transactional
    public Estoque update(Long id, Estoque estoqueAtualizado) {
        Estoque estoqueExistente = findById(id);

        estoqueExistente.setTipoEstoque(estoqueAtualizado.getTipoEstoque());
        estoqueExistente.setNomeProduto(estoqueAtualizado.getNomeProduto());
        estoqueExistente.setQuantidade(estoqueAtualizado.getQuantidade());
        estoqueExistente.setFornecedor(estoqueAtualizado.getFornecedor());
        estoqueExistente.setDataEntrada(estoqueAtualizado.getDataEntrada());

        return estoqueRepository.save(estoqueExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!estoqueRepository.existsById(id)) {
            throw new EstoqueException("Item de estoque com ID " + id + " não encontrado para exclusão.");
        }
        estoqueRepository.deleteById(id);
    }
}
