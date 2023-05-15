package ke.drift.exam.exam.services;

import ke.drift.exam.exam.models.AcademicYear;
import ke.drift.exam.exam.repositories.AcademicYearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicYearServicesImpl
        implements AcademicYearServices {

    @Autowired
    private AcademicYearRepository yearRepository;

    @Override public List<AcademicYear> getAllYears()
    {
        return yearRepository.findAll();
    }

    @Override public AcademicYear save(AcademicYear year)
    {
        return yearRepository.save(year);
    }

    @Override public AcademicYear getById(Long id)
    {
        Optional<AcademicYear> optional = yearRepository.findById(id);
        AcademicYear year = null;
        if (optional.isPresent())
            year = optional.get();
        else
            throw new RuntimeException(
                    "Year not found for id : " + id);
        return year;
    }

    @Override public AcademicYear getByYearName(String name)
    {
        Optional<AcademicYear> optional = Optional.ofNullable(yearRepository.findByYearName(name));
        AcademicYear year = null;
        if (optional.isPresent())
            year = optional.get();
        else
            throw new RuntimeException(
                    "Year "+ name +" not found");
        return year;
    }

    @Override public void deleteById(long id)
    {
        yearRepository.deleteById(id);
    }
}