package com.example.petclinic.service;

import com.example.petclinic.model.Vet;
import com.example.petclinic.repository.VetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VetService implements BasicService<Vet> {

    private VetRepository vetRepository;

    public VetService(VetRepository vetRepository) {

        this.vetRepository = vetRepository;
    }

    @Override
    public Vet add(Vet vet) {

        return this.vetRepository.create(vet);
    }

    @Override
    public Vet get(Long id) {

        return this.vetRepository.read(new Vet(id));
    }

    @Override
    public Vet modify(Vet vet) {

        return this.vetRepository.update(vet);
    }

    @Override
    public boolean delete(Vet vet) {

        return this.vetRepository.delete(vet);
    }

    @Override
    public List<Vet> getAll() {

        return this.vetRepository.getAll();
    }
}
