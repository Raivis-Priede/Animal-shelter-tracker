package org.example.model.base;
import lombok.Getter;
import org.example.model.types.Bird;
import org.example.model.types.Cat;
import org.example.model.types.Dog;
import org.example.model.types.Fish;

@Getter
public sealed abstract class Animal permits Dog, Cat, Bird, Fish
{
    private final AnimalId id;
    private String name;
    private int age;
    private AdoptionStatus adoptionStatus;

    protected Animal(AnimalId id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.adoptionStatus = AdoptionStatus.AVAILABLE;
    }
    protected  Animal(AnimalId id, String name){
        this(id,name,0);
    }

    public void markAsAdopted(){
        this.adoptionStatus = AdoptionStatus.ADOPTED;
    }

    public abstract String getSpecies();

    @Override
    public String toString(){
        return id + " | " + name + " | " + age + " years old | " + getSpecies() + " | " + adoptionStatus;
    }
}
