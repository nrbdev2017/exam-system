package ke.drift.exam.student.controllers;

import ke.drift.exam.student.models.Student;
import ke.drift.exam.student.services.StudentServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentServicesImpl studentServices;

    @GetMapping("/students")
    public String viewStudents() {
        return "redirect:/students/list";
    }

    @GetMapping("/students/list")
    public String viewStudentsList(Model model) {
        model.addAttribute("allStudents", studentServices.getAllStudents());
        return "students_list";
    }

    @GetMapping("/students/add")
    public String addNewStudent(Model model) {
        Student Student = new Student();
        model.addAttribute("student", Student);
        return "students_add";
    }

    @PostMapping("/students/add")
    public String addStudent(@ModelAttribute("Student") Student student) {
        Student saved = studentServices.save(student);
        return "redirect:/students/"+saved.getId()+"/edit";
    }

    @GetMapping("/students/{id}/edit")
    public String editStudentDetails(@PathVariable(value = "id") long id, Model model) {
        Student student = studentServices.getById(id);
        model.addAttribute("student", student);
        return "students_edit";
    }

    @PostMapping("/students/{id}/edit")
    public String updateStudent(@ModelAttribute("Student") Student student) {
        Student saved = studentServices.save(student);
        return "redirect:/students/"+saved.getId()+"/edit";
    }

    @DeleteMapping("/students/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        studentServices.deleteById(id);
        return "redirect:/students/list";
    }
}