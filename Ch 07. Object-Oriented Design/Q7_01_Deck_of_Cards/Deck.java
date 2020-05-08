/* 7.1 Deck of Cards
 * 
 * Design the data structures for a generic deck of cards. Explain how you would 
 * subclass the data structures to implement blackjack.
 */

package Q7_01_Deck_of_Cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck<T extends Card> {
    private final int dealtIndex = 0;
    private ArrayList<T> cards;

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
