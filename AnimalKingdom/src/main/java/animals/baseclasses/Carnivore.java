package animals.baseclasses;

public abstract class Carnivore extends Mammal {

    public Carnivore( String name ){
        super( name );
    }

    public void eatMeat(){
        System.out.println("the animal ate meat...");
    }

    @Override
    public String getAnimalOrder() {
        return "Carnivora";
    }
}
