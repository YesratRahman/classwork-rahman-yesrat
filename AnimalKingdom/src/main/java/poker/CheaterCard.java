package poker;

public class CheaterCard implements ICard {
    @Override
    public String getSuit() {
        //add logic to figure out best suit
        return null;
    }

    @Override
    public int getValue() {
        //add logic to figure out best value
        return 0;
    }
}
