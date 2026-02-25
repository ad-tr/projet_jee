package com.example.demo.controller;

import com.example.demo.model.Materiel;
import com.example.demo.service.MaterielService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/materiels")
public class MaterielController {

    private final MaterielService materielService;

    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @GetMapping
    public String liste(Model model) {
        List<Materiel> materiels = materielService.findAll();
        model.addAttribute("materiels", materiels);
        return "materiels/liste";
    }
}
