package com.ascode.events.services.imp;

import com.ascode.events.dtos.EstabelecimentoDto;
import com.ascode.events.entities.EstabelecimentoEntity;
import com.ascode.events.repositories.EstabelecimentoEntityRepository;
import com.ascode.events.services.EstabelecimentoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EstabelecimentoServiceImp implements EstabelecimentoService {
    private final EstabelecimentoEntityRepository estabelecimentoEntityRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EstabelecimentoServiceImp(EstabelecimentoEntityRepository estabelecimentoEntityRepository) {
        this.estabelecimentoEntityRepository = estabelecimentoEntityRepository;
    }

    @Override
    public Page<EstabelecimentoDto> findAll(Pageable pageable) {

        Page<EstabelecimentoEntity> estabelecimentoEntityPage = estabelecimentoEntityRepository.findAll(pageable);

        List<EstabelecimentoDto> estabelecimentoDtos = estabelecimentoEntityPage.stream().map(estabelecimentoEntity ->
                modelMapper.map(estabelecimentoEntity, EstabelecimentoDto.class)).toList();

        return new PageImpl<>(estabelecimentoDtos, pageable, estabelecimentoDtos.size());
    }
}
