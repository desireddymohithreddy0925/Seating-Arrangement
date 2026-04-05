package com.sag.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SeatingController {

    @Autowired
    SeatingService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/generate")
    public String generate(
            @RequestParam int rows,
            @RequestParam int cols,
            @RequestParam String participants,
            @RequestParam String conflicts,
            Model model) {

        String[] people = participants.split(",");

        String[] conflictPairs = conflicts.split(",");
        String[][] conflictList = new String[conflictPairs.length * 2][2];

        int k = 0;
        for (String c : conflictPairs) {
            String[] pair = c.split("-");
            conflictList[k++] = pair;
            conflictList[k++] = new String[]{pair[1], pair[0]};
        }

        String[][] result = service.generate(rows, cols, people, conflictList);
        model.addAttribute("conflicts", conflicts);
        model.addAttribute("seats", result);

        return "result";
    }
}