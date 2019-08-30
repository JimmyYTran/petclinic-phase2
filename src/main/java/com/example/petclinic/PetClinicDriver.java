package com.example.petclinic;

import com.example.petclinic.config.ExitCodeConfiguration;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.petclinic.controller.OwnerController;
import com.example.petclinic.controller.PetController;
import com.example.petclinic.controller.VetController;
import com.example.petclinic.controller.VisitController;
import com.example.petclinic.model.*;
import com.example.petclinic.repository.OwnerRepository;
import com.example.petclinic.repository.PetRepository;
import com.example.petclinic.repository.VetRepository;
import com.example.petclinic.repository.VisitRepository;
import com.example.petclinic.service.OwnerService;
import com.example.petclinic.service.PetService;
import com.example.petclinic.service.VetService;
import com.example.petclinic.service.VisitService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PetClinicDriver {

    private static ConfigurableApplicationContext context;

    private static OwnerController ownerController;
    private static PetController petController;
    private static VisitController visitController;
    private static VetController vetController;

    public static void main(String[] args) {

        // Need reference to Spring IoC container (its context)
        context = SpringApplication.run(PetClinicDriver.class, args);

        testApp();
    }

    private static void testApp() {

        // Owner dependency injection (DI) setup
        /*
        OwnerRepository ownerRepository = new OwnerRepository();
        OwnerService ownerService = new OwnerService(ownerRepository);
        OwnerController ownerController = new OwnerController(ownerService);

        PetRepository petRepository = new PetRepository();
        PetService petService = new PetService(petRepository);
        PetController petController = new PetController(petService);

        VisitRepository visitRepository = new VisitRepository();
        VisitService visitService = new VisitService(visitRepository);
        VisitController visitController = new VisitController(visitService);

        VetRepository vetRepository = new VetRepository();
        VetService vetService = new VetService(vetRepository);
        VetController vetController = new VetController(vetService);
        */
        ownerController = (OwnerController)context.getBean("ownerController");
        petController = (PetController)context.getBean("petController");
        visitController = (VisitController)context.getBean("visitController");
        vetController = (VetController)context.getBean("vetController");


        // ***** Owner testing *****

        // create our owners
        Owner owner1 = new Owner(1L, "Homer Simpson", "742 Evergreen Terrace", "Springfield", "9395550113");
        Owner owner2 = new Owner(2L, "Marge Simpson", "742 Evergreen Terrace", "Springfield", "9395550113");
        Owner owner3 = new Owner(3L, "Lisa Simpson", "742 Evergreen Terrace", "Springfield", "9395550113");
        Owner owner4 = new Owner(4L, "Bart Simpson", "742 Evergreen Terrace", "Springfield", "9395550113");

        // save owners to database
        ownerController.add(owner1);
        ownerController.add(owner2);
        ownerController.add(owner3);
        ownerController.add(owner4);

        // get all owners from database and display them
        List<Owner> owners = ownerController.getAll();
        display(owners);

        // create some pets and add them to an existing owner
        Pet pet1 = new Pet(1L, "Godzilla", new Date(), PetType.LIZARD);
        Pet pet2 = new Pet(2L, "Santa's Little Helper", new Date(), PetType.DOG);
        owner4.addPet(pet1);
        owner4.addPet(pet2);

        Pet pet3 = new Pet(1L, "Strangles", new Date(), PetType.SNAKE);
        Pet pet4 = new Pet(2L, "Stompy", new Date(), PetType.ELEPHANT);

        petController.add(pet1);
        petController.add(pet2);
        petController.add(pet3);
        petController.add(pet4);

        display(petController.getAll());

        // ***** Visit *****

        Visit visit1 = new Visit(1L, new Date(), "description");
        Visit visit2 = new Visit(2L, new Date(), "description");

        visitController.add(visit1);
        visitController.add(visit2);

        display(visitController.getAll());

        // ***** Vet *****
        List<Speciality> specialities = new ArrayList<Speciality>() {{
            add(Speciality.DENTISTRY);
            add(Speciality.RADIOLOGY);
        }};

        Vet vet1 = new Vet(1L, "Veterinarian", specialities);

        vetController.add(vet1);

        display(vetController.getAll());

        // Try to add/remove a pet from owner4
        owner4.getPets().stream()
                .map(s -> s.getName())
                .forEach(System.out::println);

        owner4.removePet(pet1);
        owner4.addPet(pet3);
        owner4.addPet(pet4);

        System.out.println("\nAfter pet addition/removal: \n");
        owner4.getPets().stream()
                .map(s -> s.getName())
                .forEach(System.out::println);

        // Remove pet3 from owner4

        pet3.removeOwner(owner4);

        System.out.println("\nAfter pet addition/removal: \n");
        owner4.getPets().stream()
                .map(s -> s.getName())
                .forEach(System.out::println);
    }

    private static void display(Object obj) {

        if (obj instanceof List) {

            List<?> list = (List) obj;
            for (Object o : list) {
                System.out.println("\t" + o);
            }

        } else {

            System.out.println(obj);

        }

        System.out.println();
    }

}
