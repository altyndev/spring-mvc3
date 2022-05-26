package thymeleaf.service;

import org.springframework.stereotype.Service;

import thymeleaf.model.Student;

import thymeleaf.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;


    @Override
    public List<Student> findAllSearch(String name) {
        return repository.findAll().stream()
                .filter(student -> student.getName().equals(name)).collect(Collectors.toList());
    }
}
