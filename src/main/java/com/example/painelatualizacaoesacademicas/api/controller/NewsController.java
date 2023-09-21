package com.example.painelatualizacaoesacademicas.api.controller;

import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/news")
@RequiredArgsConstructor
public class NewsController {
    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<List<News>> get() {
        try {
            List<News> allNews = newsService.findAll();

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
    public ResponseEntity<News> getById(@PathVariable Long id) {
        try {
            News news = newsService.find(id);

            if(news == null) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(news);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
     }
}
