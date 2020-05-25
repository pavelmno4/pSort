package com.example.pSort.controller;

import com.example.pSort.domain.Participant;
import com.example.pSort.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "/greeting";
    }

    @GetMapping("/participant-list")
    public String participantList(@RequestParam(required = false) String sex,
                                  @RequestParam(required = false) String ageInterval,
                                  @RequestParam(required = false) String weightCategory,
                                  Model model) {
        List<Participant> participants = participantService.getParticipants(sex, ageInterval, weightCategory);

        model.addAttribute("participants", participants);

        return "participant-list";
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

        participantService.save(participant);

        return "redirect:/successful-part-reg";
    }

    @GetMapping("/successful-part-reg")
    public String successReg() {
        return "successful-part-reg";
    }


}
