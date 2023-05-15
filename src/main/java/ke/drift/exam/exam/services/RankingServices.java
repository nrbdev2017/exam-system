package ke.drift.exam.exam.services;

import ke.drift.exam.exam.models.AcademicTerm;

import java.util.List;

public interface RankingServices {
    void calculateRanking(Long termId);
}