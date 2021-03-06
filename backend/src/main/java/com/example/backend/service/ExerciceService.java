package com.example.backend.service;

import java.util.List;

import com.example.backend.model.Exercice;


public interface ExerciceService {
	
    public void ajoutExercice(Exercice exercice);
   
    public List<Exercice>listExercice();
    
    public Exercice ExerciceById(Long id);
    
    public void updateExcercice(Long id, Exercice exercice);
       
    public Exercice getExerciceByAnnee(String annee);

    public void deleteExercice(Long id);

}
