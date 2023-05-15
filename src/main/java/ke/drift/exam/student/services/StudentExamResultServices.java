package ke.drift.exam.student.services;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.student.dto.ExamResultDTO;
import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.models.StudentExamResult;

import java.util.List;

public interface StudentExamResultServices {
    List<StudentExamResult> getTermExamResults(Long termId);
    void save(ExamResultDTO results);
}