import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 真数変換プログラム
 */

/**
 * @author a13561
 *
 */
public class Intermediate1 {

	private static final int DIVISOR = 2;
	
	/**
	 * @param args　使わない
	 */
	public static void main(String[] args) {
		Intermediate1.toBinaryString("0");
	}

	/*
	 * @param src 進数変換したい文字列
	 * @return 変換された文字列
	 */
	public static String toBinaryString(String src) {
		String regex = "^[0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(src);
		
		if (matcher.find()) {
			int input = Integer.valueOf(src).intValue();
			
			// 変換結果を格納する文字列
			StringBuffer buffer = new StringBuffer();
			int remainder = 0;
			do {
				remainder = input % DIVISOR;
				input /= DIVISOR;
				buffer.append(remainder);
			} while (input > 0);
			
			return buffer.reverse().toString();
		} else {
			throw new IllegalArgumentException("");
		}		
	}
}
