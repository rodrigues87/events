package com.ascode.events.converters;

import com.ascode.events.dtos.StablishmentDto;
import com.ascode.events.entities.StablishmentEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class EstabelecimentoDtoToEstabelecimentoEntityConverter extends AbstractConverter<StablishmentDto, StablishmentEntity> {

    @Override
    protected StablishmentEntity convert(StablishmentDto stablishmentDto) {

        if (Objects.isNull(stablishmentDto)) {
            throw new IllegalArgumentException("source cannot be null");
        }

        return StablishmentEntity.builder()
                .stablishmentId(stablishmentDto.getId())
                .cep(stablishmentDto.getCep())
                .nome(stablishmentDto.getNome())
                .longitude(stablishmentDto.getLongitude())
                .latitude(stablishmentDto.getLatitude())
                .bairro(stablishmentDto.getBairro())
                .telefone(stablishmentDto.getTelefone())
                .urlDaImagemDeExibicao(stablishmentDto.getUrlDaImagemDeExibicao())
                .cidade(stablishmentDto.getCidade())
                .logradouro(stablishmentDto.getLogradouro())
                .estado(stablishmentDto.getEstado())
                .build();
    }
}
