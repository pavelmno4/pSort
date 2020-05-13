package com.example.pSort.controller;

import com.example.pSort.domain.Participant;
import com.example.pSort.domain.Sex;
import com.example.pSort.repository.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ParticipantController {
    @Autowired
    private ParticipantRepo participantRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "/greeting";
    }

    @GetMapping("/participantList")
    public String participantList(Model model) {
        Iterable<Participant> participants = participantRepo.findAll();

        model.addAttribute("participants", participants);

        return "participantsList";
    }

    @GetMapping("/add-participant")
    public String add() {
        return "add-participant";
    }


    @PostMapping("/add-participant")
    public String addParticipant(
            Participant participant,
            @RequestParam String lastName,
            @RequestParam String firstName,
            @RequestParam int age,
            @RequestParam String sex,
            @RequestParam String team,
            @RequestParam int weight
            ) {

        participantRepo.save(participant);

        return "add-participant";
    }


}
