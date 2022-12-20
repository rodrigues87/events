package com.ascode.events.services.imp;

import com.ascode.events.dtos.EstabelecimentoDto;
import com.ascode.events.entities.EstabelecimentoEntity;
import com.ascode.events.exceptions.EstabelecimentoNotFoundException;
import com.ascode.events.exceptions.NotFoundException;
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
    public Page<EstabelecimentoDto> findAll(Pageable pageable) {

        Page<EstabelecimentoEntity> estabelecimentoEntityPage = estabelecimentoRepository.findAll(pageable);

        List<EstabelecimentoDto> estabelecimentoDtos = estabelecimentoEntityPage.stream().map(estabelecimentoEntity ->
                modelMapper.map(estabelecimentoEntity, EstabelecimentoDto.class)).collect(Collectors.toList());

        return new PageImpl<>(estabelecimentoDtos, pageable, estabelecimentoDtos.size());
    }

    @Override
    public EstabelecimentoDto save(EstabelecimentoDto estabelecimentoDto) {

        EstabelecimentoEntity estabelecimentoEntity = modelMapper.map(estabelecimentoDto, EstabelecimentoEntity.class);

        estabelecimentoEntity = estabelecimentoRepository.save(estabelecimentoEntity);

        return modelMapper.map(estabelecimentoEntity, EstabelecimentoDto.class);
    }

    @Override
    public EstabelecimentoDto update(EstabelecimentoDto estabelecimentoDto, UUID uuid) {

        existsById(uuid);

        EstabelecimentoEntity estabelecimentoEntity = modelMapper.map(estabelecimentoDto, EstabelecimentoEntity.class);

        estabelecimentoRepository.save(estabelecimentoEntity);

        return modelMapper.map(estabelecimentoEntity, EstabelecimentoDto.class);
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
