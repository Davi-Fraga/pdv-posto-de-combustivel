package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Produto;
import com.br.pdvpostocombustivel.domain.repository.ProdutoRepository;
import com.br.pdvpostocombustivel.exception.ProdutoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Produto findById(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoException("Produto com ID " + id + " não encontrado."));
    }

    @Transactional
    public Produto save(Produto produto) {
        if (produtoRepository.existsByCodigoBarras(produto.getCodigoBarras())) {
            throw new ProdutoException("Já existe um produto cadastrado com o código de barras: " + produto.getCodigoBarras());
        }
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto update(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = findById(id);

        produtoRepository.findByCodigoBarras(produtoAtualizado.getCodigoBarras()).ifPresent(produto -> {
            if (!produto.getId().equals(id)) {
                throw new ProdutoException("O código de barras " + produtoAtualizado.getCodigoBarras() + " já está em uso por outro produto.");
            }
        });

        produtoExistente.setNome(produtoAtualizado.getNome());
        produtoExistente.setDescricao(produtoAtualizado.getDescricao());
        produtoExistente.setCodigoBarras(produtoAtualizado.getCodigoBarras());
        produtoExistente.setValorUnitario(produtoAtualizado.getValorUnitario());
        produtoExistente.setTipoProduto(produtoAtualizado.getTipoProduto());

        return produtoRepository.save(produtoExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!produtoRepository.existsById(id)) {
            throw new ProdutoException("Produto com ID " + id + " não encontrado para exclusão.");
        }
        produtoRepository.deleteById(id);
    }
}
