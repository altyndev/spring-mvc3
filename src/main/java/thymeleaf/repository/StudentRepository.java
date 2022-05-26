package thymeleaf.repository;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;
import thymeleaf.model.Student;

import java.util.List;

@Component
public class StudentRepository {

    //entity manager

    private final EntityManager entityManager;

    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveStudent(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();

    }

    public Student findById(Long id) {
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().commit();
        return student;
    }

    public List<Student> findAll() {
        entityManager.getTransaction().begin();
        List<Student> students = entityManager.createQuery(
                        "SELECT s FROM Student s", Student.class)
                .getResultList();
        entityManager.getTransaction().commit();
        return students;
    }

    public void deleteStudentById(Long studentId) {
        entityManager.getTransaction().begin();
        entityManager.createQuery(
                        "delete from Student s where s.id = ?1")
                .setParameter(1, studentId)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List findWithName(String name) {
        return entityManager.createQuery(
                        "SELECT c FROM Student c WHERE c.name LIKE :name")
                .setParameter("name", name)
                .setMaxResults(10)
                .getResultList();
    }
}
