package com.ascode.events.controllers;

import com.ascode.events.dtos.EstabelecimentoDto;
import com.ascode.events.services.EstabelecimentoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
