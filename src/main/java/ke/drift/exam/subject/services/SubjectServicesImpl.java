package ke.drift.exam.subject.services;

import ke.drift.exam.subject.models.Subject;
import ke.drift.exam.subject.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServicesImpl
        implements SubjectServices {

    @Autowired
    private SubjectRepository subjectRepo;

    @Override public List<Subject> getAllSubjects()
    {
        return subjectRepo.findAll();
    }

    @Override public Subject save(Subject subject)
    {
        return subjectRepo.save(subject);
    }

    @Override public Subject getById(Long id)
    {
        Optional<Subject> optional = subjectRepo.findById(id);
        Subject Subject = null;
        if (optional.isPresent())
            Subject = optional.get();
        else
            throw new RuntimeException(
                    "Subject not found for id : " + id);
        return Subject;
    }

    @Override public Subject getBySubjectCode(String code)
    {
        Optional<Subject> optional = Optional.ofNullable(subjectRepo.findBySubjectCode(code));
        Subject Subject = null;
        if (optional.isPresent())
            Subject = optional.get();
        else
            throw new RuntimeException(
                    "Subject not found for code : " + code);
        return Subject;
    }

    @Override public void deleteById(long id)
    {
        subjectRepo.deleteById(id);
    }
}