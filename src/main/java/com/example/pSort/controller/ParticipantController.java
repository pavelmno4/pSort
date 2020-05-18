package com.example.pSort.controller;

import com.example.pSort.domain.Participant;
import com.example.pSort.repository.ParticipantRepo;
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
    private ParticipantRepo participantRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "/greeting";
    }

    @GetMapping("/participant-list")
    public String participantList(@RequestParam(required = false) String sex,
                                  @RequestParam(required = false) String ageInterval,
                                  @RequestParam(required = false) String weightCategory,
                                  Model model) {
        List<Participant> participants;

        participants = participantRepo.findAll();

        if(sex != null && !sex.isEmpty()) {
            participants = participantRepo.findBySex(sex);
        }

        if(ageInterval != null && !ageInterval.isEmpty()) {
            String[] age = ageInterval.split("-");
            participants = participantRepo.findByAgeOrAge(Integer.parseInt(age[0]), Integer.parseInt(age[1]));
        }

        if(weightCategory != null && !weightCategory.isEmpty()) {
            String[] weight = weightCategory.split("-");
            participants = participantRepo.findByWeightBetween(Integer.parseInt(weight[0]), Integer.parseInt(weight[1]));
        }

        if(sex != null && !sex.isEmpty() & ageInterval != null && !ageInterval.isEmpty()) {
            String[] age = ageInterval.split("-");

            participants = participantRepo.findBySexAndAge(sex, Integer.parseInt(age[0]), Integer.parseInt(age[1]));
        }

        if(ageInterval != null && !ageInterval.isEmpty() &
                weightCategory != null && !weightCategory.isEmpty()) {
            String[] age = ageInterval.split("-");
            String[] weight = weightCategory.split("-");

            participants = participantRepo.findBySexAndAgeAndWeight(sex, Integer.parseInt(age[0]), Integer.parseInt(age[1]), Integer.parseInt(weight[0]), Integer.parseInt(weight[1]));
        }

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

        participantRepo.save(participant);

        return "redirect:/successful-part-reg";
    }

    @GetMapping("/successful-part-reg")
    public String successReg() {
        return "successful-part-reg";
    }


}
