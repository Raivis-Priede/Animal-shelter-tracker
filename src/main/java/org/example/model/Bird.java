package org.example.model;

public final class Bird extends Animal{
    public Bird(AnimalId id, String name, int age)
    {
        super(id,name,age);
    }
    public Bird(AnimalId id, String name)
    {
        super(id,name);
    }
    @Override
    public String getSpecies(){
        return "Bird";
    }
}
