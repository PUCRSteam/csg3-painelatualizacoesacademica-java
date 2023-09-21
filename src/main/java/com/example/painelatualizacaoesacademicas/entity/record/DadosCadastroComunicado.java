package com.example.painelatualizacaoesacademicas.entity.record;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.OffsetDateTime;

public record DadosCadastroComunicado(

        @NotBlank(message = "O título não pode estar em branco")
        @Size(min = 3, message = "O título deve ter pelo menos 3 caracteres")
        String titulo,

        @NotNull(message = "A data não pode ser nula")
        OffsetDateTime dataPostagem,

        @NotBlank(message = "O remetente não pode estar em branco")
        @Size(min = 3, message = "O remetente deve ter pelo menos 3 caracteres")
        String remetente,

        @NotBlank(message = "O assunto não pode estar em branco")
        @Size(min = 5, message = "O assunto deve ter pelo menos 5 caracteres")
        String assunto,

        @NotBlank(message = "O corpo do texto não pode estar em branco")
        @Size(min = 30, message = "O corpo do texto deve ter pelo menos 10 caracteres")
        String corpoTexto,

        @NotBlank(message = "As informações de contato não podem estar em branco")
        @Size(min = 5, message = "As informações de contato devem ter pelo menos 5 caracteres")
        String contato,

        @NotBlank(message = "O número de referência não pode estar em branco")
        @Size(min = 3, message = "O número de referência deve ter pelo menos 3 caracteres")
        String numeroReferencia,

        @NotNull(message = "A data de validade não pode ser nula")
        OffsetDateTime dataValidade
) {
}
