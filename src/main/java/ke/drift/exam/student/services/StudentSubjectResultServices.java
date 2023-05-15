package ke.drift.exam.student.services;

import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.models.StudentSubjectResult;

import java.util.List;

public interface StudentSubjectResultServices {

    StudentSubjectResult save(StudentSubjectResult result);
    StudentSubjectResult getById(Long id);

    List<StudentSubjectResult> getByTermIdAndStudentId(Long termId, Long studentId);

    List<StudentSubjectResult> getStudentResultsByTerm(Long termId);
    List<StudentSubjectResult> getResultsByStudent(Long studentId);
    List<StudentSubjectResult> getResultsBySubject(Long subjectId);
}