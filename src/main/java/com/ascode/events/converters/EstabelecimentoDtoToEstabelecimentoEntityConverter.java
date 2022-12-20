package com.ascode.events.converters;

import com.ascode.events.dtos.EstabelecimentoDto;
import com.ascode.events.entities.EstabelecimentoEntity;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class EstabelecimentoDtoToEstabelecimentoEntityConverter extends AbstractConverter<EstabelecimentoDto, EstabelecimentoEntity> {

    @Override
    protected EstabelecimentoEntity convert(EstabelecimentoDto estabelecimentoDto) {

        if (Objects.isNull(estabelecimentoDto)) {
            throw new IllegalArgumentException("source cannot be null");
        }

        return EstabelecimentoEntity.builder()
                .id(estabelecimentoDto.getId())
                .cep(estabelecimentoDto.getCep())
                .nome(estabelecimentoDto.getNome())
                .longitude(estabelecimentoDto.getLongitude())
                .latitude(estabelecimentoDto.getLatitude())
                .bairro(estabelecimentoDto.getBairro())
                .telefone(estabelecimentoDto.getTelefone())
                .urlDaImagemDeExibicao(estabelecimentoDto.getUrlDaImagemDeExibicao())
                .cidade(estabelecimentoDto.getCidade())
                .logradouro(estabelecimentoDto.getLogradouro())
                .estado(estabelecimentoDto.getEstado())
                .build();
    }
}
