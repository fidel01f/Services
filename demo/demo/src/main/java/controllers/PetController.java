package controllers;

import model.Pet;
import model.PetResponse;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import services.PetService;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetResponse> createPet(@RequestBody Pet pet) {
        PetResponse response = petService.createPet(pet);
        return (response != null) ? ResponseEntity.ok(response) : ResponseEntity.badRequest().build();
    }
}