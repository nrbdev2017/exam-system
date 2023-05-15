package ke.drift.exam.student.repositories;

import ke.drift.exam.student.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findByRegistrationNumber(String number);
}