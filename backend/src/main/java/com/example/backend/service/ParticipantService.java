package com.example.backend.service;

import com.example.backend.enumeration.ParticipantGenre;
import com.example.backend.model.Participant;
import java.util.List;
public interface ParticipantService {
    public String  addParticipant(Participant participant);
    public Participant updateParticipant(Long id, Participant participant);
    public List<Participant> listParticipant();
    void deleteParticipant( Long id);
    Participant ParticipantById(Long id_participant);
    int findByparticipantGenre(ParticipantGenre genre);
    public List<Participant> addManyParticipant(List<Participant> participants);
}
