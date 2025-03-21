public class Main {
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard(); // Kreiramo novi objekt za vođenje utakmica.

        // Pokretanje utakmica sa timovima iz Svjetskog kupa
        scoreboard.startMatch("Brazil", "Argentina");
        scoreboard.updateScore("Brazil", "Argentina", 2, 1);

        scoreboard.startMatch("France", "Germany");
        scoreboard.updateScore("France", "Germany", 3, 2);

        scoreboard.startMatch("Italy", "Spain");
        scoreboard.updateScore("Italy", "Spain", 1, 1);

        // Prikazivanje utakmica prema ukupnom broju golova
        System.out.println("Sortirane utakmice:");
        for (Match match : scoreboard.getOngoingMatchesSorted()) {
            System.out.println(match.getHomeTeam() + " " + match.getHomeScore() + " - " +
                    match.getAwayTeam() + " " + match.getAwayScore() + " (" + match.getMatchStatus() + ")");
        }
    }
}
