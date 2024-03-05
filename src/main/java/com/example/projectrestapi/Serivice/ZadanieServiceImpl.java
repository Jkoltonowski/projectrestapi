package com.example.projectrestapi.Serivice;

import com.example.projectrestapi.Repo.ZadanieRepository;
import com.example.projectrestapi.model.Zadanie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZadanieServiceImpl implements ZadanieService {
    private ZadanieRepository zadanieRepository;

    @Autowired
    public ZadanieServiceImpl(ZadanieRepository zadanieRepository) {
        this.zadanieRepository = zadanieRepository;
    }

    @Override
    public Optional<Zadanie> getZadanie(Integer zadanieId) {
        return zadanieRepository.findById(zadanieId);
    }

    @Override
    public Zadanie setZadanie(Zadanie zadanie) {
        return zadanieRepository.save(zadanie);
    }

    @Override
    public void deleteZadanie(Integer zadanieId) {
        zadanieRepository.deleteById(zadanieId);
    }

    @Override
    public Page<Zadanie> getZadania(Pageable pageable) {
        return zadanieRepository.findAll(pageable);
    }


    @Override
    public List<Zadanie> findZadaniaProjektu(Integer projektId) {
        return zadanieRepository.findZadaniaProjektu(projektId);
    }


}