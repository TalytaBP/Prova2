package br.com.fiap.Prova2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BrinquedoRecordDto(@NotBlank String nome, @NotBlank String tipo, @NotNull int classificacao, @NotNull double tamanho, @NotNull double preco) {
}
