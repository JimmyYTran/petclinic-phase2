package com.example.petclinic.repository;

import com.example.petclinic.model.Visit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VisitRepository extends BasicRepository implements CrudRepository<Visit> {

    @Override
    public Visit create(Visit visit) {

        return this.fakeDatabase.save(visit);
    }

    @Override
    public Visit read(Visit visit) {

        return this.fakeDatabase.get(visit);
    }

    @Override
    public Visit update(Visit visit) {

        return this.fakeDatabase.modify(visit);
    }

    @Override
    public boolean delete(Visit visit) {

        return this.fakeDatabase.delete(visit);
    }

    @Override
    public List<Visit> getAll() {

        return this.fakeDatabase.getAll(Visit.class.getSimpleName().toLowerCase());
    }
}
