package com.example.painelatualizacaoesacademicas.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity(name = "announcement")
@Table(name = "announcement")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private OffsetDateTime dataPostagem;
    private String remetente;
    private String assunto;
    private String corpoTexto;
    private String contato;
    private String numeroReferencia;
    private OffsetDateTime dataValidade;
}
