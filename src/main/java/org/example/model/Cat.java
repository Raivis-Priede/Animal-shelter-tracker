package org.example.model;

public final class Cat extends Animal{
    public Cat(AnimalId id, String name, int age){
        super(id,name,age);
    }

    public Cat(AnimalId id, String name)
    {
        super(id,name);
    }

    @Override
    public String getSpecies(){
        return "Cat";
    }
}
