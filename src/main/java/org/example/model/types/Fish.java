package org.example.model.types;

import org.example.model.base.Animal;
import org.example.model.base.AnimalId;

public final class Fish extends Animal
{
    public Fish(AnimalId id, String name, int age){
        super(id,name,age);
    }

    public Fish(AnimalId id, String name)
    {
        super(id,name);
    }
    @Override
    public String getSpecies(){
        return "Fish";
    }
}
