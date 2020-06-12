package com.lkreski.cho.model.repositories;

import com.lkreski.cho.model.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication, Long> {
    Publication findByPublicationID(Long id);
    List<Publication> findAllByPublicationDate(LocalDate date);
}
