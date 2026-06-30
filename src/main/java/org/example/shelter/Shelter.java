package org.example.shelter;

import org.example.model.AdoptionStatus;
import org.example.model.Animal;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shelter <T extends Animal>
{
    private final List<T> animals = new ArrayList<>();

    public void addAnimal(T animal)
    {
        animals.add(animal);
    }

    public List<T> getAllAnimals()
    {
        List<T> allAnimals = new ArrayList<>();
        allAnimals.addAll(animals);
        return allAnimals;
    }

    public List<T> findBySpecies(String species)
    {
        List<T> specificSpeciesList = new ArrayList<>();
        for (T animal : animals)
        {
            if(animal.getSpecies().equalsIgnoreCase(species))
            {
                specificSpeciesList.add(animal);
            }
        }
        return specificSpeciesList;
    }
    public List<T> sortByName()
    {
        List<T> sorted = new ArrayList<>(animals);
        sorted.sort(Comparator.comparing(Animal::getName));

        return sorted;
    }
    public List<T> sortByAge()
    {
        List<T> sorted = new ArrayList<>(animals);
        sorted.sort(Comparator.comparingInt(Animal::getAge));

        return sorted;
    }

    public List<T> findAvailableAnimals()
    {
        List<T> availableAnimals = new ArrayList<>();

        for (T animal : animals)
        {
            if (animal.getAdoptionStatus() == AdoptionStatus.AVAILABLE)
                availableAnimals.add(animal);
        }
        return availableAnimals;
    }

    public boolean markAsAdopted(String id)
    {
        T animal = findById(id);
        if(animal != null)
        {
            animal.markAsAdopted();
            return true;
        }
        return false;
    }

    public T findById(String id)
    {
        for (T animal : animals)
        {
            if(animal.getId().toString().equals(id))
            {
                return animal;
            }
        }
        return null;
    }
}
