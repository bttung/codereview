import java.util.Collections;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author a13561
 * デッククラス
 */
public class Deck {

	private int jokerSheetsCount;
	private List<Card> cardCollection;
	
	/*
	 * コンストラクタ
	 * @param jokerSheetsCountジョーカーの数
	 */
	Deck(int jokerSheetsCount) {
		this.jokerSheetsCount = jokerSheetsCount;
		// 昇順のコレクションを作る
		createAscendCardCollection();
	}
	
	public List<Card> getCardCollection() {
		return cardCollection;
	}
	
	/*
	 * 昇順のカードコレクションを作る
	 */
	private void createAscendCardCollection() {
		cardCollection = new ArrayList<Card> ();

		// 一般なカードを全部生成し、カードマネジャーに追加する
		for (Card.Mark mark : Card.Mark.values()) {
			for (int i = 0; i < Card.MAX_NUMBER; i++) {
				Card card = new Card(mark, i);
				cardCollection.add(card);
			}
		}
		
		// ジョーカーを生成し、カードマネジャーに追加する
		for (int i = 0; i < jokerSheetsCount; i++) {	
			Card joker = new Card(Card.getMaxMark(), Card.MAX_NUMBER + 1);
			cardCollection.add(joker);
		}
	}
	
	/*
	 * デックをソートする
	 */
	public void sort() {
		Collections.sort(cardCollection);
	}
	
	/*
	 * デックをシャップルする
	 */
	public void shuffle() {
		Collections.shuffle(cardCollection);
	}
	
	/*
	 * デックからカードを引く
	 * @param cardsNumber引くカードの枚数
	 */
	public void drawTrump(int cardsNumber) {
		if (cardsNumber < 0 || cardsNumber > cardCollection.size()) throw new IllegalArgumentException();
		int removeIndex;
		for (int i = 0; i < cardsNumber; i++) {
			removeIndex = (int) (Math.random() * cardCollection.size());
			cardCollection.remove(removeIndex);
		}
	}

}
