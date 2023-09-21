package com.example.painelatualizacaoesacademicas.mapper;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AcademicEventMapper {
    AcademicEventMapper MAPPER = Mappers.getMapper(AcademicEventMapper.class);

    DadosCadastroAcademicEvent mapToDadosCadastroAcademicEvent(AcademicEvent academicEvent);

    AcademicEvent mapToAcademicEvent(DadosCadastroAcademicEvent cadastroAcademicEvent);
}

