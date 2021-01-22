package animals.baseclasses;

import animals.baseclasses.Feline;

public abstract class Panthera extends Feline {

    public Panthera( String name ){
        super( name );
    }

    @Override
    public String getGenus() {
        return "animals.baseclasses.Panthera";
    }
}
