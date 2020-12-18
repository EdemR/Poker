import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                cards.add(new Card(Card.COLORS[i], j));
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}