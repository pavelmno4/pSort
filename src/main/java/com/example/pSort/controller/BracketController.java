package com.example.pSort.controller;

import com.example.pSort.domain.Participant;
import com.example.pSort.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("test")
public class BracketController {
    @Autowired
    private ParticipantService participantService;

    @GetMapping
    public List<Participant> participantsBracket(@RequestParam(required = false) String sex,
                                                 @RequestParam(required = false) String ageInterval,
                                                 @RequestParam(required = false) String weightCategory
    ) {
        return participantService.getParticipants(sex, ageInterval, weightCategory);
    }
}

