package ohad.levin.chess;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    public static Board board;
    public static Constants constants;
    public static GameManager gameManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        board = new Board();
        constants = new Constants();
        gameManager = new GameManager(this);

    }
}
