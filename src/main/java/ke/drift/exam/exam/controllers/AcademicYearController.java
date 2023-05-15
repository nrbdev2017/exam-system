package ke.drift.exam.exam.controllers;

import ke.drift.exam.exam.models.AcademicYear;
import ke.drift.exam.exam.services.AcademicYearServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AcademicYearController {

    @Autowired
    private AcademicYearServicesImpl yearServices;

    @GetMapping({"/exams/years","/exams/years/list"})
    public String viewYearsList(Model model) {
        model.addAttribute("allYears", yearServices.getAllYears());
        return "exam_years_list";
    }

    @GetMapping("/exams/years/add")
    public String addNewYear(Model model) {
        AcademicYear year = new AcademicYear();
        model.addAttribute("year", year);
        return "exam_years_add";
    }

    @PostMapping("/exams/years/add")
    public String addYear(@ModelAttribute("Year") AcademicYear year) {
        AcademicYear saved = yearServices.save(year);
        return "redirect:/exams/years/"+saved.getId()+"/edit";
    }

    @GetMapping("/exams/years/{id}/edit")
    public String editYearDetails(@PathVariable(value = "id") long id, Model model) {
        AcademicYear year = yearServices.getById(id);
        model.addAttribute("year", year);
        return "exam_years_edit";
    }

    @PostMapping("/exams/years/{id}/edit")
    public String updateYear(@ModelAttribute("Year") AcademicYear year) {
        AcademicYear saved = yearServices.save(year);
        return "redirect:/exams/years/"+saved.getId()+"/edit";
    }

    @DeleteMapping("/exams/years/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        yearServices.deleteById(id);
        return "redirect:/exams/years/list";
    }
}