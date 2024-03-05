package com.example.projectrestapi.Serivice;

import com.example.projectrestapi.Repo.ProjektRepository;
import com.example.projectrestapi.Repo.StudentRepository;
import com.example.projectrestapi.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private ProjektRepository projektRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository,ProjektRepository projektRepository) {
        this.studentRepository = studentRepository;
        this.projektRepository = projektRepository;
    }

    @Override
    public Optional<Student> getStudent(Integer student_id) {
        return studentRepository.findById(student_id);
    }

    @Override
    public Student setStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudent(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    public void deleteStudent(Integer student_id) {
        studentRepository.deleteById(student_id);
    }
    @Override
    public Page<Student> searchByNrIndeksuStartingWith(String nrIndeksu, Pageable pageable) {
        return studentRepository.findByNrIndeksuStartsWith(nrIndeksu, pageable);
    }

    @Override
    public Optional<Student> findByNrIndeksu(String nrIndeksu) {
        return studentRepository.findByNrIndeksu(nrIndeksu);
    }

    @Override
    public Page<Student> findByNazwiskoStartsWithIgnoreCase(String nazwisko, Pageable pageable) {
        return findByNazwiskoStartsWithIgnoreCase(nazwisko, pageable);
    }


}