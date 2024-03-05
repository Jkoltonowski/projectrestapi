package com.example.projectrestapi.Serivice;

import com.example.projectrestapi.model.Projekt;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
public interface ProjektService {
    Optional<Projekt> getProjekt(Integer projektId);
    Projekt setProjekt(Projekt projekt);
    void deleteProjekt(Integer projektId);
    Page<Projekt> getProjekty(Pageable pageable);
    Page<Projekt> searchByNazwa(String nazwa, Pageable pageable);
    List<Projekt> findByNazwaContainingIgnoreCase(String nazwa);

}