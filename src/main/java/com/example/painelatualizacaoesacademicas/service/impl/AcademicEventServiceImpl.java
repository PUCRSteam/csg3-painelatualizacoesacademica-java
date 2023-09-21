package com.example.painelatualizacaoesacademicas.service.impl;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import com.example.painelatualizacaoesacademicas.exception.AcademicEventNotFoundException;
import com.example.painelatualizacaoesacademicas.mapper.AcademicEventMapper;
import com.example.painelatualizacaoesacademicas.repository.AcademicEventRepository;
import com.example.painelatualizacaoesacademicas.service.AcademicEventService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AcademicEventServiceImpl implements AcademicEventService {

    private final AcademicEventRepository eventRepository;

    @Override
    public DadosCadastroAcademicEvent saveNewAcademicEvent(DadosCadastroAcademicEvent cadastroAcademicEvent) {
        // Validação das datas
        LocalDate dataInicio = cadastroAcademicEvent.dataInicio();
        LocalDate dataFim = cadastroAcademicEvent.dataFim();

        if (dataInicio.isAfter(dataFim)) {
            // A data de início não pode ser depois da data de término
            throw new IllegalArgumentException("A data de início não pode ser após a data de término.");
        }

        AcademicEvent academicEvent = AcademicEventMapper.MAPPER.mapToAcademicEvent(cadastroAcademicEvent);

        AcademicEvent savedEvent = eventRepository.save(academicEvent);

        return AcademicEventMapper.MAPPER.mapToDadosCadastroAcademicEvent(savedEvent);
    }

    @Override
    public List<DadosCadastroAcademicEvent> findAllAcademicEvents() {
        List<AcademicEvent> allAcademicEvent = eventRepository.findAll();
        return allAcademicEvent.stream()
                .map(AcademicEventMapper.MAPPER::mapToDadosCadastroAcademicEvent)
                .toList();
    }

    @Override
    public DadosCadastroAcademicEvent findAcademicEventById(Long id) {
        Optional<AcademicEvent> optionalEvent = eventRepository.findById(id);

        if (optionalEvent.isPresent()) {
            return AcademicEventMapper.MAPPER.mapToDadosCadastroAcademicEvent(optionalEvent.get());
        } else {
            throw new AcademicEventNotFoundException("Evento acadêmico com ID " + id + " não encontrado.");
        }
    }
}
