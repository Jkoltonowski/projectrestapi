package com.example.projectrestapi.Serivice;

import com.example.projectrestapi.model.Zadanie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ZadanieService {
    Optional<Zadanie> getZadanie(Integer zadanieId);
    Zadanie setZadanie(Zadanie zadanie);
    void deleteZadanie(Integer zadanieId);
    Page<Zadanie> getZadania(Pageable pageable);

    List<Zadanie> findZadaniaProjektu(Integer projektId);


}

