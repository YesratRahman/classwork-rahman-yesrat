package animals.baseclasses;

public abstract class Carcharodon extends Lamnidae {

    public Carcharodon( String name ){
        super( name );
    }

    @Override
    public String getGenus() {
        return "animals.baseclasses.Carcharodon";
    }
}
