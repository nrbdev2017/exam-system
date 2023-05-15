package ke.drift.exam.student.controllers;

import ke.drift.exam.student.dto.ExamResultDTO;
import ke.drift.exam.student.services.StudentExamResultServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentExamResultController {

    @Autowired
    private StudentExamResultServicesImpl resultServices;

    @GetMapping("/exam/result/add")
    public String addNewResult(Model model) {
        ExamResultDTO result = new ExamResultDTO();
        model.addAttribute("result", result);
        return "students_add";
    }

    @PostMapping("/exam/result/add")
    public String addStudent(@ModelAttribute("result") ExamResultDTO resultDTO) {
        resultServices.save(resultDTO);
        return "redirect:/students/";
    }

}