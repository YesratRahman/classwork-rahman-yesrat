package animals.concreteclasses;

import animals.baseclasses.Carcharodon;

public class GreatWhiteShark extends Carcharodon {

    public GreatWhiteShark( String name ){
        super(name);
    }

    @Override
    public String getSpecies() {
        return "carcharias";
    }

}
