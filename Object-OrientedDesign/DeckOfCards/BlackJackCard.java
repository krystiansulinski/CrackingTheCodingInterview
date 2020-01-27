package DeckOfCards;

public class BlackJackCard extends Card {
	public BlackJackCard(int c, Suit s) {
		super(c, s);
	}

	@Override
	public int value() {
		if (isAce()) {
			return 1;
		} else if (faceValue >= 11 && faceValue <= 13) {
			return 10;
		}
		return faceValue;
	}

	public int minValue() {
		if (isAce()) {
			return 1;
		}
		return value();
	}

	public int maxValue() {
		if (isAce()) {
			return 11;
		}
		return value();
	}

	public boolean isAce() {
		return faceValue == 1;
	}

	public boolean isFaceCard() {
		return faceValue >= 11 && faceValue <= 13;
	}
}
