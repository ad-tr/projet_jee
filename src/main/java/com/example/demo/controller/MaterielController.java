package com.example.demo.controller;

import com.example.demo.model.Materiel;
import com.example.demo.service.MaterielService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/nouveau")
    public String formulaireAjout(Model model) {
        model.addAttribute("materiel", new Materiel());
        return "materiels/formulaire";
    }

    @PostMapping("/nouveau")
    public String ajout(@Valid @ModelAttribute("materiel") Materiel materiel,
            BindingResult result) {
        if (result.hasErrors()) {
            return "materiels/formulaire";
        }
        materielService.save(materiel);
        return "redirect:/materiels";
    }
}
