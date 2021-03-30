public class TennisGame3 implements TennisGame {
    
    private int scorePlayer2;
    private int scorePlayer1;
    private String NamePlayer1;
    private String NamePlayer2;

    private String scoreGameTennis;

    public TennisGame3(String NamePlayer1, String NamePlayer2) {
        this.NamePlayer1 = NamePlayer1;
        this.NamePlayer2 = NamePlayer2;
    }

    public String getScore() {
        if (playerAdvantageOfGame()) {
            String[] NameOfPoint = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            scoreGameTennis = NameOfPoint[scorePlayer1];
            return ScorePlayers(NameOfPoint);
        }
        if (IsGameDraw())
                return "Deuce";
            scoreGameTennis = AdvantangeOrWinnerPlayer();
            return getScoreGameTennis();
    }

    private boolean IsGameDraw() {
        return scorePlayer1 == scorePlayer2;
    }

    private String getScoreGameTennis() {
        return (scorePlayer1 - scorePlayer2) * (scorePlayer1 - scorePlayer2) == 1 ? "Advantage " + scoreGameTennis : "Win for " + scoreGameTennis;
    }

    private String AdvantangeOrWinnerPlayer() {
        return scorePlayer1 > scorePlayer2 ? NamePlayer1 : NamePlayer2;
    }

    private String ScorePlayers(String[] NameOfPoint) {
        return (IsGameDraw()) ? scoreGameTennis + "-All" : scoreGameTennis + "-" + NameOfPoint[scorePlayer2];
    }

    private boolean playerAdvantageOfGame() {
        return scorePlayer1 < 4 && scorePlayer2 < 4 && !(scorePlayer1 + scorePlayer2 == 6);
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;
        
    }

}