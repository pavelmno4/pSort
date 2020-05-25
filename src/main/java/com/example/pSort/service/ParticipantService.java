package com.example.pSort.service;

import com.example.pSort.domain.Participant;
import com.example.pSort.repository.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepo participantRepo;


    public List<Participant> getParticipants(String sex, String ageInterval, String weightCategory) {
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
        return participants;
    }

    public void save(Participant participant) {
        participantRepo.save(participant);
    }
}
