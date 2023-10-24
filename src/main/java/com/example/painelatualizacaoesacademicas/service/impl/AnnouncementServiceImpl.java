package com.example.painelatualizacaoesacademicas.service.impl;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.Announcement;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroComunicado;
import com.example.painelatualizacaoesacademicas.exception.AcademicEventNotFoundException;
import com.example.painelatualizacaoesacademicas.exception.AnnouncementNotFoundException;
import com.example.painelatualizacaoesacademicas.mapper.AcademicEventMapper;
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
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<DadosCadastroComunicado> findAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcements.stream()
                .map(AnnouncementMapper.MAPPER::mapToDadosCadastroComunicado)
                .toList();
    }

    @Override
    public DadosCadastroComunicado findAnnouncentById(Long id)  {
        Optional<Announcement> optionalAnnouncement = announcementRepository.findById(id);

        if (optionalAnnouncement.isPresent()) {
            return AnnouncementMapper.MAPPER.mapToDadosCadastroComunicado(optionalAnnouncement.get());
        } else {
            throw new AnnouncementNotFoundException("Comunicado com ID " + id + " não encontrado.");
        }
    }
}
