package com.example.petclinic.service;

import com.example.petclinic.model.Visit;
import com.example.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService implements BasicService<Visit> {

    private VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {

        this.visitRepository = visitRepository;
    }

    @Override
    public Visit add(Visit visit) {

        return this.visitRepository.create(visit);
    }

    @Override
    public Visit get(Long id) {

        return this.visitRepository.read(new Visit(id));
    }

    @Override
    public Visit modify(Visit visit) {

        return this.visitRepository.update(visit);
    }

    @Override
    public boolean delete(Visit visit) {

        return this.visitRepository.delete(visit);
    }

    @Override
    public List<Visit> getAll() {

        return this.visitRepository.getAll();
    }
}
