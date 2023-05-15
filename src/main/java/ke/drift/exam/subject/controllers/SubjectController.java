package ke.drift.exam.subject.controllers;

import ke.drift.exam.subject.models.Subject;
import ke.drift.exam.subject.models.SubjectCategory;
import ke.drift.exam.subject.services.SubjectServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SubjectController {

    @Autowired
    private SubjectServicesImpl subjectServices;

    @GetMapping("/subjects")
    public String viewSubjects() {
        return "redirect:/subjects/list";
    }

    @GetMapping("/subjects/list")
    public String viewSubjectsList(Model model) {
        model.addAttribute("allSubjects", subjectServices.getAllSubjects());
        return "subjects_list";
    }

    @GetMapping("/subjects/add")
    public String addNewSubject(Model model) {
        Subject Subject = new Subject();
        model.addAttribute("subject", Subject);
        return "subjects_add";
    }

    @PostMapping("/subjects/add")
    public String addSubject(@ModelAttribute("Subject") Subject Subject) {
        subjectServices.save(Subject);
        return "redirect:/subjects/list";
    }

    @GetMapping("/subjects/{id}/edit")
    public String editSubjectDetails(@PathVariable(value = "id") long id, Model model) {
        Subject subject = subjectServices.getById(id);
        model.addAttribute("subject", subject);
        return "subjects_edit";
    }

    @PostMapping("/subjects/{id}/edit")
    public String updateSubject(@ModelAttribute("Subject") Subject subject) {
        Subject saved = subjectServices.save(subject);
        return "redirect:/subjects/"+saved.getId()+"/edit";
    }

    @DeleteMapping("/subjects/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        subjectServices.deleteById(id);
        return "redirect:/subjects/list";

    }
}