package ke.drift.exam.subject.services;

import ke.drift.exam.subject.models.SubjectCategory;

import java.util.List;

public interface SubjectCategoryServices {
    List<SubjectCategory> getAllCategories();
    SubjectCategory save(SubjectCategory category);
    SubjectCategory getById(Long id);
    SubjectCategory getByName(String code);
    void deleteById(long id);
}