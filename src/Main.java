import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();

        for (int i = 0; i < deck.getDeck().length; i++) {
            System.out.println(deck.getDeck()[i].toString());
        }


    }
}