package com.orcamento.academico.rest.dto.UnidadeOrcamentaria;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnidadeOrcamentariaDto {
    private Integer id;
    private Integer codigo;
    private String nome;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAlteracao;
}
