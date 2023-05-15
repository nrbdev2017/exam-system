package ke.drift.exam.subject.services;

import ke.drift.exam.subject.models.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectServices {
    List<Subject> getAllSubjects();
    Subject save(Subject subject);
    Subject getById(Long id);
    Subject getBySubjectCode(String code);
    void deleteById(long id);
}