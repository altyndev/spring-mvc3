package thymeleaf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "students")
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_generator"
    )
    @SequenceGenerator(
            name = "student_id_generator",
            sequenceName = "student_id_seq",
            allocationSize = 1
    )
    private Long id;

    private String name;

    private String email;

    private int age;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
