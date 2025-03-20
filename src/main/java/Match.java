import java.time.LocalDateTime;

public class Match {

    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final LocalDateTime startTime;
    private MatchStatus matchStatus;

    // Enum za status utakmice
    public enum MatchStatus {
        IN_PROGRESS, // Utakmica u tijeku
        FINISHED     // Utakmica završena
    }

    public Match(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = 0;
        this.awayScore = 0;
        this.startTime = LocalDateTime.now(); // Bilježi trenutak početka utakmice
        this.matchStatus = MatchStatus.IN_PROGRESS; // Početni status je IN_PROGRESS
    }

    // Getteri za timove
    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    // Getteri za rezultat
    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    // Setteri za rezultat
    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    // Metoda za ukupni broj golova
    public int getTotalScore() {
        return homeScore + awayScore;
    }

    // Metoda za vrijeme početka utakmice
    public LocalDateTime getStartTime() {
        return startTime;
    }

    // Getter za status utakmice
    public MatchStatus getMatchStatus() {
        return matchStatus;
    }

    // Setter za status utakmice
    public void setMatchStatus(MatchStatus matchStatus) {
        this.matchStatus = matchStatus;
    }
}
