package com.example.projectrestapi.Repo;

import com.example.projectrestapi.model.Zadanie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ZadanieRepository extends JpaRepository<Zadanie, Integer> {
    //dwukropkiem oznacza się parametry zapytania
    @Query("SELECT z FROM Zadanie z WHERE z.projekt_id = :projektId")
    Page<Zadanie> findZadaniaProjektu(@Param("projektId") Integer projektId, Pageable pageable);
    @Query("SELECT z FROM Zadanie z WHERE z.projekt_id = :projektId")
    List<Zadanie> findZadaniaProjektu(@Param("projektId") Integer projektId);
}
