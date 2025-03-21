public class Main {
    public static void main(String[] args) {
        Scoreboard scoreboard = new Scoreboard(); // Kreiramo novi objekt za vođenje utakmica.

        // Pokretanje utakmica s timovima iz Serie A
        scoreboard.startMatch("Juventus", "AC Milan");
        scoreboard.updateScore("Juventus", "AC Milan", 2, 1);

        scoreboard.startMatch("Roma", "Inter Milan");
        scoreboard.updateScore("Roma", "Inter Milan", 3, 2);

        scoreboard.startMatch("Napoli", "Lazio");
        scoreboard.updateScore("Napoli", "Lazio", 1, 1);

        // Prikazivanje utakmica prema ukupnom broju golova
        System.out.println("Sortirane utakmice:");
        for (Match match : scoreboard.getOngoingMatchesSorted()) {
            System.out.println(match.getHomeTeam() + " " + match.getHomeScore() + " - " +
                    match.getAwayTeam() + " " + match.getAwayScore() + " (" + match.getMatchStatus() + ")");
        }
    }
}
