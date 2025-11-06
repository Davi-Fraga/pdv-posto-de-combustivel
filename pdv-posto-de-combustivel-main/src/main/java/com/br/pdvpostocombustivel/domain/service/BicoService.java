package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Bico;
import com.br.pdvpostocombustivel.domain.entity.Produto;
import com.br.pdvpostocombustivel.domain.repository.BicoRepository;
import com.br.pdvpostocombustivel.exception.BicoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("bicoDomainService")
public class BicoService {

    private final BicoRepository bicoRepository;
    private final ProdutoService produtoService;

    public BicoService(BicoRepository bicoRepository, ProdutoService produtoService) {
        this.bicoRepository = bicoRepository;
        this.produtoService = produtoService;
    }

    @Transactional(readOnly = true)
    public List<Bico> findAll() {
        return bicoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Bico findById(Long id) {
        return bicoRepository.findById(id)
                .orElseThrow(() -> new BicoException("Bico com ID " + id + " não encontrado."));
    }

    @Transactional
    public Bico save(Bico bico, Long produtoId) {
        bicoRepository.findByNome(bico.getNome()).ifPresent(b -> {
            throw new BicoException("Já existe um bico com o nome: " + bico.getNome());
        });
        Produto produto = produtoService.findById(produtoId);
        bico.setProduto(produto);
        return bicoRepository.save(bico);
    }

    @Transactional
    public Bico update(Long id, Bico bicoAtualizado, Long produtoId) {
        Bico bicoExistente = findById(id);

        bicoRepository.findByNome(bicoAtualizado.getNome()).ifPresent(b -> {
            if (!b.getId().equals(id)) {
                throw new BicoException("O nome " + bicoAtualizado.getNome() + " já está em uso por outro bico.");
            }
        });

        Produto produto = produtoService.findById(produtoId);
        bicoExistente.setNome(bicoAtualizado.getNome());
        bicoExistente.setStatus(bicoAtualizado.getStatus());
        bicoExistente.setProduto(produto);
        return bicoRepository.save(bicoExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!bicoRepository.existsById(id)) {
            throw new BicoException("Bico com ID " + id + " não encontrado para exclusão.");
        }
        bicoRepository.deleteById(id);
    }
}