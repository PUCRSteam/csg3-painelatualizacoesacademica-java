package com.example.painelatualizacaoesacademicas.service.impl;


import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.exception.AcademicEventNotFoundException;
import com.example.painelatualizacaoesacademicas.mapper.AcademicEventMapper;
import com.example.painelatualizacaoesacademicas.mapper.NewsMapper;
import com.example.painelatualizacaoesacademicas.repository.NewsRepository;
import com.example.painelatualizacaoesacademicas.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        List<News> allAcademicEvent = newsRepository.findAll();
        return allAcademicEvent.stream()
                .map(NewsMapper.MAPPER::mapToNews)
                .toList();
    }

    @Override
    public News find(Long id) {
        Optional<News> news = newsRepository.findById(id);

        if(news.isPresent()) {
            return NewsMapper.MAPPER.mapToNews(news.get());
        } else {
            throw new AcademicEventNotFoundException("Notícia com ID " + id + " não foi encontrada.");
        }

    }
}
