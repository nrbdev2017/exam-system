package ke.drift.exam.exam.repositories;

import ke.drift.exam.exam.models.AcademicYear;
import ke.drift.exam.exam.models.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking,Long> {
}