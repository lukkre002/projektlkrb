package com.lkreski.cho.controllers;

import com.lkreski.cho.model.entity.Publication;
import com.lkreski.cho.model.repositories.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class PublicationsController {

    @Autowired
    private  PublicationRepository publicationRepository;


    @GetMapping("show")
    public String showPublications(Model model){
        List<Publication> all = publicationRepository.findAll();
        model.addAttribute("all",all);
        return "showpublications";
    }

    @GetMapping("showAddPublication")
    public String addNewPublication(Model model){
        List<Publication> all = publicationRepository.findAll();
        model.addAttribute("publication", new Publication());
        return  "newpublication";
    }

    @PostMapping("showAddPublication")
    public String addNewPublicationPost(Model model, Publication publication){
        publication.setVersion(1L);
        publicationRepository.saveAndFlush(publication);
        return "newpublication";
    }

    @GetMapping("deletePublication")
    public String deletePublication(@RequestParam String param){
        publicationRepository.deleteById(Long.parseLong(param));
        return "redirect:show";
    }

    @GetMapping("editPublication")
    public String editPublication(@RequestParam String param, Model model){
        Publication publication = publicationRepository.findByPublicationID(Long.parseLong(param));
        model.addAttribute("publication", publication);
        return "editpublication";

    }
}
