package ke.drift.exam.exam.controllers;

import ke.drift.exam.exam.models.AcademicTerm;
import ke.drift.exam.exam.services.AcademicTermServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AcademicTermController {

    @Autowired
    private AcademicTermServicesImpl termServices;

    @GetMapping({"/exams/years/terms","/exams/years/terms/list"})
    public String viewTermsList(Model model) {
        model.addAttribute("allTerms", termServices.getAllTerms());
        return "exam_terms_list";
    }

    @GetMapping("/exams/years/terms/add")
    public String addNewTerm(Model model) {
        AcademicTerm term = new AcademicTerm();
        model.addAttribute("term", term);
        return "exam_terms_add";
    }

    @PostMapping("/exams/years/terms/add")
    public String addTerm(@ModelAttribute("Term") AcademicTerm year) {
        AcademicTerm saved = termServices.save(year);
        return "redirect:/exams/years/terms/"+saved.getId()+"/edit";
    }

    @GetMapping("/exams/years/terms/{id}/edit")
    public String editTermDetails(@PathVariable(value = "id") long id, Model model) {
        AcademicTerm year = termServices.getById(id);
        model.addAttribute("year", year);
        return "exam_terms_edit";
    }

    @PostMapping("/exams/years/terms/{id}/edit")
    public String updateTerm(@ModelAttribute("Term") AcademicTerm year) {
        AcademicTerm saved = termServices.save(year);
        return "redirect:/exams/years/terms/"+saved.getId()+"/edit";
    }

    @DeleteMapping("/exams/years/terms/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        termServices.deleteById(id);
        return "redirect:/exams/years/terms/list";
    }
}