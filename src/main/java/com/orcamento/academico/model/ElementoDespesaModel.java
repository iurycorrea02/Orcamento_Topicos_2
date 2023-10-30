package com.orcamento.academico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name="elementoDespesa")
public class ElementoDespesaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo", length = 100, nullable = false)
    private Integer codigo;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "dataCadastro", nullable = false)
    private LocalDate dataCadastro;

    @Column(name = "dataAlteracao")
    private LocalDate dataAlteracao;
}