import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Game game = new Game();
        game.createPlayers(5);
        game.play();
    }
}