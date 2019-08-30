package com.example.petclinic.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Visit implements Modifiable {

    private Long id;
    private Date dateOfVisit;
    private String description;
    private Pet pet;
    private List<Vet> vets;

    public Visit() {

    }

    public Visit(Long id) {

        this(id, null, null);
    }

    public Visit(Long id, Date dateOfVisit, String description) {

        this.id = id;
        this.dateOfVisit = dateOfVisit;
        this.description = description;
        this.pet = new Pet();
        this.vets = new ArrayList<>();
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(Date dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addPet(Pet pet) {
        addPet(pet, true);
    }

    public void addPet(Pet pet, boolean updateRelationship) {
        this.pet = pet;
        if (updateRelationship) {
            pet.addVisit(this, false);
        }
    }

    public void removePet(Pet pet) {
        removePet(pet, true);
    }

    public void removePet(Pet pet, boolean updateRelationship) {
        this.pet = null;
        if (updateRelationship) {
            pet.removeVisit(this, false);
        }
    }

    public void addVet(Vet vet) {
        addVet(vet, true);
    }

    public void addVet(Vet vet, boolean updateRelationship) {
        vets.add(vet);
        if (updateRelationship) {
            vet.addVisit(this, false);
        }
    }

    public void removeVet(Vet vet) {
        removeVet(vet, true);
    }

    public void removeVet(Vet vet, boolean updateRelationship) {
        vets.remove(vet);
        if (updateRelationship) {
            vet.removeVisit(this, false);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visit visit = (Visit) o;
        return Objects.equals(id, visit.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Visit{");
        sb.append("id=").append(id);
        sb.append(", dateOfVisit=").append(dateOfVisit);
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
