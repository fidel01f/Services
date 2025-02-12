package services;

import model.Pet;
import model.PetResponse;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class PetService {
    private final RestTemplate restTemplate = new RestTemplate();
    private static final String EXTERNAL_API_URL = "https://petstore.swagger.io/#/pet/addPet";

    public PetResponse createPet(Pet pet) {
        String url = EXTERNAL_API_URL;


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");


        HttpEntity<Pet> request = new HttpEntity<>(pet, headers);
        ResponseEntity<Pet> response = restTemplate.exchange(url, HttpMethod.POST, request, Pet.class);

        if (response.getBody() != null) {
            Pet createdPet = response.getBody();


            System.out.println("Enviado a API externa:");
            System.out.println("ID: " + createdPet.getId());
            System.out.println("Nombre: " + createdPet.getName());
            System.out.println("Estado: " + createdPet.getStatus());


            return new PetResponse(createdPet.getId(), createdPet.getName(), createdPet.getStatus());
        }

        return null;
    }
}