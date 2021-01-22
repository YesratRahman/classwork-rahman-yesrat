package animals.baseclasses;

import animals.baseclasses.Chondrichthye;

public abstract class Lamniforme extends Chondrichthye {
    public Lamniforme( String name ){
        super( name );
    }

    @Override
    public String getAnimalOrder() {
        return "Lamniformes";
    }
}
