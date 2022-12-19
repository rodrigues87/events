package com.ascode.events.entities;

import com.ascode.events.enums.UnidadeFederacao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name = "ESTABELECIMENTO")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EstabelecimentoEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected UUID id;

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
