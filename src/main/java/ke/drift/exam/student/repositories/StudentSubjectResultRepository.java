package ke.drift.exam.student.repositories;

import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.models.StudentSubjectResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSubjectResultRepository extends JpaRepository<StudentSubjectResult,Long> {
    List<StudentSubjectResult> findByTermIdAndStudentId(Long termId, Long studentId);
    List<StudentSubjectResult> findByTermId(Long termId);
    List<StudentSubjectResult> findByStudentId(Long studentId);
    List<StudentSubjectResult> findBySubjectId(Long subjectId);
}