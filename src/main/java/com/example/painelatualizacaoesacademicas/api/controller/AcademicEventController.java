package com.example.painelatualizacaoesacademicas.api.controller;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import com.example.painelatualizacaoesacademicas.service.AcademicEventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/AcademicEvents")
@RequiredArgsConstructor
public class AcademicEventController {

    private final AcademicEventService eventService;


    @PostMapping
    public ResponseEntity<DadosCadastroAcademicEvent> saveNewAcademicEvent(@Valid @RequestBody DadosCadastroAcademicEvent cadastroAcademicEvent) {
        DadosCadastroAcademicEvent saveEvent = eventService.saveNewAcademicEvent(cadastroAcademicEvent);
        return new ResponseEntity<>(saveEvent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DadosCadastroAcademicEvent>> listarEventosAcademicos() {
        try {
            List<DadosCadastroAcademicEvent> eventos = eventService.findAllAcademicEvents();

            if (eventos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(eventos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosCadastroAcademicEvent> findById(@PathVariable Long id) {
        try {
            DadosCadastroAcademicEvent evento = eventService.findAcademicEventById(id);

            if (evento == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(evento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
