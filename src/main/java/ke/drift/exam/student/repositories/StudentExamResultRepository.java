package ke.drift.exam.student.repositories;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.student.models.StudentExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExamResultRepository extends JpaRepository<StudentExamResult,Long> {
    List<StudentExamResult> findByTermId(Long termId);
}