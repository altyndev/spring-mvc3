package thymeleaf;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import thymeleaf.model.Student;

public class Main {
    public static void main(String[] args) {

        EntityManager entityManager = Persistence
                .createEntityManagerFactory(
                        "database")
                .createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new Student(
                "test", "test@gmail.com", 16));

        entityManager.getTransaction().commit();

        entityManager.close();
    }
}
