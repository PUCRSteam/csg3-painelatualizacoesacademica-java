package com.example.painelatualizacaoesacademicas.api.controller;

import com.example.painelatualizacaoesacademicas.entity.Announcement;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroComunicado;
import com.example.painelatualizacaoesacademicas.service.AnnouncementService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

}
