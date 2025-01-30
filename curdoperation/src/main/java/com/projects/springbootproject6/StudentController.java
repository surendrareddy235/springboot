package com.projects.springbootproject6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/surya")
    public String showLogin() {
        return "login"; 
    }

    @PostMapping("/submitform")
    public String showStudent(@ModelAttribute Student student) {
        studentService.saveStudent(student);
        return "success"; 
    }
    @GetMapping("/seedata")
    public String showseedata(Model model) {
    	model.addAttribute("students",studentService.getAllStudents());
    	return "seedata";
    }
    @GetMapping("/delete/{id}")
    public String showdelete(@PathVariable Long id) {
    	studentService.deleteStudent(id);
    	return "redirect:/seedata";
    }
    @GetMapping("/edit/{id}")
    public String showedit(@PathVariable Long id,Model model) {
    	Student student = studentService.editstudent(id);
    	model.addAttribute("students",student);
    	return "login";
    }
}
