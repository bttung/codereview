import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * @author a13561
 * じゃーけーんクラス
 */
public class JankenImproved {
	// 出す手の種類
	private static final int RPS_TYPE = 3;
	// 出す手とその呼び方
	private static final Map<String, String> dictionary = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{put("1", "グー");}
		{put("2", "チョキ");}
		{put("3", "パー");}
	};
	// ゲームの結果ステータス
	private static final String WIN = "win";
	private static final String DRAW = "draw";
	private static final String LOSE = "lose";
	// ゲームのメッセージ
	private static final Map<String, String> gameMessage = new HashMap<String, String>() {
		private static final long serialVersionUID = 1L;
		{put(WIN, "あなたの勝ちです！");}
		{put(DRAW, "あいこでした！");}
		{put(LOSE, "あなたの負けです！");}
	};
	// インプットエラーメッセージ
	private static final String INPUT_ERROR_MESSAGE = 1 + "~" + RPS_TYPE + "で入力してください！";
	// 入力エラー時のエラーコード
	private static final int INPUT_ERROR_CODE = -1;	

	public static void main(String[] args) {
		gameGuide();
		String gameResult = "";

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			while (gameResult.equals("") || gameResult.equals(DRAW)) {
				System.out.print("出すてを入力 => ");
				String line = reader.readLine();
				while (!isValidInput(line)) {
					System.out.print("出すてを入力 => ");
					line = reader.readLine();
				}
				gameResult = compete(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * ゲームガイド
	 */
	private static void gameGuide() {
		System.out.println("じゃんけんをしましょう！");
		for (int i = 1; i <= RPS_TYPE; i++) {
			System.out.print(i + ":" + dictionary.get(i + "") + " ");
		}
		System.out.println("です");
		System.out.println("じゃーけーん・・");
	}
	

	/*
 	 * 入力した値は適切かどうかを確認する
 	 * @param input 入力した文字列
 	 * return 入力した値は適切かどうか
 	 */
	private static boolean isValidInput(String input) {
		// 判定するパターンを生成する
		String regex = String.format("^[%d-%d]$", 1, RPS_TYPE);
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);

		if (matcher.find()) {
			return true;
		}

		return false;
	}

	/*
	 * ユーザの入力を受け取り,intに返す
	 * @param input：入力文字列
	 * @return 入力した整数
	 */
	private static int getUserRPS(String input) {
		return Integer.valueOf(input).intValue();
	}	

	/*
	 * コンピュータから出す手を生成する
	 * @return パソコンが生成した整数
	 */
	private static int getComputerRPS() {
		return (int) (Math.random() * RPS_TYPE + 1); 
	}

	/*
	 * コンピュータとの勝負
	 * @param input キーボードからの入力
	 * @return ゲーム結果
	 */
	private static String compete(String input) {
		int userRPS = getUserRPS(input);
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
		return competeResult;
	}
}