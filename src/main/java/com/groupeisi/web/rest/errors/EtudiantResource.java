package com.groupeisi.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EtudiantResource {

    private final Logger log = LoggerFactory.getLogger(EtudiantResource.class);

    private final EtudiantService etudiantService;

    public EtudiantResource(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/etudiants")
    public List<EtudiantDTO> getAllEtudiants() {
        log.debug("REST request to get all Etudiants");
        return etudiantService.findAll();
    }
}
