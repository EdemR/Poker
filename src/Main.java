import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
//        Deck deck = new Deck();
//        for (int i = 0; i < deck.getDeck().length; i++) {
//            System.out.println(deck.getDeck()[i].toString());
//        }

        game.createPlayer();
        game.createPlayer();
        game.play();
        System.out.println(game.playerList.get(0).getName() + "\n" + game.playerList.get(1).getName());

    }
}