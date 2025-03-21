import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scoreboard {

    private final List<Match> matches = new ArrayList<>();

    // Početak nove utakmice sa statusom IN_PROGRESS
    public void startMatch(String homeTeam, String awayTeam) {
        matches.add(new Match(homeTeam, awayTeam));
    }

    // Ažuriranje rezultata utakmice
    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        Match match = matches.stream()
                .filter(m -> m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Utakmica nije pronađena!"));

        match.setHomeScore(homeScore);
        match.setAwayScore(awayScore);
    }

    // Završi utakmicu i ukloni je iz liste
    public void finishMatch(String homeTeam, String awayTeam) {
        matches.removeIf(match -> match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam));
    }

    // Dohvati sve utakmice koje su u tijeku
    public List<Match> getOngoingMatches() {
        return matches.stream()
                .filter(match -> match.getMatchStatus() == Match.MatchStatus.IN_PROGRESS)
                .collect(Collectors.toList());
    }

    // Dohvati sve završene utakmice
    public List<Match> getFinishedMatches() {
        return matches.stream()
                .filter(match -> match.getMatchStatus() == Match.MatchStatus.FINISHED)
                .collect(Collectors.toList());
    }

    // Dohvati sortirane utakmice (po ukupnom broju golova, a zatim po vremenu početka)
    public List<Match> getOngoingMatchesSorted() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::getTotalScore).reversed()
                        .thenComparing(Match::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}
