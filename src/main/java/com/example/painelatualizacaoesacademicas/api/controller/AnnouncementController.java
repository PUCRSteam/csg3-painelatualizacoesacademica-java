package com.example.painelatualizacaoesacademicas.api.controller;

import com.example.painelatualizacaoesacademicas.entity.Announcement;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroAcademicEvent;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroComunicado;
import com.example.painelatualizacaoesacademicas.service.AnnouncementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/annoucements")
@RequiredArgsConstructor
public class AnnouncementController {
private final AnnouncementService announcementService;

    @PostMapping
    public ResponseEntity<DadosCadastroComunicado> createNewannoucement(@Valid @RequestBody DadosCadastroComunicado comunicado) {
        DadosCadastroComunicado anno = announcementService.createNewannoucement(comunicado);
        return ResponseEntity.status(HttpStatus.CREATED).body(anno);
    }

    @GetMapping
    public ResponseEntity<List<DadosCadastroComunicado>> findAllAnnouncements() {
        try {
            List<DadosCadastroComunicado> comunicados = announcementService.findAllAnnouncements();

            if (comunicados.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(comunicados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosCadastroComunicado> findById(@PathVariable Long id) {
        try {
            DadosCadastroComunicado announcement = announcementService.findAnnouncentById(id);

            if (announcement == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(announcement);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
