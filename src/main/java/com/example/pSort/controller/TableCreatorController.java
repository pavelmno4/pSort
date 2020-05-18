package com.example.pSort.controller;

import com.example.pSort.domain.Participant;
import com.example.pSort.repository.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class TableCreatorController {
    @Autowired
    private ParticipantRepo participantRepo;

    @GetMapping("/table-creator")
    private String createTable(@RequestParam String sex,
                               @RequestParam String ageInterval,
                               @RequestParam String weightCategory,
                               Model model) {
        List<Participant> participants;

        String[] age = ageInterval.split("-");
        String[] weight = weightCategory.split("-");
        participants = participantRepo.findBySexAndAgeAndWeight(sex, Integer.parseInt(age[0]), Integer.parseInt(age[1]), Integer.parseInt(weight[0]), Integer.parseInt(weight[1]));

        Collections.shuffle(participants);

        model.addAttribute("participants", participants);

        return "/table-creator";
    }
}
