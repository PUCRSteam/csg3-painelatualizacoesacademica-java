package com.example.painelatualizacaoesacademicas.repository;

import com.example.painelatualizacaoesacademicas.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
}
