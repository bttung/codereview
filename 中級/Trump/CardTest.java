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
		Card.Mark CLUB = Card.Mark.CLUB;
		Card.Mark SPADE = Card.Mark.SPADE;
		
		assertThat((CLUB.compareTo(SPADE) < 0), is(true));
	}
	
	@Test
	public void getMaxMark最も高いマークはスペード() {
		boolean isMax = true;
		for (Card.Mark mark : Card.Mark.values()) {
			if (mark.compareTo(Card.Mark.SPADE) > 0) {
				isMax = false;
			}
		}
		assertThat(isMax, is(true));
	}
}
