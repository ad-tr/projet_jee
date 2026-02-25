package com.example.demo.service;

import com.example.demo.model.Materiel;
import com.example.demo.repository.MaterielRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielService {

    private final MaterielRepository materielRepository;

    public MaterielService(MaterielRepository materielRepository) {
        this.materielRepository = materielRepository;
    }

    /**
     * Retourne la liste de tout le matériel disponible en base.
     */
    public List<Materiel> findAll() {
        return materielRepository.findAll();
    }
}
