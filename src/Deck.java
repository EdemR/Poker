public class Deck {
    private final int numberOfCards = 52;
    private final Card[] deck = new Card[numberOfCards];

    public Deck() {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                Card card = new Card(Card.COLORS[i], j);
                deck[temp++] = card;
            }
        }
    }

    public Card[] getDeck() {
        return deck;
    }
}