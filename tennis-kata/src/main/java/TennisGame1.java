import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private int playerScore1 = 0;
    private int playerScore2 = 0;
    private String player1Name;
    private String player2Name;

    private String score = "";
    private int tempScore = 0;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerScore1 += 1;
        else
            playerScore2 += 1;
    }

    public String getScore() {

        if (playerScore1 == playerScore2) {
            pointsPlayers();
        } else if (playerScore1 >= 4 || playerScore2 >= 4) {
            playerAdvantageOrWinner();
        } else {
            pointsGameGeneral();
        }
        return score;
    }

    private String playerAdvantageOrWinner() {
        int minusResult = playerScore1 - playerScore2;
        if (minusResult == 1)  score = "Advantage player1";
        else if (minusResult == -1) score = "Advantage player2";
        else if (minusResult >= 2)  score = "Win for player1";
        else score = "Win for player2";
        return score;

    }

    private String pointsGameGeneral() {
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = playerScore1;
            else {
                score += "-";
                tempScore = playerScore2;
            }

                switch (tempScore) {
                    case 0:
                        score += "Love";
                        break;
                    case 1:
                        score += "Fifteen";
                        break;
                    case 2:
                        score += "Thirty";
                        break;
                    case 3:
                        score += "Forty";
                        break;
                }
        }
            return score;

    }

    /*private String tempScoreGame() {
        Map<Integer, String> tempScoregame = new HashMap<>();

        tempScoregame.put(0,"Love");
        tempScoregame.put(1,"Fifteen");
        tempScoregame.put(2,"Thirty");
        tempScoregame.put(3,"Forty");

        tempScoregame.containsKey(tempScore);
        score = tempScoregame.get(tempScore);

        return score;
    }*/

    private void pointsPlayers() {
        switch (playerScore1) {
            case 0:
                score = "Love-All";
                break;
            case 1:
                score = "Fifteen-All";
                break;
            case 2:
                score = "Thirty-All";
                break;
            default:
                score = "Deuce";
                break;

        }
    }
}
