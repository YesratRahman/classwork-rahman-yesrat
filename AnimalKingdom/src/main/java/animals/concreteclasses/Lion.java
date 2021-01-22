package animals.concreteclasses;

import animals.baseclasses.Panthera;
import animals.interfaces.Cowardly;
import animals.interfaces.Furry;

public class Lion extends Panthera implements Cowardly, Furry {

    public Lion( String name ){
        super( name );
    }

    @Override
    public String getSpecies() {
        return "Leo";
    }

    @Override
    public void runAway() {

    }

    @Override
    public void shed() {

    }
}
