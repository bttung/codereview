import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author a13561
 *
 */
public class Poker {

	public static final int NUMBER_OF_CARD = 5;
	private List<Card> cardList;
	private Deck deck;
	
	Poker() {
		deck = new Deck(0);
		cardList = deck.drawTrump(NUMBER_OF_CARD);
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	
	/*
	 * デックのなかに入るカードと交換する
	 */
	public void exchange(List<Integer> exchangeIndex) {
		List<Card> tmpCard = deck.drawTrump(exchangeIndex.size());
		int index = 0;
		for (int i = 0; i < exchangeIndex.size(); i++, index++) {
			cardList.set(exchangeIndex.get(i) - 1, tmpCard.get(index));
		}
	}
	
	/*
	 * 持っているカードリストのランキングを探す
	 * @return カードリストのランキングを返す
	 */
	public Hand checkHand() {
		if (cardList.size() < 1) { 
			return null;
		}
		
		// ストレートとフラッシュをチェックするためのフラッグ
		boolean straight = true;
		boolean flash = true;
		// カード番号を記録するリスト
		List<Integer> cardNumberList = new ArrayList<Integer>();
		
		// フラッシュの確認
		Mark mark = cardList.get(0).mark;
		for (Card card : cardList) {
			if (mark.compareTo(card.mark) != 0) {
				flash = false;
			}
			cardNumberList.add(card.number);
		}
		
		Collections.sort(cardNumberList);
		
		// ロイヤルストレートフラッシュかどうかの確認
		List<Integer> specialList = Arrays.asList(1, 10, 11, 12, 13);
		Collections.sort(specialList);

		if (flash && cardNumberList.equals(specialList)) {
			return Hand.ROYAL_STRAIGHT_FLASH;
		}
		
		// ストレートの確認
		for (int i = 0; i < cardNumberList.size() - 1; i++) {
			if (cardNumberList.get(i) + 1 != cardNumberList.get(i+1)) {
				straight = false;
			}
		}
		
		if (straight && flash) {
			return Hand.STRAIGHT_FLASH;
		}
		
		if (flash) {
			return Hand.FLASH;
		}
		
		if (straight) {
			return Hand.STRAIGHT;
		}
		
		// 重複チェック
		Map<Integer, Integer> duplicateMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < cardNumberList.size(); i++) {
			if (duplicateMap.containsKey(cardNumberList.get(i))) {
				duplicateMap.put(cardNumberList.get(i), duplicateMap.get(cardNumberList.get(i)) + 1);
			} else {
				duplicateMap.put(cardNumberList.get(i), 1);
			}
		}
		
		// 出現回数をリストに格納する
		List<Integer> appearedCountList = new ArrayList<Integer>();
		for (Map.Entry<Integer, Integer> entry : duplicateMap.entrySet()) {
			appearedCountList.add(entry.getValue());
		}
		
		Collections.sort(appearedCountList);
		Collections.reverse(appearedCountList);
		
		if (appearedCountList.get(0) == 4) {
			return Hand.FOUR_CARD;
		} else if (appearedCountList.get(0) == 3) {
			if (appearedCountList.get(1) == 2) {
				return Hand.FULL_HOUSE;				
			} else {
				return Hand.THREE_CARD;
			}
		} else if (appearedCountList.get(0) == 2 && appearedCountList.get(1) == 2) {
			return Hand.TWO_PAIR;
		} else if (appearedCountList.get(0) == 2) {
			return Hand.ONE_PAIR;
		}
		
		return Hand.NO_PAIR;
	}
	
	/*
	 * 持っているカードリストをプリントする
	 */
	public void printCardList() {
		int i = 0;
		for (Card card : cardList) {
			i++;
			System.out.println(i + ": " + card.mark.toString() + " " + card.number);
		}
	}
	
	/*
	 * ゲーム関数
	 * @param args パラメータは使わない
	 */
	public static void main(String[] args) {
		Poker poker = new Poker();
		poker.printCardList();
		
		Input input = new Input();
		String str = input.getInput();
		poker.exchange(input.getIndexList(str));
		poker.printCardList();
		
		System.out.println(poker.checkHand().toString());
	}
}
