package com.Servicios.controller;


import com.Servicios.model.Pet;
import com.Servicios.model.PetResponse;
import com.Servicios.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pet")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/{petId}")
    public Pet getPet(@PathVariable Long petId) {
        return petService.obtenerPetPorId(petId);
    }
    @PostMapping
    public ResponseEntity<PetResponse> createPet(@RequestBody Pet pet) {
        PetResponse petResponse = petService.createPet(pet);
        return ResponseEntity.ok(petResponse);
    }
}