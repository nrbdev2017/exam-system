package ke.drift.exam.exam.services;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.exam.repositories.AcademicTermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicTermServicesImpl
        implements AcademicTermServices {

    @Autowired
    private AcademicTermRepository termRepository;

    @Override public List<AcademicTerm> getAllTerms()
    {
        return termRepository.findAll();
    }

    @Override public AcademicTerm save(AcademicTerm term)
    {
        return termRepository.save(term);
    }

    @Override public AcademicTerm getById(Long id)
    {
        Optional<AcademicTerm> optional = termRepository.findById(id);
        AcademicTerm term = null;
        if (optional.isPresent())
            term = optional.get();
        else
            throw new RuntimeException(
                    "Term not found for id : " + id);
        return term;
    }

    @Override public AcademicTerm getByTermName(String name)
    {
        Optional<AcademicTerm> optional = Optional.ofNullable(termRepository.findByTermName(name));
        AcademicTerm term = null;
        if (optional.isPresent())
            term = optional.get();
        else
            throw new RuntimeException(
                    "Term "+ name +" not found");
        return term;
    }

    @Override public void deleteById(long id)
    {
        termRepository.deleteById(id);
    }
}