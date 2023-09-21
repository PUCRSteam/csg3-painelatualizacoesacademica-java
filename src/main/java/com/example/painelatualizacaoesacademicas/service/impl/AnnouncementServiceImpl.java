package com.example.painelatualizacaoesacademicas.service.impl;

import com.example.painelatualizacaoesacademicas.entity.Announcement;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroComunicado;
import com.example.painelatualizacaoesacademicas.mapper.AnnouncementMapper;
import com.example.painelatualizacaoesacademicas.repository.AnnouncementRepository;
import com.example.painelatualizacaoesacademicas.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Base64;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {

    private final AnnouncementRepository announcementRepository;

    @Override
    public DadosCadastroComunicado createNewannoucement(DadosCadastroComunicado comunicado) {
        // Validação das datas, se necessário
        OffsetDateTime data = comunicado.dataPostagem();
        OffsetDateTime dataValidade = comunicado.dataValidade();

        if (data.isAfter(dataValidade)) {
            // A data não pode ser depois da data de validade, se aplicável
            throw new IllegalArgumentException("A data não pode ser após a data de validade.");
        }

        Announcement announcement = AnnouncementMapper.MAPPER.mapToAnnouncement(comunicado);

        // Aqui você pode adicionar lógica adicional, como validações, antes de salvar no repositório.

        Announcement savedAnnouncement = announcementRepository.save(announcement);

        // Mapeia o Announcement salvo de volta para DadosCadastroComunicado
        return AnnouncementMapper.MAPPER.mapToDadosCadastroComunicado(savedAnnouncement);
    }
}
