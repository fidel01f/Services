package com.Servicios.client;

import com.Servicios.model.Pet;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class PetStoreClient {

    private final RestTemplate restTemplate;
    private final String PETSTORE_API_URL = "https://petstore.swagger.io/v2/pet/";

    public PetStoreClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Pet getPetById(Long petId) {
        String url = PETSTORE_API_URL + petId;
        return restTemplate.getForObject(url, Pet.class);
    }
    public Pet createPet(Pet pet) {
        return restTemplate.postForObject(PETSTORE_API_URL, pet, Pet.class);
    }

}