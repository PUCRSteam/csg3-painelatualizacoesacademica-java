package com.example.painelatualizacaoesacademicas.service.impl;


import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.mapper.AcademicEventMapper;
import com.example.painelatualizacaoesacademicas.mapper.NewsMapper;
import com.example.painelatualizacaoesacademicas.repository.NewsRepository;
import com.example.painelatualizacaoesacademicas.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
