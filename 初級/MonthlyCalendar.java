import java.util.Calendar;

/**
 * @author a13561
 * 月ごとのカレンダー
 */
public class MonthlyCalendar {
	private static final int DAY_OF_WEEK = 7;
	private static final int CALENDAR_ROW = 6;
	private int year;
	private int month;
	private int startDayOfWeek;		// 月の最初日は何曜日か
	private int dayOfMonth;			// 月の日の数
	// カレンダー日付の値を格納する行列
	private int[][] calendarValue = new int[CALENDAR_ROW][DAY_OF_WEEK];
	
	/**
	 * 月ごとカレンダークラスのコンストラクタ
	 * @param year 年
	 * @param month 月
	 */
	public MonthlyCalendar(int year, int month) {
		this.year = year;
		this.month = month;
		setMonthlyDataToCalendar();
	}
	
	/**
	 * 月ごとカレンダーの詳細な値を計算する
	 */
	private void setMonthlyDataToCalendar() {
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
		String tmpContent;
		for (int i = 0; i < calendarValue.length; i++) {
			for (int j = 0; j < calendarValue[i].length; j++) {
				if (calendarValue[i][j] == 0) {
					if (i == 0) {
						content.append("   ");
					}
				} else {
					tmpContent = String.format("%2d ", calendarValue[i][j]);
					content.append(tmpContent);
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
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		MonthlyCalendar monthlyCalendar = new MonthlyCalendar(year, month);
		System.out.println("日  月 火  水 木  金 土");
		System.out.println(monthlyCalendar.toString());
	}
	
}
