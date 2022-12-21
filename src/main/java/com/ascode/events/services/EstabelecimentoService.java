package com.ascode.events.services;

import com.ascode.events.dtos.StablishmentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface EstabelecimentoService {
    Page<StablishmentDto> findAll(Pageable pageable);

    StablishmentDto save(StablishmentDto stablishmentDto);

    StablishmentDto update(StablishmentDto stablishmentDto, UUID uuid);

    String delete(UUID id);
}
