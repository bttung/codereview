import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author a13561
 *
 */
public class Histogram {

	private static final String GRAPH_ELEMENT = "*";
	private int width;
	private int height;
	private int[] histogramValue;
	
	/**
	 * @param args ヒストグラムの値
	 */
	public static void main(String[] args) {
		Histogram histogram = new Histogram();
		
		if (histogram.isValidInput(args)) {
			histogram.calcHistogramGraphSize(args);
			System.out.println(histogram);
		} 
	}
	
	/*
	 * 入力したパラメータは適切かどうか
	 * @param args ヒストグラムグラフのパラメーター
	 * @return 入力したパラメーターは適切かどうか
	 */
	public boolean isValidInput(String[] args) {
		if (args.length == 0) {
			System.out.println("グラフにプロットする値を因数に指定ください");
			return false;
		}
		
		String regex = "^[0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher;
		
		for (int i = 0; i < args.length; i++) {
			matcher = pattern.matcher(args[i]);
			if (!matcher.find()) {
				System.out.println("引数に指定できるのは数値のみです。");
				return false;
			}
		}
		
		return true;
	}
	
	/*
	 * ヒストグラムグラフのサイズを計算する
	 * @param ヒストグラムのパラメーター
	 */
	private void calcHistogramGraphSize(String args[]) {
		width = args.length;
		histogramValue = new int[width];
		for (int i = 0; i < width; i++) {
			histogramValue[i] = Integer.valueOf(args[i]).intValue();
		}
	
		height = 0;
		for (int i = 0; i < width; i++) {
			if (height < histogramValue[i]) {
				height = histogramValue[i];
			}
		}

		return;
	}
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 1; i <= height; i++) {
			for (int j = 0; j < width; j++) {
				if (i <= height - histogramValue[j]) {
					buffer.append(" ");
				} else {
					buffer.append(GRAPH_ELEMENT);
				}
			}
			buffer.append("\n");
		}
		
		return buffer.toString();
	}
	
}
