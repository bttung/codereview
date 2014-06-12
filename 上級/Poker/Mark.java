import java.util.EnumSet;

/**
 * @author a13561
 * 
 */
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
	public abstract String toString();
}
