package com.ascode.events.services;

import com.ascode.events.dtos.EstabelecimentoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EstabelecimentoService {
    Page<EstabelecimentoDto> findAll(Pageable pageable);
}
