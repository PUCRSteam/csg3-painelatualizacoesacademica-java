package com.example.painelatualizacaoesacademicas.mapper;

import com.example.painelatualizacaoesacademicas.entity.Announcement;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroComunicado;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AnnouncementMapper {
    AnnouncementMapper MAPPER = Mappers.getMapper(AnnouncementMapper.class);

    DadosCadastroComunicado mapToDadosCadastroComunicado (Announcement announcement);

    Announcement mapToAnnouncement(DadosCadastroComunicado dadosCadastroComunicado);
}