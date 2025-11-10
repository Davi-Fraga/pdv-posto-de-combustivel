package com.br.pdvpostocombustivel.api.perfilacesso;

import com.br.pdvpostocombustivel.api.perfilacesso.dto.PerfilAcessoResponse;
import com.br.pdvpostocombustivel.domain.entity.PerfilAcesso;
import com.br.pdvpostocombustivel.domain.repository.PerfilAcessoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PerfilAcessoServiceImpl implements PerfilAcessoService {

    private final PerfilAcessoRepository perfilAcessoRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<PerfilAcessoResponse> findAll() {
        List<PerfilAcesso> perfis = perfilAcessoRepository.findAll();
        return perfis.stream()
                .map(perfil -> modelMapper.map(perfil, PerfilAcessoResponse.class))
                .collect(Collectors.toList());
    }
}
