package org.example.model;

public final class Dog extends Animal{
    public Dog(AnimalId id, String name, int age){
        super(id,name,age);
    }

    public Dog(AnimalId id, String name)
    {
        super(id,name);
    }
    @Override
    public String getSpecies(){
        return "Dog";
    }
}
