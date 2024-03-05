package com.example.projectrestapi.Serivice;

import com.example.projectrestapi.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudent(Integer student_id);
    Student setStudent(Student student);
    void deleteStudent(Integer student_id);
    Page<Student> getStudent(Pageable pageable);
    Page<Student> searchByNrIndeksuStartingWith(String nrIndeksu, Pageable pageable);
    Optional<Student> findByNrIndeksu(String nrIndeksu);
    Page<Student> findByNazwiskoStartsWithIgnoreCase(String nazwisko, Pageable pageable);


}
