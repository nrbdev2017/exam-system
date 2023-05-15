package ke.drift.exam.subject.controllers;

import ke.drift.exam.subject.models.Subject;
import ke.drift.exam.subject.models.SubjectCategory;
import ke.drift.exam.subject.services.SubjectCategoryServicesImpl;
import ke.drift.exam.subject.services.SubjectServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectCategoryController {

    @Autowired
    private SubjectCategoryServicesImpl categoryServices;

    @GetMapping("/subjects/categories")
    public String viewCategories() {
        return "redirect:/subjects/categories/list";
    }

    @GetMapping("/subjects/categories/list")
    public String viewCategoriesList(Model model) {
        model.addAttribute("allCategories", categoryServices.getAllCategories());
        return "subjects_categories_list";
    }

    @GetMapping("/subjects/categories/add")
    public String addNewCategory(Model model) {
        SubjectCategory category = new SubjectCategory();
        model.addAttribute("category", category);
        return "subjects_categories_add";
    }

    @PostMapping("/subjects/categories/add")
    public String addCategory(@ModelAttribute("Subject") SubjectCategory category) {
        SubjectCategory saved = categoryServices.save(category);
        return "redirect:/subjects/categories/"+saved.getId()+"/edit";
    }

    @GetMapping("/subjects/categories/{id}/edit")
    public String editCategoryDetails(@PathVariable(value = "id") long id, Model model) {
        SubjectCategory category = categoryServices.getById(id);
        model.addAttribute("category", category);
        return "subjects_categories_edit";
    }

    @PostMapping("/subjects/categories/{id}/edit")
    public String updateCategory(@ModelAttribute("Subject") SubjectCategory category) {
        SubjectCategory saved = categoryServices.save(category);
        return "redirect:/subjects/categories/"+saved.getId()+"/edit";
    }

    @DeleteMapping("/subjects/categories/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        categoryServices.deleteById(id);
        return "redirect:/subjects/categories/list";
    }
}