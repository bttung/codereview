import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

/**
 * @author a13561
 * カードのテストクラス
 */
public class CardTest {
	@Test
	public void compareToクラブはスペードより小さい() {
		Mark CLUB = Mark.CLUB;
		Mark SPADE = Mark.SPADE;
		
		assertThat((CLUB.compareTo(SPADE) < 0), is(true));
	}
	
	@Test
	public void getMaxMark最も高いマークはスペード() {
		boolean isMax = true;
		for (Mark mark : Mark.values()) {
			if (mark.compareTo(Mark.SPADE) > 0) {
				isMax = false;
			}
		}
		assertThat(isMax, is(true));
	}
}
