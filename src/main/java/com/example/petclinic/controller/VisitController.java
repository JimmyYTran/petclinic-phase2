package com.example.petclinic.controller;

import com.example.petclinic.model.Visit;
import com.example.petclinic.service.VisitService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class VisitController implements BasicController<Visit> {

    private VisitService visitService;

    public VisitController(VisitService visitService) {

        this.visitService = visitService;
    }

    @Override
    public Visit add(Visit visit) {

        return this.visitService.add(visit);
    }

    @Override
    public Visit get(Long id) {

        return this.visitService.get(id);
    }

    @Override
    public Visit modify(Visit visit) {

        return this.visitService.modify(visit);
    }

    @Override
    public boolean delete(Visit visit) {

        return this.visitService.delete(visit);
    }

    @Override
    public List<Visit> getAll() {

        return this.visitService.getAll();

    }
}
