package ke.drift.exam.exam.services;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.exam.models.Ranking;
import ke.drift.exam.exam.repositories.AcademicTermRepository;
import ke.drift.exam.exam.repositories.RankingRepository;
import ke.drift.exam.student.models.StudentExamResult;
import ke.drift.exam.student.services.StudentExamResultServicesImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class RankingServicesImpl
        implements RankingServices {

    @Autowired
    private RankingRepository rankingRepository;
    private StudentExamResultServicesImpl examResultServices;

    @Override
    public void calculateRanking(Long termId){
        List<StudentExamResult> fullTermResults = examResultServices.getTermExamResults(termId);

        // Rank student based on points and marks
        fullTermResults
                .sort(Comparator.comparingDouble(StudentExamResult::getTotalPoints)
                .thenComparingDouble(StudentExamResult::getTotalMarks).reversed());

        Integer studentNumber = 1;
        Integer studentRank = 1;

        Double points = 0.0;

        for (StudentExamResult result: fullTermResults){

            points = result.getTotalPoints();

            if (Objects.equals(points, result.getTotalPoints())) { }

            Ranking rank = new Ranking();
            rank.setStudent(result.getStudent());
            rank.setTerm(result.getTerm());
            rank.setMeanGrade(result.getMeanGrade());
            rank.setMeanPoints(result.getMeanPoints());
            rank.setTotalMarks(result.getTotalMarks());
            rank.setTotalPoints(result.getTotalPoints());
            rank.setStudentNumber(studentNumber);
            rank.setStudentRank(studentRank);

            rankingRepository.save(rank);
            studentNumber++;
        }
    }


}