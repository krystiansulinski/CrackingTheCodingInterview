package DeckOfCards;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
	public List<DeckOfCards> decks;

	BlackJack(int numberOfDecks) {
		if (numberOfDecks < 1 && numberOfDecks > 8) {
			throw new Error("The number of decks should be between 1 and 8");
		}

		this.decks = new ArrayList<>();

		for (int i = 0; i < numberOfDecks; i++) {
			this.decks.add(new DeckOfCards());
		}
	}
}
