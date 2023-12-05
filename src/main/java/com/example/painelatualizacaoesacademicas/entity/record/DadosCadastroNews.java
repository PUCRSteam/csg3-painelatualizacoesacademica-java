package com.example.painelatualizacaoesacademicas.entity.record;

import com.example.painelatualizacaoesacademicas.entity.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroNews(
        @NotBlank
        String titulo,
        @NotNull
        LocalDate conteudo,
        @NotNull
        LocalDate dataPublicacao,
        @NotNull
        EventType autor) {
}
