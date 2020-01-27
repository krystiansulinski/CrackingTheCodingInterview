/* 7.1 Deck of Cards
 * 
 * Design the data structures for a generic deck of cards. Explain how you would 
 * subclass the data structures to implement blackjack.
 */

package DeckOfCards;

import java.util.ArrayList;
import java.util.Collections;

import DeckOfCards.Card;

public class Deck<T extends Card> {
	private ArrayList<T> cards;
	private int dealtIndex = 0;

	public void setDeckOfCards(ArrayList<T> deckOfCards) {
		this.cards = deckOfCards;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public int remainingCards() {
		return cards.size() - dealtIndex;
	}

	public T[] dealHand(int number) {
		return null;
	}

	public T dealCard() {
		return null;
	}
}
