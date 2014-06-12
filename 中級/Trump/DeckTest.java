import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * @author a13561
 *
 */
public class DeckTest {
	
	@Test
	public void createAscendCardCollection昇順のデックを作る() {
		Deck deck = new Deck(3);
		List<Card> cardCollection = deck.getCardCollection();
		Card currentCard;
		Card nextCard;
		boolean wellSorted = true;
		
		for (int i = 0; i < cardCollection.size() - 1; i++) {
			currentCard = cardCollection.get(i);
			nextCard = cardCollection.get(i + 1);
			if (currentCard.compareTo(nextCard) > 0) {
				wellSorted = false;
				break;
			}
		}
		assertThat(wellSorted, is(true));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void drawTrumpデックにある枚数以上のカードを引く() {
		Deck deck = new Deck(2);
		// カードをシャップルする
		deck.shuffle();		
		deck.drawTrump(100);
	}
	
	@Test
	public void drawTrumpデックから一部のカードを引く() {
		Deck deck = new Deck(3);
		// カードをシャップルする
		deck.shuffle();
		int numberOfCardBeforeDraw = deck.getCardCollection().size();
		int drawCardsNumber = 10;
		if (drawCardsNumber <= deck.getCardCollection().size()) {
			deck.drawTrump(drawCardsNumber);
			assertThat(deck.getCardCollection().size(), 
					is(numberOfCardBeforeDraw - drawCardsNumber));
		}
	}
}
