package ke.drift.exam.student.services;

import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServicesImpl
        implements StudentServices {

    @Autowired
    private StudentRepository studentRepository;

    @Override public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }

    @Override public Student save(Student Student)
    {
        return studentRepository.save(Student);
    }

    @Override public Student getById(Long id)
    {
        Optional<Student> optional = studentRepository.findById(id);
        Student Student = null;
        if (optional.isPresent())
            Student = optional.get();
        else
            throw new RuntimeException(
                    "Student not found for id : " + id);
        return Student;
    }

    @Override public Student getByRegistrationNumber(String number)
    {
        Optional<Student> optional = Optional.ofNullable(studentRepository.findByRegistrationNumber(number));
        Student Student = null;
        if (optional.isPresent())
            Student = optional.get();
        else
            throw new RuntimeException(
                    "Student not found for registration : " + number);
        return Student;
    }

    @Override public void deleteById(long id)
    {
        studentRepository.deleteById(id);
    }
}