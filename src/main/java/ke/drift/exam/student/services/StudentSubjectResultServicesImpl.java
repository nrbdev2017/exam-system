package ke.drift.exam.student.services;

import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.models.StudentSubjectResult;
import ke.drift.exam.student.repositories.StudentRepository;
import ke.drift.exam.student.repositories.StudentSubjectResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentSubjectResultServicesImpl
        implements StudentSubjectResultServices {

    @Autowired
    private StudentSubjectResultRepository resultRepository;

    @Override public StudentSubjectResult save(StudentSubjectResult result)
    {
        return resultRepository.save(result);
    }

    @Override public StudentSubjectResult getById(Long id)
    {
        Optional<StudentSubjectResult> optional = resultRepository.findById(id);
        StudentSubjectResult result = null;
        if (optional.isPresent())
            result = optional.get();
        else
            throw new RuntimeException(
                    "Result not found for id : " + id);
        return result;
    }

    @Override public List<StudentSubjectResult> getByTermIdAndStudentId(Long termId, Long  studentId)
    {
        return resultRepository.findByTermIdAndStudentId(termId, studentId);
    }

    @Override public List<StudentSubjectResult> getStudentResultsByTerm(Long termId)
    {
        return resultRepository.findByTermId(termId);
    }

    @Override
    public List<StudentSubjectResult> getResultsByStudent(Long studentId) {
        return resultRepository.findByStudentId(studentId);
    }

    @Override
    public List<StudentSubjectResult> getResultsBySubject(Long subjectId) {
        return resultRepository.findBySubjectId(subjectId);
    }

}