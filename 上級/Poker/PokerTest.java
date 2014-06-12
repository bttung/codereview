import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author a13561
 *
 */
public class PokerTest {

	@Test
	public void checkRoyalStraightFlash() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 10));
		cardList.add(new Card(Mark.DYER, 11));
		cardList.add(new Card(Mark.DYER, 12));
		cardList.add(new Card(Mark.DYER, 13));
		cardList.add(new Card(Mark.DYER, 1));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.ROYAL_STRAIGHT_FLASH));
	}	
	
	
	@Test
	public void checkStraightFlash() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 3));
		cardList.add(new Card(Mark.DYER, 4));
		cardList.add(new Card(Mark.DYER, 5));
		cardList.add(new Card(Mark.DYER, 6));
		cardList.add(new Card(Mark.DYER, 7));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.STRAIGHT_FLASH));
	}		
	
	@Test
	public void checkFourCard() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 6));
		cardList.add(new Card(Mark.CLUB, 6));
		cardList.add(new Card(Mark.SPADE, 6));
		cardList.add(new Card(Mark.SPADE, 6));
		cardList.add(new Card(Mark.DYER, 3));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.FOUR_CARD));
	}		
	
	
	@Test
	public void checkFullHouse() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 6));
		cardList.add(new Card(Mark.CLUB, 6));
		cardList.add(new Card(Mark.SPADE, 6));
		cardList.add(new Card(Mark.SPADE, 3));
		cardList.add(new Card(Mark.DYER, 3));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.FULL_HOUSE));
	}	
	
	
	@Test
	public void checkFlash() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 5));
		cardList.add(new Card(Mark.DYER, 1));
		cardList.add(new Card(Mark.DYER, 7));
		cardList.add(new Card(Mark.DYER, 10));
		cardList.add(new Card(Mark.DYER, 13));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.FLASH));
	}		
	
	@Test
	public void checkStraight() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.CLUB, 5));
		cardList.add(new Card(Mark.DYER, 6));
		cardList.add(new Card(Mark.HEART, 7));
		cardList.add(new Card(Mark.SPADE, 8));
		cardList.add(new Card(Mark.DYER, 9));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.STRAIGHT));
	}	
	
	@Test
	public void checkThreeCard() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 10));
		cardList.add(new Card(Mark.HEART, 10));
		cardList.add(new Card(Mark.CLUB, 10));
		cardList.add(new Card(Mark.DYER, 1));
		cardList.add(new Card(Mark.DYER, 3));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.THREE_CARD));
	}	
	
	@Test
	public void checkTwoPair() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 10));
		cardList.add(new Card(Mark.HEART, 1));
		cardList.add(new Card(Mark.CLUB, 10));
		cardList.add(new Card(Mark.DYER, 1));
		cardList.add(new Card(Mark.DYER, 3));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.TWO_PAIR));
	}

	@Test
	public void checkOnePair() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 10));
		cardList.add(new Card(Mark.HEART, 1));
		cardList.add(new Card(Mark.CLUB, 10));
		cardList.add(new Card(Mark.DYER, 8));
		cardList.add(new Card(Mark.DYER, 3));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.ONE_PAIR));
	}	
	
	@Test
	public void checkNoPair() {
		Poker poker = new Poker();
		
		List<Card> cardList = new ArrayList<Card>();
		cardList.add(new Card(Mark.DYER, 10));
		cardList.add(new Card(Mark.HEART, 1));
		cardList.add(new Card(Mark.CLUB, 7));
		cardList.add(new Card(Mark.DYER, 8));
		cardList.add(new Card(Mark.DYER, 3));		
		
		poker.setCardList(cardList);
		
		assertThat(poker.checkHand(), is(Hand.NO_PAIR));
	}		
	
}
