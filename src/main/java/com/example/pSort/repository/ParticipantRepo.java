package com.example.pSort.repository;

import com.example.pSort.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {

}
