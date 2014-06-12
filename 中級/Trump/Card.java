import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @author a13561
 *　カードクラス
 */
public class Card implements Comparable<Card>{

	public static final int MAX_NUMBER = 13;
	
	public enum Mark {
		CLUB(1) {
			@Override
			public String toString() {
				return "♣︎";
			}
		},
		DYER(2) {
			@Override
			public String toString() {
				return "♦︎";
			}
		},
		HEART(3) {
			@Override
			public String toString() {
				return "♥︎";
			}
		},
		SPADE(4) {
			@Override
			public String toString() {
				return "♠";
			}
		};
		
		// マークの値
		private int value;
		
		Mark(int value) {
			this.value = value;
		}
		
		/*
		 * マーカーに紐づいた値
		 */
		public int getValue() {
			return value;
		}

		/*
		 * @return マーカの種類の数
		 */
		public static int getNumberOfElements() {
			return EnumSet.allOf(Mark.class).size();
		}
		
		// マークの記号取得する抽象関数
		public abstract  String toString();
	}

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
