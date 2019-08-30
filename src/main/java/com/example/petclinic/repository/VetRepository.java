package com.example.petclinic.repository;

import com.example.petclinic.model.Vet;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VetRepository extends BasicRepository implements CrudRepository<Vet> {

    @Override
    public Vet create(Vet vet) {

        return this.fakeDatabase.save(vet);
    }

    @Override
    public Vet read(Vet vet) {

        return this.fakeDatabase.get(vet);
    }

    @Override
    public Vet update(Vet vet) {

        return this.fakeDatabase.modify(vet);
    }

    @Override
    public boolean delete(Vet vet) {

        return this.fakeDatabase.delete(vet);
    }

    @Override
    public List<Vet> getAll() {

        return this.fakeDatabase.getAll(Vet.class.getSimpleName().toLowerCase());
    }

}
