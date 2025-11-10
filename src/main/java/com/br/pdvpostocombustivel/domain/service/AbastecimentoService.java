package com.br.pdvpostocombustivel.domain.service;

import com.br.pdvpostocombustivel.domain.entity.Abastecimento;
import org.springframework.stereotype.Service;

@Service
public class AbastecimentoService {

    /**
     * Salva uma nova transação de abastecimento.
     *
     * @param abastecimento O objeto Abastecimento preenchido com os dados da venda.
     * @return true se a operação for bem-sucedida, false caso contrário.
     */
    public boolean salvarAbastecimento(Abastecimento abastecimento) {
        System.out.println("SERVICE: Recebida solicitação para salvar abastecimento.");

        // Validações de regra de negócio podem ser adicionadas aqui.
        // Ex: if (abastecimento.getValorTotal() <= 0) { return false; }

        // Lógica DAO para inserir Abastecimento no banco de dados aqui...
        System.out.println("DAO SIMULADO: Persistindo dados...");
        System.out.println("  -> Combustível: " + abastecimento.getNomeCombustivel());
        System.out.println("  -> Valor Total: " + abastecimento.getValorTotal());
        System.out.println("  -> Data/Hora: " + abastecimento.getDataHora());
        System.out.println("  -> Pagamento: " + abastecimento.getFormaPagamento());

        // Simula o sucesso da gravação no banco de dados.
        return true;
    }
}
