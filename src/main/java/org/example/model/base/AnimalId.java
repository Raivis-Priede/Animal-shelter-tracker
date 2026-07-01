package org.example.model.base;

import java.util.Objects;
import java.util.UUID;

public final class AnimalId {
    private final String value;
    public AnimalId(){
        this.value = UUID.randomUUID().toString();
    }

    public AnimalId(String value){
        this.value = value;
    }

    @Override
    public boolean equals(Object o)
    {
        if(this == o)
        {
            return true;
        }
        if(o == null || getClass() != o.getClass())
        {
            return false;
        }

        AnimalId animalId = (AnimalId) o;
        return Objects.equals(value, animalId.value);
    }
    @Override
    public int hashCode()
    {
        return Objects.hashCode(value);
    }

    @Override
    public String toString(){
        return value;
    }
}
