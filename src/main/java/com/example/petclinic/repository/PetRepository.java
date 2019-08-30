package com.example.petclinic.repository;

import com.example.petclinic.model.Pet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetRepository extends BasicRepository implements CrudRepository<Pet> {

    @Override
    public Pet create(Pet pet) {

        return this.fakeDatabase.save(pet);
    }

    @Override
    public Pet read(Pet pet) {

        return this.fakeDatabase.get(pet);
    }

    @Override
    public Pet update(Pet pet) {

        return this.fakeDatabase.modify(pet);
    }

    @Override
    public boolean delete(Pet pet) {

        return this.fakeDatabase.delete(pet);
    }

    @Override
    public List<Pet> getAll() {

        return this.fakeDatabase.getAll(Pet.class.getSimpleName().toLowerCase());
    }
}
