package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Preco;
import com.br.pdvpostocombustivel.domain.repository.PrecoRepository;
import com.br.pdvpostocombustivel.exception.PrecoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PrecoService {

    private final PrecoRepository precoRepository;

    public PrecoService(PrecoRepository precoRepository) {
        this.precoRepository = precoRepository;
    }

    @Transactional(readOnly = true)
    public List<Preco> findAll() {
        return precoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Preco findById(Long id) {
        return precoRepository.findById(id)
                .orElseThrow(() -> new PrecoException("Preço com ID " + id + " não encontrado."));
    }

    @Transactional
    public Preco save(Preco preco) {
        return precoRepository.save(preco);
    }

    @Transactional
    public Preco update(Long id, Preco precoAtualizado) {
        Preco precoExistente = findById(id);

        precoExistente.setDataAlteracao(precoAtualizado.getDataAlteracao());
        precoExistente.setHoraAlteracao(precoAtualizado.getHoraAlteracao());
        precoExistente.setValor(precoAtualizado.getValor());
        precoExistente.setTipoPreco(precoAtualizado.getTipoPreco());

        return precoRepository.save(precoExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!precoRepository.existsById(id)) {
            throw new PrecoException("Preço com ID " + id + " não encontrado para exclusão.");
        }
        precoRepository.deleteById(id);
    }
}
