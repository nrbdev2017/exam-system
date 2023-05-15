package ke.drift.exam.subject.repositories;

import ke.drift.exam.subject.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject,Long> {
    Subject findBySubjectCode(String code);
}
