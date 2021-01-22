package animals.baseclasses;

public abstract class Chordate extends Animal {

    public Chordate( String name ){
        //call the constructor of the parent class
        //passing along the name
        super( name );
    }

    @Override
    public String getPhylum() {
        return "Chordata";
    }
}
