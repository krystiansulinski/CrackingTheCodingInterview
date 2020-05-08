package Q7_01_Deck_of_Cards;

public enum Suit {
    Clubs(0), Diamonds(1), Hearts(2), Spades(3);

    private final int value;

    Suit(int v) {
        value = v;
    }

    public static Suit getSuitFromValue(int value) {
        switch (value) {
            case 0:
                return Clubs;
            case 1:
                return Diamonds;
            case 2:
                return Hearts;
            case 3:
                return Spades;
            default:
                break;
        }
        throw new Error("Select a value 0-3");
    }

    public int getValue() {
        return value;
    }
}
