package com.example.painelatualizacaoesacademicas.entity.record;

import com.example.painelatualizacaoesacademicas.entity.EventType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosCadastroAcademicEvent(
        @NotBlank
        String nome,
        @NotNull
        LocalDate dataInicio,
        @NotNull
        LocalDate dataFim,
        @NotNull
        EventType eventType,
        @NotBlank
        String local) {
}
