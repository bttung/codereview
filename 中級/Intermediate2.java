package intermediate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author a13561
 *　
 */
public class Intermediate2 {	
	/*
	 * 重複しない要素を取り出す
	 * @param src 入力数字列
	 * @return 重複な要素を削除した配列
	 * @throws java.lang.NullPointerException ヌーリポインター
	 */
	public static int[] uniq(int[] src) {
		if (src == null) {
			throw new NullPointerException();
		}
		
		if (src.length == 0) {
			return null;
		}

		List<Integer> uniqueList = new ArrayList<Integer> ();

		// 重複しない要素を探す
		uniqueList.add(src[0]);
		for (int i = 1; i < src.length; i++) {
			if (src[i] != src[i-1]) {
				uniqueList.add(src[i]);
			}
		}
				
		// リストから配列に変換する
		int[] uniqueArray = new int[uniqueList.size()];
		for (int i = 0; i < uniqueList.size(); i++) {
			uniqueArray[i] = uniqueList.get(i);
		}
		
		return uniqueArray;
	}
}
