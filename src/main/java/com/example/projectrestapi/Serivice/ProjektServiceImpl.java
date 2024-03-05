package com.example.projectrestapi.Serivice;

import com.example.projectrestapi.Repo.ProjektRepository;
import com.example.projectrestapi.Repo.ZadanieRepository;
import com.example.projectrestapi.model.Projekt;
import com.example.projectrestapi.model.Zadanie;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjektServiceImpl implements ProjektService {
    private ProjektRepository projektRepository;
    private ZadanieRepository zadanieRepository;
    @Autowired // w tej wersji konstruktora Spring wstrzyknie dwa repozytoria
    public ProjektServiceImpl(ProjektRepository projektRepository, ZadanieRepository zadanieRepo) {
        this.projektRepository = projektRepository;
        this.zadanieRepository = zadanieRepo;
    }

    @Override
    public Optional<Projekt> getProjekt(Integer projektId) {
        return projektRepository.findById(projektId);
    }
    @Override
    public Projekt setProjekt(Projekt projekt) {
        return projektRepository.save(projekt);
    }

    @Override
    public Page<Projekt> getProjekty(Pageable pageable) {
        return projektRepository.findAll(pageable);

    }

    @Override
    public Page<Projekt> searchByNazwa(String nazwa, Pageable pageable) {
        return projektRepository.findByNazwaContainingIgnoreCase(nazwa, pageable);

    }

    @Override
    public List<Projekt> findByNazwaContainingIgnoreCase(String nazwa) {
        return projektRepository.findByNazwaContainingIgnoreCase(nazwa);
    }
    @Override
    public void deleteProjekt(Integer projektId) {
        for (Zadanie zadanie : zadanieRepository.findZadaniaProjektu(projektId)) {
            zadanieRepository.delete(zadanie);
        }
        projektRepository.deleteById(projektId);
    }


}