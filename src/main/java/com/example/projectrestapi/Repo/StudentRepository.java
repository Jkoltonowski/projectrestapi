package com.example.projectrestapi.Repo;

import com.example.projectrestapi.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByNrIndeksu(String nrIndeksu);
    Page<Student> findByNrIndeksuStartsWith(String nrIndeksu, Pageable pageable);
    Page<Student> findByNazwiskoStartsWithIgnoreCase(String nazwisko, Pageable pageable);

}
// Metoda findByNrIndeksuStartsWith definiuje zapytanie
// SELECT s FROM Student s WHERE s.nrIndeksu LIKE :nrIndeksu
// Metoda findByNazwiskoStartsWithIgnoreCase definiuje zapytanie
// SELECT s FROM Student s WHERE upper(s.nazwisko) LIKE upper(:nazwisko%)