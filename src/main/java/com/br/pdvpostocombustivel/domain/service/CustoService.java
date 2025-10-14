package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Custo;
import com.br.pdvpostocombustivel.domain.repository.CustoRepository;
import com.br.pdvpostocombustivel.exception.CustoException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustoService {

    private final CustoRepository custoRepository;

    public CustoService(CustoRepository custoRepository) {
        this.custoRepository = custoRepository;
    }

    @Transactional(readOnly = true)
    public List<Custo> findAll() {
        return custoRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Custo findById(Long id) {
        return custoRepository.findById(id)
                .orElseThrow(() -> new CustoException("Custo com ID " + id + " não encontrado."));
    }

    @Transactional
    public Custo save(Custo custo) {
        // Validações de negócio podem ser adicionadas aqui, se necessário.
        return custoRepository.save(custo);
    }

    @Transactional
    public Custo update(Long id, Custo custoAtualizado) {
        Custo custoExistente = findById(id);

        custoExistente.setDescricao(custoAtualizado.getDescricao());
        custoExistente.setValor(custoAtualizado.getValor());
        custoExistente.setDataVencimento(custoAtualizado.getDataVencimento());
        custoExistente.setTipoCusto(custoAtualizado.getTipoCusto());

        return custoRepository.save(custoExistente);
    }

    @Transactional
    public void delete(Long id) {
        if (!custoRepository.existsById(id)) {
            throw new CustoException("Custo com ID " + id + " não encontrado para exclusão.");
        }
        custoRepository.deleteById(id);
    }
}
