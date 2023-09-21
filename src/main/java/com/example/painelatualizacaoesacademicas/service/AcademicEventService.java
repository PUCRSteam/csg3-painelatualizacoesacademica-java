package com.example.painelatualizacaoesacademicas.service;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import jakarta.transaction.Transactional;

import java.util.List;

public interface AcademicEventService {


    @Transactional
    DadosCadastroAcademicEvent saveNewAcademicEvent(DadosCadastroAcademicEvent cadastroAcademicEvent);

    List<DadosCadastroAcademicEvent> findAllAcademicEvents();

    DadosCadastroAcademicEvent findAcademicEventById(Long id);
}
