import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 * @author a13561
 *
 */
public class Eratosthenes {

	private static final int SMALLEST_PRIME_NUMBER = 2;
	private List<Integer> primeList;

	public void getPrimeNumberList(int number) {
		if (number <= 0) {
			return;
		}
		
		primeList = new ArrayList<Integer>();
		
		for (int i = SMALLEST_PRIME_NUMBER; i < number; i++) {
			if (isPrimeNumber(i)) {
				primeList.add(i);
			}
		}
		
		return;
	}

	private boolean isPrimeNumber(int number) {
		if (number <= 0) {
			return false;
		}

		double root = Math.sqrt(number);
		
		for (int i = SMALLEST_PRIME_NUMBER; i <= root; i++) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < primeList.size(); i++) {
			buffer.append(primeList.get(i) + " ");
		}

		return buffer.toString();
	}
	
	/**
	 * @param args 使わない
	 */
	public static void main(String[] args) {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		int number;
		try {
			System.out.println("リストの最大値を整数で入力してください。");
			line = reader.readLine();	
			number = Integer.parseInt(line);
			if (number < 0) {
				System.out.println("自然数を入れてください。");
				return;
			}
		} catch (IOException e){
			System.out.println(e);
			return;
		} catch (NumberFormatException e) {
			System.out.println("数値形式を入れてください");
			return;
		}

		Eratosthenes eratosthenes = new Eratosthenes();
		
		eratosthenes.getPrimeNumberList(number);
			
		System.out.println(eratosthenes.toString());
	}

}
