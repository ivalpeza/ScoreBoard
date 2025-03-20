import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ScoreboardTest {

    @Test
    public void testStartMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Juventus", "Milan");

        // Provjerava da li je utakmica započeta
        assertEquals(1, scoreboard.getOngoingMatches().size());
        assertEquals("Juventus", scoreboard.getOngoingMatches().get(0).getHomeTeam());
        assertEquals("Milan", scoreboard.getOngoingMatches().get(0).getAwayTeam());
        assertEquals(0, scoreboard.getOngoingMatches().get(0).getHomeScore());
        assertEquals(0, scoreboard.getOngoingMatches().get(0).getAwayScore());
    }

    @Test
    public void testUpdateScore() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Napoli", "Roma");
        scoreboard.updateScore("Napoli", "Roma", 2, 1);

        // Provjerava ažuriranje rezultata utakmice
        assertEquals(2, scoreboard.getOngoingMatches().get(0).getHomeScore());
        assertEquals(1, scoreboard.getOngoingMatches().get(0).getAwayScore());
    }

    @Test
    public void testFinishMatch() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Inter", "Atalanta");
        scoreboard.finishMatch("Inter", "Atalanta");

        // Provjerava da li je utakmica ispravno završena
        assertEquals(0, scoreboard.getOngoingMatches().size());
    }

    @Test
    public void testGetOngoingMatchesSorted() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startMatch("Juventus", "Milan");
        scoreboard.updateScore("Juventus", "Milan", 2, 3);  // Ukupni score: 5

        scoreboard.startMatch("Napoli", "Roma");
        scoreboard.updateScore("Napoli", "Roma", 3, 1); // Ukupni score: 4

        scoreboard.startMatch("Inter", "Atalanta");
        scoreboard.updateScore("Inter", "Atalanta", 1, 2); // Ukupni score: 3

        // Provjerava da li je ispravno sortirano prema ukupnom broju golova
        List<Match> sortedMatches = scoreboard.getOngoingMatchesSorted();
        assertEquals("Juventus", sortedMatches.get(0).getHomeTeam());  // Juventus-Milan, score 5
        assertEquals("Napoli", sortedMatches.get(1).getHomeTeam());    // Napoli-Roma, score 4
        assertEquals("Inter", sortedMatches.get(2).getHomeTeam());     // Inter-Atalanta, score 3
    }
}
