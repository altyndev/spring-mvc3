package thymeleaf.service;

import thymeleaf.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAllSearch(String name);
}
