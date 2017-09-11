package com.WhiteBoard.WhiteBoard.controllers;

import com.WhiteBoard.WhiteBoard.repositories.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by bly01854 on 9/11/2017.
 */
@Controller
public class StudentController {

    private StudentRepository studentRepository;

    @RequestMapping("/students")
    public String getStudents(Model model){

        model.addAttribute("students", studentRepository.findAll());

        return "students";


    }

}
