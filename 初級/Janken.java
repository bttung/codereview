import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;

/**
 * @author a13561
 * じゃんけんクラス
 */
public class Janken {
	// 出す手の種類
	public static final int RPS_TYPE = 3;
	// 出す手とその呼び方
	public static final Map<String, String> dictionary = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{put("1", "グー");}
		{put("2", "チョキ");}
		{put("3", "パー");}
	};
	// ゲームの結果ステータス
	public static final String WIN = "win";
	public static final String DRAW = "draw";
	public static final String LOSE = "lose";
	// ゲームのメッセージ
	public static final Map<String, String> gameMessage = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{put(WIN, "あなたの勝ちです！");}
		{put(DRAW, "あいこでした！");}
		{put(LOSE, "あなたの負けです！");}
	};
	// インプットエラーメッセージ
	public static final String INPUT_ERROR_MESSAGE = 1 + "~" + RPS_TYPE + "で入力してください！";
	// 入力エラー時のエラーコード
	public static final int INPUT_ERROR_CODE = -1;	

	public static void main(String[] args) {
		gameGuide();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("出すてを入力 => ");
		try {
			String line = reader.readLine();
			compete(line);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ゲームガイド
	 */
	public static void gameGuide() {
		System.out.println("じゃんけんをしましょう！");
		for (int i = 1; i <= RPS_TYPE; i++) {
			System.out.print(i + ":" + dictionary.get(i + "") + " ");
		}
		System.out.println("です");
		System.out.println("じゃーけーん・・");
	}
	
	/*
	 * ユーザの入力を受け取り,intに返す
	 * @param input：入力文字列
	 * @return 入力した整数
	 */
	public static int getUserRPS(String input) {
		try {
			int userRPS = Integer.parseInt(input);
			if (userRPS < 1 || userRPS > RPS_TYPE) {
				System.out.println(INPUT_ERROR_MESSAGE);
				return INPUT_ERROR_CODE;
			} else {
				return userRPS;
			}
		} catch (NumberFormatException e){
			System.out.println(INPUT_ERROR_MESSAGE);
			return INPUT_ERROR_CODE;
		}
	}

	/*
	 * コンピュータから出す手を生成する
	 * @return パソコンが生成した整数
	 */
	public static int getComputerRPS() {
		return (int) (Math.random() * RPS_TYPE + 1); 
	}

	/*
	 * コンピュータとの勝負
	 * @param input キーボードからの入力
	 */
	public static void compete(String input) {
		int userRPS = getUserRPS(input);
		if (userRPS != INPUT_ERROR_CODE) {
			int computerRPS = getComputerRPS();
			System.out.println("ぼん！");
			System.out.println("あなた：" + dictionary.get(userRPS + "")  + "、" + "コンピュータ：" + dictionary.get(computerRPS + ""));

			String competeResult = "";

			if (userRPS < computerRPS) {
				if (userRPS == 1 && computerRPS == RPS_TYPE) {
					competeResult = LOSE;
				} else {
					competeResult = WIN;
				}
			} else if (userRPS > computerRPS) {
				if (userRPS == RPS_TYPE && computerRPS == 1) {
					competeResult = WIN;
				} else {
					competeResult = LOSE;
				}
			} else {
				competeResult = DRAW;
			}
			System.out.println(gameMessage.get(competeResult));
		}
	}

}