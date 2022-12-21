package com.ascode.events.converters;

import com.ascode.events.dtos.StablishmentDto;
import com.ascode.events.entities.StablishmentEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class EstabelecimentoEntityToEstabelecimentoDtoConverter extends AbstractConverter<StablishmentEntity, StablishmentDto> {

    @Override
    protected StablishmentDto convert(StablishmentEntity stablishmentEntity) {

        if (Objects.isNull(stablishmentEntity)) {
            throw new IllegalArgumentException("source cannot be null");
        }

        return StablishmentDto.builder()
                .id(stablishmentEntity.getStablishmentId())
                .cep(stablishmentEntity.getCep())
                .nome(stablishmentEntity.getNome())
                .longitude(stablishmentEntity.getLongitude())
                .latitude(stablishmentEntity.getLatitude())
                .bairro(stablishmentEntity.getBairro())
                .telefone(stablishmentEntity.getTelefone())
                .urlDaImagemDeExibicao(stablishmentEntity.getUrlDaImagemDeExibicao())
                .cidade(stablishmentEntity.getCidade())
                .logradouro(stablishmentEntity.getLogradouro())
                .estado(stablishmentEntity.getEstado())
                .build();
    }
}
