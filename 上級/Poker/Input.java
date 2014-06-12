import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author a13561
 *
 */
public class Input {

	/*
	 * 入力を受け取る
	 * @return 入力した文字列
	 */
	public String getInput() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));		
		String line = "";
		while (!isValidInput(line)) {
			try {
				System.out.print("交換したいカードを入れてください");
				line = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return line;
	}
	
	/*
	 * 入力が適切かどうかの確認
	 * @param input 入力
	 * @return 入力が適切かどうか
	 */
	public boolean isValidInput(String input) {
		if (input.length() > Poker.NUMBER_OF_CARD) {
			System.out.println(Poker.NUMBER_OF_CARD + "枚以上は交換できません");
			return false;
		} else if (input.length() == 0) {
			return false;
		}
		
		// 正数字かどうかのチェック
		String regex = "^[1-9]+$";
		Pattern pattern = Pattern.compile(regex);
		if (!pattern.matcher(input).find()) {
			System.out.println("数字のみ入力してください");
			return false;
		}
		
		Set<String> set = new HashSet<String>();
		for (char c : input.toCharArray()) {
			// 入力した数字は範囲内かどうか確認する
			if (Integer.valueOf(String.valueOf(c)).intValue() > Poker.NUMBER_OF_CARD) {
				System.out.println("入力した数字は対応しない");
				return false;
			} else {
				// 重複チェック
				if (set.contains(String.valueOf(c))) {
					System.out.println("重複した入力がある");
					return false;
				} else {
					set.add(String.valueOf(c));
				}
			}
		}
		
		return true;
	}
	
	/*
	 * 数字の文字列から数字リストを返す
	 * @param input 入力文字列
	 * @return 文字列に入る数字リストを返す
	 */
	public List<Integer> getIndexList(String input) {
		List<Integer> list = new ArrayList<Integer>();
		for (char c : input.toCharArray()) {
			list.add(Integer.valueOf(String.valueOf(c)).intValue());
		}
		return list;
	}
}
