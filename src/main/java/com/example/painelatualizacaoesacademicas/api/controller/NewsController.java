package com.example.painelatualizacaoesacademicas.api.controller;

import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroNews;
import com.example.painelatualizacaoesacademicas.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<DadosCadastroNews>> get() {
        try {
            List<DadosCadastroNews> allNews = newsService.findAll();

            if (allNews.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(allNews);
        }
             catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosCadastroNews> getById(@PathVariable Long id) {
        try {
            DadosCadastroNews news = newsService.findById(id);

            if(news == null) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(news);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
     }

    @PostMapping("/create")
    public ResponseEntity<DadosCadastroNews> create(@RequestBody News news) {
        try {

            DadosCadastroNews createdNews = newsService.create(news);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdNews);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
