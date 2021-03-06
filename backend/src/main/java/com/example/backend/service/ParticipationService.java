package com.example.backend.service;

import com.example.backend.enumeration.Etat;
import com.example.backend.model.Participation;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ParticipationService {

    public Participation ajouterParticipation(Participation p);
    public void deleteParticipation(Long id);
    public void updateParticipation(Long id, Participation p);
    public List<Participation> getAllParticipation();
    public List<Participation> getAllParticipationInactive();
    public Participation getParticipationById(Long id);
    List<Participation>participantByActivite(Long IdActivite);
    public List<Participation> participationByEtat(Etat etat);
    public void restaurer(Long id);
}
