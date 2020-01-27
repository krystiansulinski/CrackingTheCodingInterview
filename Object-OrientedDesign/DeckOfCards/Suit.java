package DeckOfCards;

public enum Suit {
	Clubs(0), Diamonds(1), Hearts(2), Spades(3);

	private int value;

	private Suit(int v) {
		value = v;
	}

	public int getValue() {
		return value;
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
}
