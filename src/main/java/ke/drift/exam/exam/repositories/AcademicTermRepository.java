package ke.drift.exam.exam.repositories;

import ke.drift.exam.exam.models.AcademicTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademicTermRepository extends JpaRepository<AcademicTerm,Long> {
    AcademicTerm findByTermName(String yearName);
}