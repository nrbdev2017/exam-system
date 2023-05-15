package ke.drift.exam.subject.services;

import ke.drift.exam.subject.models.SubjectCategory;
import ke.drift.exam.subject.repositories.SubjectCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectCategoryServicesImpl
        implements SubjectCategoryServices {

    @Autowired
    private SubjectCategoryRepository categoryRepository;

    @Override public List<SubjectCategory> getAllCategories()
    {
        return categoryRepository.findAll();
    }

    @Override public SubjectCategory save(SubjectCategory SubjectCategory)
    {
        return categoryRepository.save(SubjectCategory);
    }

    @Override public SubjectCategory getById(Long id)
    {
        Optional<SubjectCategory> optional = categoryRepository.findById(id);
        SubjectCategory category = null;
        if (optional.isPresent())
            category = optional.get();
        else
            throw new RuntimeException(
                    "Category not found for id : " + id);
        return category;
    }

    @Override public SubjectCategory getByName(String code)
    {
        Optional<SubjectCategory> optional = Optional.ofNullable(categoryRepository.findByName(code));
        SubjectCategory category = null;
        if (optional.isPresent())
            category = optional.get();
        else
            throw new RuntimeException(
                    "Subject not found for code : " + code);
        return category;
    }

    @Override public void deleteById(long id)
    {
        categoryRepository.deleteById(id);
    }
}