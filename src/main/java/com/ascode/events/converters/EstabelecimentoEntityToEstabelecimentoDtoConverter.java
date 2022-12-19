package com.ascode.events.converters;

import com.ascode.events.dtos.EstabelecimentoDto;
import com.ascode.events.entities.EstabelecimentoEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class EstabelecimentoEntityToEstabelecimentoDtoConverter extends AbstractConverter<EstabelecimentoEntity, EstabelecimentoDto> {

    @Override
    protected EstabelecimentoDto convert(EstabelecimentoEntity estabelecimentoEntity) {

        if (Objects.isNull(estabelecimentoEntity)) {
            throw new IllegalArgumentException("source cannot be null");
        }

        return EstabelecimentoDto.builder()
                .id(estabelecimentoEntity.getId())
                .cep(estabelecimentoEntity.getCep())
                .nome(estabelecimentoEntity.getNome())
                .longitude(estabelecimentoEntity.getLongitude())
                .latitude(estabelecimentoEntity.getLatitude())
                .bairro(estabelecimentoEntity.getBairro())
                .telefone(estabelecimentoEntity.getTelefone())
                .urlDaImagemDeExibicao(estabelecimentoEntity.getUrlDaImagemDeExibicao())
                .cidade(estabelecimentoEntity.getCidade())
                .logradouro(estabelecimentoEntity.getLogradouro())
                .estado(estabelecimentoEntity.getEstado())
                .build();
    }
}
