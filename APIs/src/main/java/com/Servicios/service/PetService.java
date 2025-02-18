package com.Servicios.service;

import com.Servicios.client.PetStoreClient;
import com.Servicios.model.Pet;
import com.Servicios.model.PetResponse;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;


@Service
public class PetService {

    private final PetStoreClient petStoreClient;

    public PetService(PetStoreClient petStoreClient) {
        this.petStoreClient = petStoreClient;
    }

    public Pet obtenerPetPorId(Long petId) {
        Pet pet = petStoreClient.getPetById(petId);


        System.out.println("Pet ID: " + pet.getId());
        System.out.println("Name: " + pet.getName());
        System.out.println("Status: " + pet.getStatus());

        return pet;
    }

    public PetResponse createPet(Pet pet) {

        Pet createdPet = petStoreClient.createPet(pet);


        String transactionId = UUID.randomUUID().toString();


        LocalDateTime dateCreated = LocalDateTime.now();


        PetResponse petResponse = new PetResponse();
        petResponse.setTransactionId(transactionId);
        petResponse.setDateCreated(dateCreated);
        petResponse.setStatus(createdPet.getStatus());
        petResponse.setName(createdPet.getName());


        System.out.println("Transaction ID: " + petResponse.getTransactionId());
        System.out.println("Date Created: " + petResponse.getDateCreated());
        System.out.println("Status: " + petResponse.getStatus());
        System.out.println("Name: " + petResponse.getName());

        return petResponse;
    }
}