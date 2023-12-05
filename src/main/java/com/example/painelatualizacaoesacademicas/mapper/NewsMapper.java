package com.example.painelatualizacaoesacademicas.mapper;

import com.example.painelatualizacaoesacademicas.entity.News;
import com.example.painelatualizacaoesacademicas.entity.record.DadosCadastroNews;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewsMapper {
    NewsMapper MAPPER = Mappers.getMapper(NewsMapper.class);

    DadosCadastroNews mapToDadosCadastroNews (News news);

    News mapToNews(DadosCadastroNews dadosCadastroNews);
}
