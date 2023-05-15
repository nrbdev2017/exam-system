package ke.drift.exam.subject.repositories;

import ke.drift.exam.subject.models.Subject;
import ke.drift.exam.subject.models.SubjectCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectCategoryRepository extends JpaRepository<SubjectCategory,Long> {
    SubjectCategory findByName(String name);
}
