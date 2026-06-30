package org.example.menu;

import org.example.model.*;
import org.example.shelter.Shelter;

import java.util.Scanner;

public class ConsoleMenu
{
    private final Shelter<Animal> shelter;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleMenu(Shelter<Animal> shelter)
    {
        this.shelter = shelter;
    }

    public void start()
    {
        boolean menuActive = true;
        while (menuActive)
        {
            printMenu();
            int userInput = scanner.nextInt();

            if (userInput == 0)
                menuActive = false;

            switch (userInput)
            {
                case 1:
                    printAddMenu();
                    break;
                case 2:
                    for (Animal a : shelter.getAllAnimals())
                    {
                        System.out.println(a);
                    }
                    break;
                case 3:
                    AnimalSpecies selectedSpecies = selectSpecies();
                    System.out.println("Found Animals:");
                    System.out.println(shelter.findBySpecies(selectedSpecies.name()));
                    break;
                case 4:
                    System.out.println("Available Animals:");
                    for (Animal a : shelter.findAvailableAnimals())
                    {
                        System.out.println(a);
                    }
                    break;
                case 5:
                    System.out.println("Enter animal ID to adopt:");
                    String idInput = scanner.next();
                    boolean success = shelter.markAsAdopted(idInput);
                    System.out.println((success) ? "Animal Adopted Successfully" : "ID not found");
                    break;
            }
            System.out.println();

        }
    }

    private void printMenu()
    {
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }

    private void printAddMenu()
    {
        AnimalSpecies selectedSpecies = selectSpecies();
        System.out.println("Input Name: ");
        String name = scanner.nextLine();

        System.out.println("Input Age: ");
        int age = scanner.nextInt();

        switch (selectedSpecies)
        {
            case BIRD:
                Animal newBird = new Bird(new AnimalId(), name, age);
                shelter.addAnimal(newBird);
                break;
            case CAT:
                Animal newCat = new Cat(new AnimalId(), name, age);
                shelter.addAnimal(newCat);
                break;
            case DOG:
                Animal newDog = new Dog(new AnimalId(), name, age);
                shelter.addAnimal(newDog);
                break;
            case FISH:
                Animal newFish = new Fish(new AnimalId(), name, age);
                shelter.addAnimal(newFish);
                break;
        }

        System.out.println("Animal added succesfully");
        System.out.println();

    }

    private AnimalSpecies selectSpecies()
    {
        System.out.println("Select Animal Species");

        AnimalSpecies[] animalSpecies = AnimalSpecies.values();

        int i = 1;

        for (AnimalSpecies animalSpecie : animalSpecies)
        {
            System.out.println(i++ + ". " + animalSpecie);
        }

        int choice = scanner.nextInt();

        scanner.nextLine();
        return animalSpecies[choice - 1];
    }
}
