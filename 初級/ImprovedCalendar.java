import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Calendar;


/**
 * @author a13561
 * 月ごとのカレンダー
 */
public class ImprovedCalendar {
	private static final int DAY_OF_WEEK = 7;
	private static final int CALENDAR_ROW = 6;
	private int year;
	private int month;
	private int startDayOfWeek;		// 月の最初日は何曜日か
	private int dayOfMonth;			// 月の日の数
	// カレンダー日付の値を格納する行列
	private int[][] calendarValue = new int[CALENDAR_ROW][DAY_OF_WEEK];

	/*
     * 入力した値は適切な年かどうか
     * @return 入力した値は適切な年かどうか
	 */
	public boolean isValidYearInputed() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			System.out.println("年を入力してください");
			line = reader.readLine();
		} catch (IOException e){
			e.printStackTrace();
			return false;
		}

		try {
			year = Integer.parseInt(line);
		} catch (NumberFormatException e) {
			System.out.println("数値形式を入れてください");
			return false;
		}		

		if (year < 0) {
			System.out.println("年は整数を入れてください。");
			return false;
		}
		return true;
	}

	/*
     * 入力した値は適切な年かどうか
     * @return 入力した値は適切な月かどうか
	 */
	public boolean isValidMonthInputed() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			System.out.println("月を入力してください");
			line = reader.readLine();	
		} catch (IOException e){
			e.printStackTrace();
			return false;
		} 

		try {
			month = Integer.parseInt(line);
			if (month < 1 || month > 12) {
				System.out.println("月は1〜12をいれてください。");
				return false;
			}
			return true;
		} catch (NumberFormatException e) {
			System.out.println("数値形式を入れてください");
			return false;
		}
	}

	/*
	 * 月ごとカレンダーの詳細な値を計算する
	 */
	public void setMonthlyDataToCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);

		startDayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		dayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		int row = 0;
		int column = startDayOfWeek - 1;

		for (int i = 0; i < dayOfMonth; i++) {
			calendarValue[row][column++] = i + 1;
			if (column == DAY_OF_WEEK) {
				row++;
				column = 0;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder content = new StringBuilder();
		String tmpStr;
		for (int i = 0; i < calendarValue.length; i++) {
			for (int j = 0; j < calendarValue[i].length; j++) {
				if (calendarValue[i][j] == 0) {
					if (i == 0) {
						content.append("   ");
					}
				} else {
					tmpStr = String.format("%2d ", calendarValue[i][j]);
					content.append(tmpStr;
				}
			}
			content.append("\n");
		}
		return content.toString();
	}

	/**
	 * @param args 使わない
	 */
	public static void main(String args[]) {

		ImprovedCalendar calendar = new ImprovedCalendar();
		if (!calendar.isValidYearInputed()) {
			return;
		}

		if (!calendar.isValidMonthInputed()) {
			return;
		}

		calendar.setMonthlyDataToCalendar();

		System.out.println("日  月 火  水 木  金 土");
		System.out.print(calendar);
	}

}