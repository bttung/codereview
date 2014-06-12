/**
 * @author a13561
 *　カードクラス
 */
public class Card implements Comparable<Card>{

	public static final int MAX_NUMBER = 13;

	// カード番号
	public int number;	
	// マークのタイプ
	public Mark mark;
	
	/*
	 * コンストラクタ
	 * @param markカードのマーク
	 * @param numberカードの数字
	 */
	Card(Mark mark, int number) {
		this.mark = mark;
		this.number = number;
	}

	/*
	 * @return最も高いマークを取得する
	 */
	public static Mark getMaxMark() {
		Mark maxMark = Mark.CLUB;
		for (Mark mark : Mark.values()) {
			if (mark.compareTo(maxMark) > 0) {
				maxMark = mark;
			}
		}
		return maxMark;
	}
	
	@Override
	public int compareTo(Card opponentCard) {
		int myRanking = this.mark.getValue() * MAX_NUMBER + this.number;
		int opponentRanking = opponentCard.mark.getValue() * MAX_NUMBER + opponentCard.number;
		
		return myRanking - opponentRanking;
	}

	@Override
	public String toString() {
		return "Mark: " + this.mark.toString() +  " number: " + this.number;
	}
	
}
