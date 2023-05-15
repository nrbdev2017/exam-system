package ke.drift.exam.exam.services;

import ke.drift.exam.exam.models.AcademicTerm;

import java.util.List;

public interface AcademicTermServices {
    List<AcademicTerm> getAllTerms();
    AcademicTerm save(AcademicTerm year);
    AcademicTerm getById(Long id);
    AcademicTerm getByTermName(String term);
    void deleteById(long id);
}