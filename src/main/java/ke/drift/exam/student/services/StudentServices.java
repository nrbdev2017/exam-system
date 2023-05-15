package ke.drift.exam.student.services;

import ke.drift.exam.student.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServices {
    List<Student> getAllStudents();
    Student save(Student student);
    Student getById(Long id);
    Student getByRegistrationNumber(String number);
    void deleteById(long id);
}