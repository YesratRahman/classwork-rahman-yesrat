package poker;

public abstract class Card implements ICard {

    String suit;
    int value;

    public Card( String suit, int value ){
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String getSuit() {
        return suit;
    }

    @Override
    public int getValue() {
        return value;
    }

}
