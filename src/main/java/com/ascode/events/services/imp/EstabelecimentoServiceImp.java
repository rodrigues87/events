package com.ascode.events.services.imp;

import com.ascode.events.dtos.StablishmentDto;
import com.ascode.events.entities.StablishmentEntity;
import com.ascode.events.exceptions.EstabelecimentoNotFoundException;
import com.ascode.events.repositories.EstabelecimentoRepository;
import com.ascode.events.services.EstabelecimentoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EstabelecimentoServiceImp implements EstabelecimentoService {
    private final EstabelecimentoRepository estabelecimentoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EstabelecimentoServiceImp(EstabelecimentoRepository estabelecimentoRepository) {
        this.estabelecimentoRepository = estabelecimentoRepository;
    }

    @Override
    public Page<StablishmentDto> findAll(Pageable pageable) {

        Page<StablishmentEntity> estabelecimentoEntityPage = estabelecimentoRepository.findAll(pageable);

        List<StablishmentDto> stablishmentDtos = estabelecimentoEntityPage.stream().map(estabelecimentoEntity ->
                modelMapper.map(estabelecimentoEntity, StablishmentDto.class)).collect(Collectors.toList());

        return new PageImpl<>(stablishmentDtos, pageable, stablishmentDtos.size());
    }

    @Override
    public StablishmentDto save(StablishmentDto stablishmentDto) {

        StablishmentEntity stablishmentEntity = modelMapper.map(stablishmentDto, StablishmentEntity.class);

        stablishmentEntity = estabelecimentoRepository.save(stablishmentEntity);

        return modelMapper.map(stablishmentEntity, StablishmentDto.class);
    }

    @Override
    public StablishmentDto update(StablishmentDto stablishmentDto, UUID uuid) {

        existsById(uuid);

        StablishmentEntity stablishmentEntity = modelMapper.map(stablishmentDto, StablishmentEntity.class);

        estabelecimentoRepository.save(stablishmentEntity);

        return modelMapper.map(stablishmentEntity, StablishmentDto.class);
    }

    @Override
    public String delete(UUID id) {

        existsById(id);

        estabelecimentoRepository.deleteById(id);

        return "Estabelecimento id: " +id+ " deletado";
    }

    public void existsById(UUID id) {
        if(!estabelecimentoRepository.existsById(id)){
            throw new EstabelecimentoNotFoundException(id);
        }
    }
}
