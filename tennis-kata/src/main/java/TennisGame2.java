import java.util.HashMap;
import java.util.Map;

public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (pointMinusOfFourt())
        {
            scorePlayersSet();
            score += "-All";
        }
        if (isDraw())
            score = "Deuce";

        if (pointPlayerSet(P1point, P2point)||pointPlayerSet(P2point, P1point))
        {
            scorePlayersSet();
            P2res = "Love";
            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (pointPlayersGame(P1point, P2point)||pointPlayersGame(P2point, P1point))
        {
            scorePlayerGame();
            score = P1res + "-" + P2res;
        }

        if (AdvantagePlayer(P1point, P2point))
        {
            score = "Advantage player1";
        }

        if (AdvantagePlayer(P2point, P1point))
        {
            score = "Advantage player2";
        }

        if (playerWinner(P1point, P2point))
        {
            score = "Win for player1";
        }
        if (playerWinner(P2point, P1point))
        {
            score = "Win for player2";
        }
        return score;
    }

    private boolean pointPlayersGame(int p1point, int p2point) {
        return p1point > p2point && p1point < 4;
    }

    private boolean playerWinner(int p1point, int p2point) {
        return p1point >= 4 && p2point >= 0 && (p1point - p2point) >= 2;
    }

    private boolean AdvantagePlayer(int p1point, int p2point) {
        return p1point > p2point && p2point >= 3;
    }

    private boolean pointPlayerSet(int p1point, int p2point) {
        return p1point > 0 && p2point == 0;
    }

    private boolean isDraw() {
        return P1point==P2point && P1point>=3;
    }

    private boolean pointMinusOfFourt() {
        return P1point == P2point && P1point < 4;
    }

    private void scorePlayersSet() {
        switch (P1point){
            case 0: score = "Love"; break;
            case 1: P1res = "Fifteen";
                    score = "Fifteen"; break;

            case 2: P1res = "Thirty";
                    score = "Thirty";break;
            case 3: P1res = "Forty"; break;
        }
        switch (P2point){
            case 1: P2res = "Fifteen"; break;
            case 2: P2res = "Thirty"; break;
            case 3: P2res = "Forty"; break;
        }
    }

    private void scorePlayerGame() {
        if (P1point==1)
            P1res="Fifteen";
        if (P1point==2)
            P1res="Thirty";
        if (P1point==3)
            P1res="Forty";
        if (P2point==1)
            P2res="Fifteen";
        if (P2point==2)
            P2res="Thirty";
        if (P2point==3)
            P2res="Forty";
    }

    public void setScoreGame(){
        for (int i = 0; i < 3; i++) {
            P1point++;
            P2point++;
        }
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1point++;
        else
            P2point++;
        }

}
