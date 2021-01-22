package animals.baseclasses;

public abstract class Feline extends Carnivore {

    public Feline( String name ){
        super( name );
    }

    @Override
    public String getFamily() {
        return "Felidae";
    }

    public void meow(){
        System.out.println("Meow");
    }
}
