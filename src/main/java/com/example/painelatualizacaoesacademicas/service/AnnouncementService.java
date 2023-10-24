package com.example.painelatualizacaoesacademicas.service;

import com.example.painelatualizacaoesacademicas.entity.Announcement;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroComunicado;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AnnouncementService {
    DadosCadastroComunicado createNewannoucement(DadosCadastroComunicado comunicado);

    List<DadosCadastroComunicado> findAllAnnouncements();

    DadosCadastroComunicado findAnnouncentById(Long id);
}
