package ke.drift.exam.exam.services;

import ke.drift.exam.exam.models.AcademicYear;

import java.util.List;

public interface AcademicYearServices {
    List<AcademicYear> getAllYears();
    AcademicYear save(AcademicYear year);
    AcademicYear getById(Long id);
    AcademicYear getByYearName(String year);
    void deleteById(long id);
}