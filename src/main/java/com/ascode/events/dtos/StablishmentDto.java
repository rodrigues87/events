package com.ascode.events.dtos;

import com.ascode.events.entities.StablishmentEntity;
import com.ascode.events.enums.UnidadeFederacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link StablishmentEntity} entity
 */
@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StablishmentDto implements Serializable {
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