package com.ascode.events.services;

import com.ascode.events.dtos.EstabelecimentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EstabelecimentoService {
    Page<EstabelecimentoDto> findAll(Pageable pageable);

    EstabelecimentoDto save(EstabelecimentoDto estabelecimentoDto);

    EstabelecimentoDto update(EstabelecimentoDto estabelecimentoDto, UUID uuid);

    String delete(UUID id);
}
