package com.example.pSort.repository;

import com.example.pSort.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParticipantRepo extends JpaRepository<Participant, Long> {  //Связь между классом участника
                                                                             //и базой данных

    List<Participant> findBySex(String sex);

    List<Participant> findByAgeOrAge(int age1, int age2);

    List<Participant> findByWeightBetween(int weight1, int weight2);

    @Query(value = "SELECT * FROM participants WHERE sex = ?1 AND (age = ?2 OR age = ?3)", nativeQuery = true)
    List<Participant> findBySexAndAge(String sex, int age1, int age2);

    @Query("select p from Participant p where p.sex = ?1 and (age = ?2 or age = ?3) and (weight between ?4 and ?5)")
    List<Participant> findBySexAndAgeAndWeight(String sex, int age1, int age2,
                                               int weight1, int weight2);

}
