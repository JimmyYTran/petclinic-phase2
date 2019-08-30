package com.example.petclinic.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class represents a pet owner.
 */
public class Owner implements Modifiable {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String phoneNumber;

    // associations
    private List<Pet> pets;

    public Owner() {

    }

    public Owner(Long id) {

        this(id, null, null, null, null);
    }

    public Owner(Long id, String name, String address, String city, String phoneNumber) {

        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.pets = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Update the relationship between Pet and Owner when adding a Pet
    public void addPet(Pet pet) {

        addPet(pet, true);
    }

    public void addPet(Pet pet, Boolean updateRelationship) {

        pets.add(pet);
        if(updateRelationship) {
            pet.addOwner(this, false);
        }
    }

    // Update the relationship between Pet and Owner when removing a Pet
    public void removePet(Pet pet) {

        removePet(pet, true);
    }

    public void removePet(Pet pet, Boolean updateRelationship) {

        pets.remove(pet);
        if (updateRelationship) {
            pet.removeOwner(this, false);
        }
    }

    public List<Pet> getPets() {
        return this.pets;
    }

    /*
    Only include id when generating equals and hashcode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return id == owner.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Owner{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append(", phoneNumber='").append(phoneNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
