package com.example.painelatualizacaoesacademicas.repository;

import com.example.painelatualizacaoesacademicas.entity.AcademicEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicEventRepository extends JpaRepository<AcademicEvent, Long> {
}
