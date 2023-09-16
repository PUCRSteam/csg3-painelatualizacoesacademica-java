package com.example.painelatualizacaoesacademicas.service.impl;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import com.example.painelatualizacaoesacademicas.repository.AcademicEventRepository;
import com.example.painelatualizacaoesacademicas.service.AcademicEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AcademicEventServiceImpl implements AcademicEventService {

 private final AcademicEventRepository eventRepository;
    @Override
    public AcademicEvent criarEvento(AcademicEvent evento) {
        return eventRepository.save(evento);
    }
}
