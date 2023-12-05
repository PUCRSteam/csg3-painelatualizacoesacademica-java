package com.example.painelatualizacaoesacademicas.service;

import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroNews;

import java.util.List;

public interface NewsService {
    List<DadosCadastroNews> findAll();
    DadosCadastroNews findById(Long id);
    DadosCadastroNews create(News news);
}
