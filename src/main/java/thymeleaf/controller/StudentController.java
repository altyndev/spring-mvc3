package thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import thymeleaf.exceptions.StudentNotFound;
import thymeleaf.model.Student;
import thymeleaf.repository.StudentRepository;
import thymeleaf.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final StudentService service;

    public StudentController(StudentRepository studentRepository, StudentService service) {
        this.studentRepository = studentRepository;
        this.service = service;
    }

    @GetMapping("/find/{studentId}")
    public String showStudentById(
            @PathVariable Long studentId, Model model) {
        Student student = studentRepository.findById(studentId);
        if (student == null) {
            try {
                throw new StudentNotFound(
                        "Student with id = " + studentId + " not found"
                );
            } catch (StudentNotFound studentNotFound) {
                model.addAttribute(
                        "message", studentNotFound.getMessage());
                return "exceptionHandler";
            }
        }
        model.addAttribute("st", student);
        return "showStudent";
    }

    //find all
    @GetMapping
    public String showAllStudents(Model model) {
        List<Student> students = studentRepository.findAll();
        model.addAttribute("studentList", students);
        return "allStudents";
    }

    @GetMapping("/save")
    public String showSaveStudentPage(Model model) {
        model.addAttribute("emptyStudent", new Student());
        return "saveStudentPage";
    }

    @PostMapping("/save")
    public String saveStudent(Student student) {
        studentRepository.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/search")
    public List<Student> findAllSearch(String name) {
        List<Student> allSearch = service.findAllSearch(name);
        return allSearch;

    }
}
