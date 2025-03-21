import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ScoreboardTest {

    @Test
    public void testStartMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Brazil", "Germany");

        // Provjerava da li je utakmica započeta
        assertEquals(1, scoreboard.getOngoingMatches().size());
        assertEquals("Brazil", scoreboard.getOngoingMatches().get(0).getHomeTeam());
        assertEquals("Germany", scoreboard.getOngoingMatches().get(0).getAwayTeam());
        assertEquals(0, scoreboard.getOngoingMatches().get(0).getHomeScore());
        assertEquals(0, scoreboard.getOngoingMatches().get(0).getAwayScore());
    }

    @Test
    public void testUpdateScore() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Argentina", "France");
        scoreboard.updateScore("Argentina", "France", 2, 1);

        // Provjerava ažuriranje rezultata utakmice
        assertEquals(2, scoreboard.getOngoingMatches().get(0).getHomeScore());
        assertEquals(1, scoreboard.getOngoingMatches().get(0).getAwayScore());
    }

    @Test
    public void testFinishMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Italy", "Spain");
        scoreboard.finishMatch("Italy", "Spain");

        // Provjerava da li je utakmica ispravno završena
        assertEquals(0, scoreboard.getOngoingMatches().size());
    }

    @Test
    public void testGetOngoingMatchesSorted() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Brazil", "Germany");
        scoreboard.updateScore("Brazil", "Germany", 3, 2);  // Ukupni score: 5

        scoreboard.startMatch("Argentina", "France");
        scoreboard.updateScore("Argentina", "France", 2, 2); // Ukupni score: 4

        scoreboard.startMatch("Italy", "Spain");
        scoreboard.updateScore("Italy", "Spain", 1, 1); // Ukupni score: 2

        // Provjerava da li je ispravno sortirano prema ukupnom broju golova
        List<Match> sortedMatches = scoreboard.getOngoingMatchesSorted();
        assertEquals("Brazil", sortedMatches.get(0).getHomeTeam());  // Brazil-Germany, score 5
        assertEquals("Argentina", sortedMatches.get(1).getHomeTeam());    // Argentina-France, score 4
        assertEquals("Italy", sortedMatches.get(2).getHomeTeam());     // Italy-Spain, score 2
    }
}
