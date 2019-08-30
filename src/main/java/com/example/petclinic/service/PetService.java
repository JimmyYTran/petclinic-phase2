package com.example.petclinic.service;

import com.example.petclinic.model.Pet;
import com.example.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService implements BasicService<Pet> {

    private PetRepository petRepository;

    public PetService(PetRepository petRepository) {

        this.petRepository = petRepository;
    }

    @Override
    public Pet add(Pet pet) {

        return petRepository.create(pet);
    }

    @Override
    public Pet get(Long id) {

        return petRepository.read(new Pet(id));
    }

    @Override
    public Pet modify(Pet pet) {

        return petRepository.update(pet);
    }

    @Override
    public boolean delete(Pet pet) {

        return petRepository.delete(pet);
    }

    @Override
    public List<Pet> getAll() {

        return petRepository.getAll();
    }

}
