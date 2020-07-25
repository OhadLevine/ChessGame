package ohad.levin.chess;

import android.app.AlertDialog;

import ohad.levin.chess.pieces.King;

public class GameManager {
    private GameActivity gameActivity;

    public GameManager(GameActivity gameActivity) {
        this.gameActivity = gameActivity;
    }

    public void resetGame() {
        createPieces();
    }

    private void createPieces() {
        King Whiteking = new King(true);
        King blackking = new King(false);
    }

    public void alert(AlertDialog.Builder ad, String message) {

    }
}
