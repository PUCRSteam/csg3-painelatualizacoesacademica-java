package com.example.painelatualizacaoesacademicas.mapper;

import com.example.painelatualizacaoesacademicas.entity.News;
import org.mapstruct.factory.Mappers;

public interface NewsMapper {
    NewsMapper MAPPER = Mappers.getMapper(NewsMapper.class);
    News mapToNews(News news);

}
