package com.ascode.events.controllers;

import com.ascode.events.dtos.EstabelecimentoDto;
import com.ascode.events.services.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    @GetMapping
    public ResponseEntity<Page<EstabelecimentoDto>> findAll(Pageable pageable){

        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<EstabelecimentoDto> create(@RequestBody EstabelecimentoDto estabelecimentoDto){

        return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoService.save(estabelecimentoDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstabelecimentoDto> update(
            @PathVariable UUID id,
            @RequestBody EstabelecimentoDto estabelecimentoDto){

        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoService.update(estabelecimentoDto,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){

        return ResponseEntity.status(HttpStatus.OK).body(estabelecimentoService.delete(id));


    }
}
