package com.example.petclinic.controller;

import com.example.petclinic.model.Pet;
import com.example.petclinic.service.PetService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PetController implements BasicController<Pet> {

    private PetService petService;

    public PetController(PetService petService) {

        this.petService = petService;
    }

    @Override
    public Pet add(Pet pet) {

        return this.petService.add(pet);
    }

    @Override
    public Pet get(Long id) {

        return this.petService.get(id);
    }

    @Override
    public Pet modify(Pet pet) {

        return this.petService.modify(pet);
    }

    @Override
    public boolean delete(Pet pet) {

        return this.petService.delete(pet);
    }

    @Override
    public List<Pet> getAll() {

        return this.petService.getAll();

    }
}
