package com.example.painelatualizacaoesacademicas.service.impl;


import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroNews;
import com.example.painelatualizacaoesacademicas.exception.AcademicEventNotFoundException;
import com.example.painelatualizacaoesacademicas.exception.NewsCreationException;
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
    public List<DadosCadastroNews> findAll() {
        List<News> allNews = newsRepository.findAll();
        return allNews.stream()
                .map(NewsMapper.MAPPER::mapToDadosCadastroNews)
                .toList();
    }

    @Override
    public DadosCadastroNews findById(Long id) {
        Optional<News> news = newsRepository.findById(id);

        if(news.isPresent()) {
            return NewsMapper.MAPPER.mapToDadosCadastroNews(news.get());
        } else {
            throw new AcademicEventNotFoundException("Notícia com ID " + id + " não foi encontrada.");
        }

    }

    @Override
    public DadosCadastroNews create(News news) {
        try {
            News createdNews = newsRepository.save(news);
            return NewsMapper.MAPPER.mapToDadosCadastroNews(createdNews);
        } catch (Exception e) {
             throw new NewsCreationException("Erro ao criar a notícia.");
        }
    }
}
