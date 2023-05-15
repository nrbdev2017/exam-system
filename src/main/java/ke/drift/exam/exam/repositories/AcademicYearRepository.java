package ke.drift.exam.exam.repositories;

import ke.drift.exam.exam.models.AcademicYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademicYearRepository extends JpaRepository<AcademicYear,Long> {
    AcademicYear findByYearName(String yearName);
}