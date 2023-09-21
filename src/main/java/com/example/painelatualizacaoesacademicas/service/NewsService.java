package com.example.painelatualizacaoesacademicas.service;

import com.example.painelatualizacaoesacademicas.entity.News;

import java.util.List;

public interface NewsService {
    List<News> findAll();
    News find(Long id);
}
