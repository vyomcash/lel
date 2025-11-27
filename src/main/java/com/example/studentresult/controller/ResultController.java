// src/main/java/com/example/studentresult/controller/ResultController.java
package com.example.studentresult.controller;

import com.example.studentresult.model.StudentResult;
import com.example.studentresult.repository.StudentResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ResultController {

    @Autowired
    private StudentResultRepository repository;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("studentResult", new StudentResult());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateAndStore(@ModelAttribute StudentResult studentResult, Model model) {

        // Calculate totals per subject (insem + endsem)
        int s1 = studentResult.getSub1Insem() + studentResult.getSub1Endsem();
        int s2 = studentResult.getSub2Insem() + studentResult.getSub2Endsem();
        int s3 = studentResult.getSub3Insem() + studentResult.getSub3Endsem();
        int s4 = studentResult.getSub4Insem() + studentResult.getSub4Endsem();
        int s5 = studentResult.getSub5Insem() + studentResult.getSub5Endsem();

        int totalMarks = s1 + s2 + s3 + s4 + s5; // out of 500
        double percentage = (totalMarks / 5.0);   // average percent
        double cgpa = percentage / 9.5;           // convert percent to CGPA (common formula)

        // set computed fields
        studentResult.setTotalMarks(totalMarks);
        studentResult.setPercentage(Math.round(percentage * 100.0) / 100.0);
        studentResult.setCgpa(Math.round(cgpa * 100.0) / 100.0);

        // persist to DB
        StudentResult saved = repository.save(studentResult);

        // pass saved entity to certificate view
        model.addAttribute("result", saved);

        // show certificate page
        return "certificate";
    }
}

