package animals.baseclasses;

import animals.interfaces.IAnimal;

public abstract class Animal implements IAnimal {

    private String name;

    public Animal( String name ){
        this.name = name;
    }

    public String getKingdom(){
        return "Animalia";
    }

    public String getName() {
        return name;
    }

//    public abstract String getPhylum();
//
//    public abstract String getAnimalClass();
//
//    public abstract String getAnimalOrder();
//
//    public abstract String getFamily();
//
//    public abstract String getGenus();
//
//    public abstract String getSpecies();


}
