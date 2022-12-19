package com.ascode.events.dtos;

import com.ascode.events.enums.UnidadeFederacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link com.ascode.events.entities.EstabelecimentoEntity} entity
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class EstabelecimentoDto implements Serializable {
    private UUID id;
    private String nome;
    private String telefone;
    private String latitude;
    private String longitude;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String urlDaImagemDeExibicao;
    private UnidadeFederacao estado;
}