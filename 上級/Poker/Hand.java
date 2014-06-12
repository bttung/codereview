/**
 * @author a13561
 * 
 */
public enum Hand {
	ROYAL_STRAIGHT_FLASH() {
		@Override
		public String toString() {
			return "ロイヤルストレートフラッシュ";
		}
	},
	STRAIGHT_FLASH() {
		@Override
		public String toString() {
			return "ストレートフラッシュ";
		}
	},
	FOUR_CARD {
		@Override
		public String toString() {
			return "フォアカード";
		}
	},
	FULL_HOUSE {
		@Override
		public String toString() {
			return "フルハウス";
		}
	},
	FLASH {
		@Override
		public String toString() {
			return "フラッシュ";
		}
	},
	STRAIGHT {
		@Override
		public String toString() {
			return "ストレート";
		}
	},
	THREE_CARD {
		@Override
		public String toString() {
			return "スリーカード";
		}
	},
	TWO_PAIR {
		@Override
		public String toString() {
			return "ツウペア";
		}
	},
	ONE_PAIR {
		@Override
		public String toString() {
			return "ワンペア";
		}
	},
	NO_PAIR {
		@Override
		public String toString() {
			return "ノーペア";
		}
	};

	// ハンドの呼び方をゲットするs
	public abstract String toString();
}